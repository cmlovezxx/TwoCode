package com.zx.twocode.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

import android.text.TextUtils;
import android.util.Log;

import com.lidroid.xutils.util.IOUtils;
import com.zx.twocode.utils.LogUtils;

public class HttpHelper {

	// public static final String URL =
	// "http://192.168.8.125:6001/Switches.aspx?";

	// 外网地址
	// http://218.24.232.66:99/Switches.aspx?requestcode=004
	public static final String URL = "http://218.24.232.66:99/Switches?";

	/** get���󣬻�ȡ�����ַ������� */
	public static HttpResult get(String url) {
		HttpGet httpGet = new HttpGet(url);
		return execute(url, httpGet);
	}

	/** post���󣬻�ȡ�����ַ������� */
	public static HttpResult post(String url, byte[] bytes) {
		HttpPost httpPost = new HttpPost(url);
		ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bytes);
		httpPost.setEntity(byteArrayEntity);
		return execute(url, httpPost);
	}

	/** ���� */
	public static HttpResult download(String url) {
		HttpGet httpGet = new HttpGet(url);
		return execute(url, httpGet);
	}

	/** ִ��������� */
	private static HttpResult execute(String url, HttpRequestBase requestBase) {
		boolean isHttps = url.startsWith("https://");// �ж��Ƿ���Ҫ����https
		AbstractHttpClient httpClient = HttpClientFactory.create(isHttps);
		HttpContext httpContext = new SyncBasicHttpContext(
				new BasicHttpContext());
		HttpRequestRetryHandler retryHandler = httpClient
				.getHttpRequestRetryHandler();// ��ȡ���Ի���
		int retryCount = 0;
		boolean retry = true;
		while (retry) {
			try {
				HttpResponse response = httpClient.execute(requestBase,
						httpContext);// ��������
				if (response != null) {
					return new HttpResult(response, httpClient, requestBase);
				}
			} catch (Exception e) {
				IOException ioException = new IOException(e.getMessage());
				retry = retryHandler.retryRequest(ioException, ++retryCount,
						httpContext);// �Ѵ����쳣�������Ի��ƣ����ж��Ƿ���Ҫ��ȡ����
				LogUtils.e(e);
				Log.e("retry", "times:" + retryCount);
			}
		}
		return null;
	}

	/** http�ķ��ؽ���ķ�װ������ֱ�Ӵ��л�ȡ���ص��ַ��������� */
	public static class HttpResult {
		private HttpResponse mResponse;
		private InputStream mIn;
		private String mStr;
		private HttpClient mHttpClient;
		private HttpRequestBase mRequestBase;

		public HttpResult(HttpResponse response, HttpClient httpClient,
				HttpRequestBase requestBase) {
			mResponse = response;
			mHttpClient = httpClient;
			mRequestBase = requestBase;
		}

		public int getCode() {
			StatusLine status = mResponse.getStatusLine();
			return status.getStatusCode();
		}

		/** �ӽ���л�ȡ�ַ�����һ����ȡ�����Զ����������Ұ��ַ������棬�����´λ�ȡ */
		public String getString() {
			if (!TextUtils.isEmpty(mStr)) {
				return mStr;
			}
			InputStream inputStream = getInputStream();
			ByteArrayOutputStream out = null;
			if (inputStream != null) {
				try {
					out = new ByteArrayOutputStream();
					byte[] buffer = new byte[1024 * 4];
					int len = -1;
					while ((len = inputStream.read(buffer)) != -1) {
						out.write(buffer, 0, len);
					}
					byte[] data = out.toByteArray();
					mStr = new String(data, "utf-8");
				} catch (Exception e) {
					LogUtils.e(e);
				} finally {
					IOUtils.closeQuietly(out);
					close();
				}
			}
			return mStr;
		}

		/** ��ȡ������Ҫʹ����Ϻ����close�����ر��������� */
		public InputStream getInputStream() {
			if (mIn == null && getCode() < 300) {
				HttpEntity entity = mResponse.getEntity();
				try {
					mIn = entity.getContent();
				} catch (Exception e) {
					LogUtils.e(e);
				}
			}
			return mIn;
		}

		/** �ر��������� */
		public void close() {
			if (mRequestBase != null) {
				mRequestBase.abort();
			}
			IOUtils.closeQuietly(mIn);
			if (mHttpClient != null) {
				mHttpClient.getConnectionManager().closeExpiredConnections();
			}
		}
	}
}
