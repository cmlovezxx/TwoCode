package com.zx.twocode.protocal;

import android.os.SystemClock;

import com.google.gson.Gson;
import com.zx.twocode.bean.DocumentListBean;

public class DocumentProtocal extends BaseProtocal<DocumentListBean> {

	@Override
	public DocumentListBean paserJson(String json) {
		// Gson gson = new Gson();
		// DocumentListBean docListBean = (DocumentListBean) gson.fromJson(json,
		// DocumentListBean.class);
		// return docListBean;
		return null;
	}

//	@Override
//	public DocumentListBean paserData() {
////		SystemClock.sleep(500);
//
//		DocumentListBean docListBean = new DocumentListBean();
//		docListBean.setTestData();
//		return docListBean;
//	}

}
