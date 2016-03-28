package com.zx.twocode.protocal;

import com.google.gson.Gson;
import com.zx.twocode.bean.SearchListBean;

public class SearchProtocal extends BaseProtocal<SearchListBean> {

	@Override
	public SearchListBean paserJson(String json) {

		Gson gson = new Gson();
		SearchListBean searchListBean = (SearchListBean) gson.fromJson(json,
				SearchListBean.class);
		return searchListBean;
		// return null;
	}

	// @Override
	// public SearchListBean paserData() {
	// SearchListBean searchListBean = new SearchListBean();
	// searchListBean.setTestData();
	// return searchListBean;
	// }

}
