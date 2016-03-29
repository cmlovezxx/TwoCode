package com.zx.twocode.fragment.impl;

import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.zx.twocode.R;
import com.zx.twocode.adapter.SearchListViewAdapter;
import com.zx.twocode.bean.SearchListBean;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.ConstantValue;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.manager.MiddleUIManager;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.SearchProtocal;
import com.zx.twocode.utils.PromptManager;

public class SearchFragment extends BaseFragment<SearchListBean> {

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

			protected void onPreExecute() {
				PromptManager.showProgressDialog(context);

			};

			@Override
			protected SearchListBean doInBackground(String... params) {
				SystemClock.sleep(300);
				BaseProtocal<SearchListBean> protocal = new SearchProtocal();
				SearchListBean result = protocal.load(params);
				return result;
			}

			@Override
			protected void onPostExecute(SearchListBean result) {
				PromptManager.closeProgressDialog();
				if (result != null) {
					setView(result);
				} else {
					PromptManager.showNoDataRetry(context, SearchFragment.this);
				}

			}
		}.executeProxy();
	}

	@Override
	protected String[] getParams() {
		// TODO 需要填写请求信息
		if (getBundle().getString("searchresult") != null) {
			String[] strings = { "requestcode", "002", "userinput",
					getBundle().getString("searchresult") };
			return strings;
		}
		return null;
	}

	protected void setView(final SearchListBean result) {
		listViewSearch.setAdapter(new SearchListViewAdapter(result
				.getSouSuoJieGuo(), context));
		listViewSearch.setSelector(R.color.list_item_click);
		listViewSearch.setCacheColorHint(R.color.list_item_click);
		listViewSearch.setDividerHeight(0);
		listViewSearch.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// 点击要搜索的条目后跳转到基本信息界面
				GlobalParams.isFirst = false;
				GlobalParams.currentEquipmentBean.setEquipmentCode(result
						.getSouSuoJieGuo().get(arg2).getEquipmentcode());
				GlobalParams.currentEquipmentBean.setEquipmentName(result
						.getSouSuoJieGuo().get(arg2).getEquipmentname());
				MiddleUIManager.getInstance().ChangeUI(
						ConstantValue.BASIC_INFO, null);
			}
		});
	}


}
