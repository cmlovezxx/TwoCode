package com.zx.twocode.manager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.zx.twocode.R;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.fragment.FragmentFactory;
import com.zx.twocode.utils.PromptManager;
import com.zx.twocode.view.MyViewPager;

public class MiddleUIManager {

	private static MiddleUIManager instance = new MiddleUIManager();
	private MyViewPager vp;
	private String codeResult;

	public String getCodeResult() {
		return codeResult;
	}

	public MyViewPager getVp() {
		return vp;
	}

	private MiddleUIManager() {
	}

	public static MiddleUIManager getInstance() {
		return instance;
	}

	public void init(FragmentActivity activity) {
		vp = (MyViewPager) activity.findViewById(R.id.vp);
		vp.setAdapter(new MyAdapter(activity.getSupportFragmentManager()));
		// vp.setOffscreenPageLimit(5);
		setListner();
	}

	private void setListner() {
		vp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);

				SharedPreferencesManager.getInstance().ShowTopAndBottom(
						position);

				BaseFragment fragment = (BaseFragment) FragmentFactory
						.createFragment(position);
				// 当切换界面时，重s新刷新界面
				fragment.refreshView();

			}

		});
	}

	/**
	 * 切换界面时调用
	 * 
	 * @param position
	 */
	public void ChangeUI(int position) {

		vp.setCurrentItem(position, false);
	}

	public void ChangeUI(int position, String result) {

		vp.setCurrentItem(position, false);
		codeResult = result;
	}

	class MyAdapter extends FragmentStatePagerAdapter {

		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return FragmentFactory.createFragment(position);
		}

		@Override
		public int getCount() {
			return 7;
		}

	}
}
