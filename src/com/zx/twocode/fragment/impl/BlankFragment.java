package com.zx.twocode.fragment.impl;

import android.view.View;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.bean.BasicListBean;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.manager.MiddleUIManager;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.BasicProtocal;
import com.zx.twocode.protocal.BlankProtocal;
import com.zx.twocode.protocal.MyProtocal;

public class BlankFragment extends BaseFragment<String> {

	@Override
	public View createView() {

		View view = View.inflate(context, R.layout.fragment_blank, null);

		return view;
	}

	@Override
	protected void setView(String result) {

	}

	@Override
	protected BaseProtocal<String> createImplProtocal() {
		GlobalParams.hasData = false;
		return new BlankProtocal();
	}

	@Override
	protected String[] getParams() {
		return null;
	}

}
