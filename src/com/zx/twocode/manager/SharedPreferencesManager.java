package com.zx.twocode.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.zx.twocode.global.ConstantValue;

public class SharedPreferencesManager {

	private static SharedPreferencesManager instance = new SharedPreferencesManager();
	private SharedPreferences sp;

	private SharedPreferencesManager() {
	}

	public static SharedPreferencesManager getInstance() {
		return instance;
	}

	public SharedPreferences getSp() {
		return sp;
	}

	public void setSp(FragmentActivity activity) {

		sp = activity.getSharedPreferences("login", Context.MODE_PRIVATE);
		checkOutTimeLogin(activity);

	}

	/**
	 * 检查是否超过登陆时间，需要重新登陆
	 */
	public void checkOutTimeLogin(FragmentActivity activity) {
		long time = 0;
		if (sp != null) {
			time = sp.getLong("time", 0);
		}

		if (System.currentTimeMillis() - time < ConstantValue.SEVENDAY) {
			Editor editor = sp.edit();
			editor.putLong("time", System.currentTimeMillis());
			editor.commit();
			MiddleUIManager.getInstance().ChangeUI(ConstantValue.BLANK_INFO,
					null);
			ShowTopAndBottom(1);
		} else {
			Toast.makeText(
					activity,
					"You have not logged in for more than 7 days, please login again！",
					Toast.LENGTH_SHORT).show();

		}

	}

	/**
	 * 显示和隐藏顶部、底部
	 */
	public void ShowTopAndBottom(int position) {
		if (position == 0) {
			BottomUIMagager.getInstance().getRg().setVisibility(View.GONE);
			TitleUIMagager.getInstance().getLl().setVisibility(View.GONE);
		} else {
			BottomUIMagager.getInstance().getRg().setVisibility(View.VISIBLE);
			TitleUIMagager.getInstance().getLl().setVisibility(View.VISIBLE);
		}
	}
}
