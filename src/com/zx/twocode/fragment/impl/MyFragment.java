package com.zx.twocode.fragment.impl;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zx.twocode.R;
import com.zx.twocode.fragment.BaseFragment;
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
				PromptManager.showLogout(context);
			}
		});

		zx_user_quit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				PromptManager.showExitSystem(context);
				// android.os.Process.killProcess(android.os.Process.myPid());
			}
		});
		return view;
	}

	@Override
	protected String[] getParams() {
		return null;
	}

}
