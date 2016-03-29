package com.zx.twocode.protocal;

import com.google.gson.Gson;
import com.zx.twocode.bean.DocumentListBean;

public class DocumentProtocal extends BaseProtocal<DocumentListBean> {

	@Override
	public DocumentListBean paserJson(String json) {
		Gson gson = new Gson();
		DocumentListBean docListBean = (DocumentListBean) gson.fromJson(json,
				DocumentListBean.class);
		return docListBean;
	}

}
