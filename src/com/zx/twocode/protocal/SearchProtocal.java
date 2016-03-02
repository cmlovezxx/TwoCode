package com.zx.twocode.protocal;

import com.google.gson.Gson;
import com.zx.twocode.bean.BasicListBean;
import com.zx.twocode.bean.SearchListBean;

public class SearchProtocal extends BaseProtocal<SearchListBean> {

	@Override
	public SearchListBean paserJson(String json) {

		Gson gson = new Gson();
		SearchListBean searchListBean = (SearchListBean) gson.fromJson(json,
				SearchListBean.class);
		return searchListBean;
	}

}
