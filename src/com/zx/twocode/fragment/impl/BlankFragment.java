package com.zx.twocode.fragment.impl;

import android.view.View;

import com.zx.twocode.R;
import com.zx.twocode.fragment.BaseFragment;

public class BlankFragment extends BaseFragment<String> {

	@Override
	public View createView() {

		View view = View.inflate(context, R.layout.fragment_blank, null);

		return view;
	}


	@Override
	protected String[] getParams() {
		return null;
	}

}
