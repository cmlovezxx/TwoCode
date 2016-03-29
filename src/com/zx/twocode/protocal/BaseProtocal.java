package com.zx.twocode.protocal;

import com.zx.twocode.global.ConstantValue;
import com.zx.twocode.http.HttpHelper;
import com.zx.twocode.http.HttpHelper.HttpResult;

public abstract class BaseProtocal<T> {
	// 1.load(String)方法
	public T load(String... params) {
		// 方法中首先加载服务器，loadServer
		String json = loadServer(params);
		// 其次解析json
		if (json != null) {
			return paserJson(json);
		}

		return null;
	}

	/**
	 * 假数据放在这个抽象方法里，发布时删掉
	 * 
	 * @return
	 */
	// public abstract T paserData();

	// 解析json需要子类根据自己的数据解析
	public abstract T paserJson(String json);

	private String loadServer(String... params) {

		HttpResult httpResult = HttpHelper.get(ConstantValue.SERVER_URL
				+ getRequestParams(params));
		if (httpResult == null)
			return null;
		String json = httpResult.getString();
		return json;
	}

	// 得到请求参数，并且形成一个例如?requestcode=003&equipmentcode=EHS-6000012的请求
	private String getRequestParams(String... params) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < params.length - 1; i += 2) {
			sb.append(params[i] + "=" + params[i + 1]);
			if (i < params.length - 2) {
				sb.append("&");
			}

		}
		return sb.toString();
	}
}
