package com.zx.twocode.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zx.twocode.R;
import com.zx.twocode.fragment.impl.SearchFragment;
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

	public void clearSearch() {
		et_search.setText("");
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
				MiddleUIManager.getInstance().ChangeUI(
						ConstantValue.BLANK_INFO, null);
				Intent i = new Intent(activity, CaptureActivity.class);
				activity.startActivityForResult(i, 0);

			}
		});

		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (et_search.getText().toString().length() >= 3) {
					Bundle bundle = new Bundle();
					bundle.putString("searchresult", et_search.getText()
							.toString().trim());
					if (MiddleUIManager.getInstance().getCurrentFragment() instanceof SearchFragment) {
						MiddleUIManager.getInstance().getCurrentFragment()
								.setBundle(bundle);
						MiddleUIManager.getInstance().getCurrentFragment()
								.refreshView();
					} else {

						MiddleUIManager.getInstance().ChangeUI(
								ConstantValue.SEARCH_INFO, bundle);
					}
					BottomUIMagager.getInstance().setAllCheckFalse();

				} else {
					Toast.makeText(activity,
							"The length of keywords should be at least 3！",
							Toast.LENGTH_LONG).show();
				}
				clearSearch();
			}
		});
	}
}
