package com.zx.twocode.fragment.impl;

import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.zx.twocode.R;
import com.zx.twocode.adapter.SearchListViewAdapter;
import com.zx.twocode.bean.DetailListBean;
import com.zx.twocode.bean.SearchListBean;
import com.zx.twocode.bean.SearchListBean.SearchBean;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.ConstantValue;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.manager.MiddleUIManager;
import com.zx.twocode.protocal.DetailProtocal;
import com.zx.twocode.protocal.SearchProtocal;
import com.zx.twocode.bean.SearchListBean.SearchBean;

public class SearchFragment extends BaseFragment {

	private ListView listViewSearch;

	@Override
	public View createView() {

		View view = View.inflate(context, R.layout.fragment_search, null);
		listViewSearch = (ListView) view.findViewById(R.id.zx_lv_search);

		return view;
	}

	@Override
	public void refreshView() {

		new MyHttpTask<SearchListBean>() {

			@Override
			protected SearchListBean doInBackground(String... params) {

				SystemClock.sleep(1000);
				// SearchProtocal searchProtocal = new SearchProtocal();
				// SearchListBean searchListBean = searchProtocal.load(params);
				SearchListBean searchListBean = new SearchListBean();
				searchListBean.setTestData();
				return searchListBean;
			}

			@Override
			protected void setViewInfo(SearchListBean result) {

				listViewSearch.setAdapter(new SearchListViewAdapter(result
						.getTable1(), context));
				listViewSearch
						.setOnItemClickListener(new OnItemClickListener() {

							@Override
							public void onItemClick(AdapterView<?> arg0,
									View arg1, int arg2, long arg3) {

								// 点击要搜索的条目后跳转到基本信息界面
								GlobalParams.isFirst = false;
								MiddleUIManager.getInstance().ChangeUI(
										ConstantValue.BASIC_INFO);
							}
						});
			}

		}.executeProxy();
	}

	@Override
	protected String[] getParams() {
		// TODO 需要填写请求信息
		String[] strings = { "requestcode", "002" };
		return strings;
	}

}
