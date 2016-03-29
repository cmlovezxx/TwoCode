package com.zx.twocode.protocal;

import com.google.gson.Gson;
import com.zx.twocode.bean.DetailListBean;

public class DetailProtocal extends BaseProtocal<DetailListBean> {

	@Override
	public DetailListBean paserJson(String json) {

		Gson gson = new Gson();
		DetailListBean detailListBean = (DetailListBean) gson.fromJson(json,
				DetailListBean.class);
		return detailListBean;
	}


}
