package com.zx.twocode;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.zx.twocode.global.ConstantValue;
import com.zx.twocode.manager.BottomUIMagager;
import com.zx.twocode.manager.MiddleUIManager;
import com.zx.twocode.manager.SharedPreferencesManager;
import com.zx.twocode.manager.TitleUIMagager;
import com.zx.twocode.utils.PromptManager;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	public void init() {
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		BottomUIMagager.getInstance().init(this);
		TitleUIMagager.getInstance().init(this);
		MiddleUIManager.getInstance().init(this);

		if (MiddleUIManager.getInstance().getVp().getCurrentItem() == 0) {

			SharedPreferencesManager.getInstance().ShowTopAndBottom(0);
		}

		SharedPreferencesManager.getInstance().setSp(this);
		LinearLayout activity_main = (LinearLayout) findViewById(R.id.activity_main);
		activity_main.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View arg0, MotionEvent arg1) {
				InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
				return imm.hideSoftInputFromWindow(getCurrentFocus()
						.getWindowToken(), 0);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 取得扫描结果
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			String result = data.getExtras().getString("result");
			// TODO 取得结果后显示在第一个界面中
			MiddleUIManager.getInstance().ChangeUI(ConstantValue.BASIC_INFO,
					result);
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {

		if (ev.getAction() == MotionEvent.ACTION_DOWN) {

			View v = getCurrentFocus();
			if (isShouldHideKeyboard(v, ev)) {

				hideKeyboard(v.getWindowToken());
			}

		}
		return super.dispatchTouchEvent(ev);
	}

	private void hideKeyboard(IBinder windowToken) {
		if (windowToken != null) {
			InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			im.hideSoftInputFromWindow(windowToken,
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	private boolean isShouldHideKeyboard(View v, MotionEvent ev) {
		if (v != null && (v instanceof EditText)) {
			int[] l = { 0, 0 };
			v.getLocationInWindow(l);
			int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
					+ v.getWidth();
			if (ev.getX() > left && ev.getX() < right && ev.getY() > top
					&& ev.getY() < bottom) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * 返回健
	 */
	@Override
	public void onBackPressed() {
		// super.onBackPressed();
		if (MiddleUIManager.getInstance().getVp().getCurrentItem() == ConstantValue.BLANK_INFO
				|| MiddleUIManager.getInstance().getVp().getCurrentItem() == ConstantValue.LOGIN_INFO) {
			PromptManager.showExitSystem(this);

		} else {
			MiddleUIManager.getInstance().ChangeUI(ConstantValue.BLANK_INFO);
			BottomUIMagager.getInstance().setAllCheckFalse();

		}
	}
}
