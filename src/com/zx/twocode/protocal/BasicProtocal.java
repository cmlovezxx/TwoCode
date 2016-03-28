package com.zx.twocode.protocal;

import com.google.gson.Gson;
import com.zx.twocode.bean.BasicListBean;

public class BasicProtocal extends BaseProtocal<BasicListBean> {

	@Override
	public BasicListBean paserJson(String json) {

		Gson gson = new Gson();
		BasicListBean basicListBean = (BasicListBean) gson.fromJson(json,
				BasicListBean.class);
		return basicListBean;
	}

	// @Override
	// public BasicListBean paserData() {
	// return null;
	// }

}
