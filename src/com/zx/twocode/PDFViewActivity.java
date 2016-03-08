package com.zx.twocode;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.joanzapata.pdfview.PDFView;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

public class PDFViewActivity extends Activity {

	private PDFView pdfView;
	// private boolean exist = false;
	// private File folder = null;
	private String localPath;
	private String fileUrl;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_pdf_view);
		pdfView = (PDFView) findViewById(R.id.pdfView);
		fileUrl = getIntent().getStringExtra("url");

		if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
			// folder = new File(Environment.getExternalStorageDirectory()
			// .getAbsolutePath() + "/QRcode_pdf_cache");
			localPath = Environment.getExternalStorageDirectory()
					.getAbsolutePath() + "/QRcode_pdf_cache";
		} else {
			// folder = new File(getCacheDir().getAbsolutePath()
			// + "/QRcode_pdf_cache");
			localPath = getCacheDir().getAbsolutePath() + "/QRcode_pdf_cache";
		}
		download(fileUrl, localPath);
		// folder = new File(getCacheDir().getAbsolutePath() +
		// "/QRcode_pdf_cache");
		// String filename = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
		// Log.e("Test", exist + "");
		// if (folder.listFiles() != null) {
		// for (File f : folder.listFiles()) {
		// if (f.getName().equals(filename)) {
		// exist = true;
		// // loadPDF("/" + filename);
		//
		// Log.e("exist", exist + "");
		// break;
		// }
		// }
		// }
		// if (exist) {
		// loadPDF("/" + filename);
		// } else {
		//
		// download(fileUrl);
		// }
		// Log.e("Test", exist + "");
	}

	public void loadPDF(String filename) {
		// String path = Environment.getExternalStorageDirectory()
		// .getAbsolutePath() + "/QRcode_pdf_cache";

		File f = new File(localPath + filename);

		pdfView.fromFile(f).defaultPage(1).showMinimap(true).enableSwipe(true)
				.onLoad(null).onPageChange(null).enableDoubletap(true).load();
	}

	public void download(String urlPath, String localPath) {
		final String filename = urlPath.substring(urlPath.lastIndexOf("/"));
		HttpUtils http = new HttpUtils();
		http.download(urlPath, localPath + filename, true, true,
				new RequestCallBack<File>() {

					@Override
					public void onStart() {
						// tvInfo.setText("正在连接...");
						Log.e("download", "正在连接");
					}

					@Override
					public void onLoading(long total, long current,
							boolean isUploading) {
						// tvInfo.setText(current + "/" + total);
						Log.e("download", "下载" + current + "/" + total);
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						// tvInfo.setText(msg);
						Log.e("download", "失败: " + msg);
						// if
						// (msg.equals("maybe the file has downloaded completely"))
						// {
						//
						// loadPDF("/" + filename);
						// }
						loadPDF(filename);
					}

					@Override
					public void onSuccess(ResponseInfo<File> responseInfo) {
						// TODO Auto-generated method stub
						// tvInfo.setText("downloaded:" +
						// responseInfo.result.getPath());
						Log.e("download", "成功");
						loadPDF(filename);
					}
				});

	}

}
