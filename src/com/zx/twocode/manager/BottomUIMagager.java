package com.zx.twocode.manager;

import com.zx.twocode.R;
import com.zx.twocode.global.ConstantValue;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class BottomUIMagager {

	private static BottomUIMagager instance = new BottomUIMagager();

	private BottomUIMagager() {

	}

	public RadioGroup getRg() {
		return rg;
	}

	public static BottomUIMagager getInstance() {
		return instance;
	}

	private RadioGroup rg;
	private RadioButton rb1, rb5;

	public void setRadioButton1() {
		rb1.setChecked(true);
	}

	// public void setAllCheckFalse() {
	// int count = rg.getChildCount();
	// for (int i = 0; i < count; i++) {
	// RadioButton childAt = (RadioButton) rg.getChildAt(i);
	// childAt.setChecked(false);
	// }
	// }
	public void setAllCheckFalse() {

		rb5.setChecked(true);
	}

	public void init(FragmentActivity activity) {
		rg = (RadioGroup) activity.findViewById(R.id.rg_group);
		rb1 = (RadioButton) activity.findViewById(R.id.rb1);
		rb5 = (RadioButton) activity.findViewById(R.id.rb5);
		setListener();
	}

	private void setListener() {
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				switch (checkedId) {
				case R.id.rb1:
					MiddleUIManager.getInstance().ChangeUI(
							ConstantValue.DETAIL_INFO);

					break;
				case R.id.rb2:
					MiddleUIManager.getInstance().ChangeUI(
							ConstantValue.EQUIPMENT_INFO);

					break;
				case R.id.rb3:

					MiddleUIManager.getInstance().ChangeUI(
							ConstantValue.DOCUMENT_INFO);

					break;
				case R.id.rb4:
					MiddleUIManager.getInstance().ChangeUI(
							ConstantValue.MY_INFO);

					break;

				default:
					break;
				}
			}
		});
	}

}
