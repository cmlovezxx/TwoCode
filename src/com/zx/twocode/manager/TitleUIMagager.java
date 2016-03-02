package com.zx.twocode.manager;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.zx.twocode.R;
import com.zx.twocode.global.ConstantValue;
import com.zx.twocode.global.GlobalParams;
import com.zxing.activity.CaptureActivity;

public class TitleUIMagager {

	private static TitleUIMagager instance = new TitleUIMagager();

	private TitleUIMagager() {
	}

	public static TitleUIMagager getInstance() {
		return instance;
	}

	public LinearLayout getLl() {
		return ll;
	}

	public EditText getEt_search() {
		return et_search;
	}

	private LinearLayout ll;
	private ImageButton code;
	private EditText et_search;
	private ImageButton search;

	public void init(FragmentActivity activity) {
		ll = (LinearLayout) activity.findViewById(R.id.top);
		code = (ImageButton) activity.findViewById(R.id.code);
		et_search = (EditText) activity.findViewById(R.id.et_search);

		search = (ImageButton) activity.findViewById(R.id.search);
		setListner(activity);

	}

	private void setListner(final FragmentActivity activity) {
		code.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 跳转到扫描二维码的界面
				Intent i = new Intent(activity, CaptureActivity.class);
				activity.startActivityForResult(i, 0);

			}
		});
		// et_search.setOnFocusChangeListener(new OnFocusChangeListener() {
		//
		// @Override
		// public void onFocusChange(View v, boolean hasFocus) {
		// Log.e("Test", hasFocus + "");
		// InputMethodManager imm = (InputMethodManager) activity
		// .getSystemService(Context.INPUT_METHOD_SERVICE);
		//
		// imm.hideSoftInputFromWindow(activity.getCurrentFocus()
		// .getWindowToken(), 0);
		// }
		//
		// });
		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 根据edittext的内容，请求服务器后，跳转到搜索页面。
				// GlobalParams.isFirst = false;
				BottomUIMagager.getInstance().setAllCheckFalse();
				MiddleUIManager.getInstance().ChangeUI(
						ConstantValue.SEARCH_INFO);

			}
		});
	}
}
