package com.zx.twocode.fragment.impl;

import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zx.twocode.R;
import com.zx.twocode.bean.LoginListBean;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.ConstantValue;
import com.zx.twocode.manager.MiddleUIManager;
import com.zx.twocode.manager.SharedPreferencesManager;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.LoginProtocal;

public class LoginFragment extends BaseFragment<String> implements
		OnClickListener {

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
			// 服务器数据有了之后打开
			// refreshView();
			if (login_username.getText() == null
					|| login_password.getText() == null) {
				Log.e("Test", login_username.getText().toString());
				Toast.makeText(context, "Invalid username or password！",
						Toast.LENGTH_LONG).show();

			} else {

				new MyHttpTask<LoginListBean>() {

					@Override
					protected LoginListBean doInBackground(String... params) {
						SystemClock.sleep(300);
						BaseProtocal<LoginListBean> protocal = new LoginProtocal();
						LoginListBean result = protocal.load(params);
						return result;
					}

					protected void onPostExecute(LoginListBean result) {

						Log.e("Test", result.getDengLu().get(0)
								.getResponsecode());
						if (result.getDengLu().get(0).getResponsecode()
								.equals("1")) {
							Editor editor = SharedPreferencesManager
									.getInstance().getSp().edit();
							if (login_auto_login.isChecked()) {
								// 如果为真把当前时间、用户名、密码、自动登陆状态存到SharedPreferences中

								editor.putLong("time",
										System.currentTimeMillis());

								editor.commit();

							}

							MiddleUIManager.getInstance().ChangeUI(
									ConstantValue.BLANK_INFO, null);
						} else {
							Toast.makeText(context,
									"Invalid username or password！",
									Toast.LENGTH_LONG).show();
						}

					};
				}.executeProxy();

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
		return new String[] { "requestcode", "001", "username",
				login_username.getText().toString().trim(), "userpassword",
				login_password.getText().toString().trim() };
	}

}
