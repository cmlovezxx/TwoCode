package com.zx.twocode.fragment.impl;

import android.view.View;
import android.widget.TextView;

import com.zx.twocode.fragment.BaseFragment;

public class SearchFragment extends BaseFragment {

	@Override
	public View createView() {
		TextView view = new TextView(getActivity());
		view.setText("基本信息頁面");
		return view;
	}

	@Override
	protected String[] getParams() {
		// TODO Auto-generated method stub
		return null;
	}

}
