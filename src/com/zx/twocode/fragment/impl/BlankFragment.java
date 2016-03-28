package com.zx.twocode.fragment.impl;

import android.view.View;

import com.zx.twocode.R;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.protocal.BaseProtocal;

public class BlankFragment extends BaseFragment<String> {

	@Override
	public View createView() {

		View view = View.inflate(context, R.layout.fragment_blank, null);

		return view;
	}

//	@Override
//	protected void setView(String result) {
//
//	}

//	@Override
//	public void refreshView() {
//
//	}

//	@Override
//	protected BaseProtocal<String> createImplProtocal() {
//		// GlobalParams.hasData = false;
//		// return new BlankProtocal();
//		return null;
//	}

	@Override
	protected String[] getParams() {
		return null;
	}

}
