package com.zx.twocode.protocal;

import com.google.gson.Gson;
import com.zx.twocode.bean.LoginListBean;

public class LoginProtocal extends BaseProtocal<LoginListBean> {

	@Override
	public LoginListBean paserJson(String json) {
		// String result = null;
		// try {
		// JSONObject jsonObject = new JSONObject(json);
		//
		// result = (String) jsonObject.get("responsecode");
		// if (result != null) {
		// return result;
		// }
		// } catch (JSONException e) {
		// e.printStackTrace();
		// }
		// return null;
		Gson gson = new Gson();
		LoginListBean loginListBean = (LoginListBean) gson.fromJson(json,
				LoginListBean.class);
		return loginListBean;
	}

	// @Override
	// public BasicListBean paserJson(String json) {
	//
	// Gson gson = new Gson();
	// BasicListBean basicListBean = (BasicListBean) gson.fromJson(json,
	// BasicListBean.class);
	// return basicListBean;
	// }
	//
	// @Override
	// public BasicListBean paserData() {
	// return null;
	// }

}
