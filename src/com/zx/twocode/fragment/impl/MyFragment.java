package com.zx.twocode.fragment.impl;

import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.MyProtocal;

import android.app.Fragment;
import android.view.View;
import android.widget.TextView;

public class MyFragment extends BaseFragment<String> {

	@Override
	public View createView() {

		TextView tv = new TextView(context);
		tv.setText("我的界面");
		return tv;
	}

	@Override
	protected void setView(String result) {
		// TODO Auto-generated method stub

	}

	@Override
	protected BaseProtocal<String> createImplProtocal() {
		GlobalParams.hasData = false;
		return new MyProtocal();
	}

	@Override
	protected String[] getParams() {
		// TODO Auto-generated method stub
		return null;
	}

}
