package com.zx.twocode.fragment.impl;

import android.content.SharedPreferences.Editor;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zx.twocode.R;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.ConstantValue;
import com.zx.twocode.manager.MiddleUIManager;
import com.zx.twocode.manager.SharedPreferencesManager;
import com.zx.twocode.protocal.BaseProtocal;

public class LoginFragment extends BaseFragment<String> {

	private EditText login_username, login_password;
	private ImageView clear;
	private CheckBox login_auto_login;
	private Button user_login;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.zx_clear:
			login_username.setText("");
			break;
		case R.id.zx_user_login:

			if (login_username.getText().toString() != null
					|| login_password.getText().toString() != null) {
				// 发送请求给服务器，验证登陆信息
				String result = null;
				if (login_username.getText().toString().equals("111")
						&& login_password.getText().toString().equals("111")) {
					result = "1";
				}

				// 服务器返回结果与用户是否选择自动登陆做一个判断
				if (result == "1") {
					Editor editor = SharedPreferencesManager.getInstance()
							.getSp().edit();
					if (login_auto_login.isChecked()) {
						// 如果为真把当前时间、用户名、密码、自动登陆状态存到SharedPreferences中

						editor.putLong("time", System.currentTimeMillis());

						editor.commit();

					}

					MiddleUIManager.getInstance().ChangeUI(
							ConstantValue.BASIC_INFO);
				} else {
					Toast.makeText(context, "您的用户名和密码错误！", Toast.LENGTH_LONG)
							.show();
				}
			} else {
				Toast.makeText(context, "您的用户名和密码不能为空！", Toast.LENGTH_LONG)
						.show();

			}
			break;
		}
	}

	@Override
	public View createView() {
		View view = View.inflate(context, R.layout.fragment_login, null);
		login_username = (EditText) view
				.findViewById(R.id.zx_user_login_username);
		login_password = (EditText) view
				.findViewById(R.id.zx_user_login_password);
		clear = (ImageView) view.findViewById(R.id.zx_clear);
		login_auto_login = (CheckBox) view
				.findViewById(R.id.zx_user_login_auto_login);
		user_login = (Button) view.findViewById(R.id.zx_user_login);

		login_username.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				if (login_username.getText().toString().length() > 0) {
					clear.setVisibility(View.VISIBLE);
				} else {

					clear.setVisibility(View.INVISIBLE);
				}
			}
		});
		clear.setOnClickListener(this);
		user_login.setOnClickListener(this);
		login_auto_login.setChecked(false);
		return view;
	}

	@Override
	protected String[] getParams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setView(String result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected BaseProtocal<String> createImplProtocal() {
		// TODO Auto-generated method stub
		return null;
	}

}
