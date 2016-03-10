package com.zx.twocode.fragment.impl;

import android.view.View;
import android.widget.TextView;

import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.protocal.BaseProtocal;

public class MyFragment extends BaseFragment<String> {

	@Override
	public View createView() {

		TextView tv = new TextView(context);
		tv.setText("我的界面");
		return tv;
	}

	@Override
	public void refreshView() {
	}

	@Override
	protected void setView(String result) {

	}

	@Override
	protected BaseProtocal<String> createImplProtocal() {
		// GlobalParams.hasData = false;
		// return new MyProtocal();
		return null;
	}

	@Override
	protected String[] getParams() {
		return null;
	}

}
