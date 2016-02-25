package com.zx.twocode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

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

	/**
	 * 返回健
	 */
	@Override
	public void onBackPressed() {
		// super.onBackPressed();
		if (MiddleUIManager.getInstance().getVp().getCurrentItem() == 1
				|| MiddleUIManager.getInstance().getVp().getCurrentItem() == 0) {
			PromptManager.showExitSystem(this);

		} else {
			MiddleUIManager.getInstance().ChangeUI(ConstantValue.DETAIL_INFO);
			BottomUIMagager.getInstance().setRadioButton1();

		}
	}
}
