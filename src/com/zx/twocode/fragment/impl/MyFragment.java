package com.zx.twocode.fragment.impl;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.ConstantValue;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.manager.BottomUIMagager;
import com.zx.twocode.manager.MiddleUIManager;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.utils.PromptManager;

public class MyFragment extends BaseFragment<String> {
	private LinearLayout zx_ll_logout;
	private Button zx_user_quit;

	@Override
	public View createView() {

		View view = View.inflate(context, R.layout.fragment_my, null);
		zx_ll_logout = (LinearLayout) view.findViewById(R.id.zx_ll_logout);

		zx_user_quit = (Button) view.findViewById(R.id.zx_user_quit);

		zx_ll_logout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				GlobalParams.isLogout = true;
				MiddleUIManager.getInstance()
						.ChangeUI(ConstantValue.LOGIN_INFO);
				BottomUIMagager.getInstance().setAllCheckFalse();
			}
		});

		zx_user_quit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				PromptManager.showExitSystem(context);
			}
		});
		return view;
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
