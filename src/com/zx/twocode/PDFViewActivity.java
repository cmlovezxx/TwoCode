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

	PDFView pdfView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		pdfView = (PDFView) findViewById(R.id.pdfView);
		String fileUrl = getIntent().getStringExtra("url");
		File folder = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath()+"/QRcode_pdf_cache");
		String filename = fileUrl.substring(fileUrl.lastIndexOf("/")+1);
		boolean exist = false;
		for (File f:folder.listFiles()) {
			if(f.getName().equals(filename)){
				loadPDF("/"+filename);
				exist = true;
				Log.e("exist", exist+"");
				break;
			}
		}
		if(!exist){
			download(fileUrl);
		}
	}

	public void loadPDF(String filename){
		String path = Environment.getExternalStorageDirectory()
				.getAbsolutePath()+"/QRcode_pdf_cache";

		File f = new File(path+filename);
		
		pdfView.fromFile(f).defaultPage(1).showMinimap(true)
				.enableSwipe(true).onLoad(null)
				.onPageChange(null).enableDoubletap(true)
				.load();
	}
	public void download(String path) {
		final String filename = path.substring(path.lastIndexOf("/"));
		HttpUtils http = new HttpUtils();
		http.download(path, Environment.getExternalStorageDirectory()
				.getAbsolutePath()+"/QRcode_pdf_cache" + filename, true, true,
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
