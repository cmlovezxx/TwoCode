package com.zx.twocode.protocal;

import com.google.gson.Gson;
import com.zx.twocode.bean.LoginListBean;

public class LoginProtocal extends BaseProtocal<LoginListBean> {

	@Override
	public LoginListBean paserJson(String json) {

		Gson gson = new Gson();
		LoginListBean loginListBean = (LoginListBean) gson.fromJson(json,
				LoginListBean.class);
		return loginListBean;
	}

}
