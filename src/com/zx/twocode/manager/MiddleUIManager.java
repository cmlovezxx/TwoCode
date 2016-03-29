package com.zx.twocode.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.zx.twocode.R;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.fragment.FragmentFactory;
import com.zx.twocode.view.MyViewPager;

public class MiddleUIManager {

	private static MiddleUIManager instance = new MiddleUIManager();
	private MyViewPager vp;

	@SuppressWarnings("rawtypes")
	private BaseFragment currentFragment;

	@SuppressWarnings("rawtypes")
	public BaseFragment getCurrentFragment() {
		return currentFragment;
	}

	@SuppressWarnings("rawtypes")
	public void setCurrentFragment(BaseFragment currentFragment) {
		this.currentFragment = currentFragment;
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
		setListner();
	}

	private void setListner() {
		vp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

			@SuppressWarnings("rawtypes")
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);

				SharedPreferencesManager.getInstance().ShowTopAndBottom(
						position);

				BaseFragment fragment = (BaseFragment) FragmentFactory
						.createFragment(position);

				// 当切换界面时，重新刷新界面
				fragment.refreshView();

			}

		});
	}

	/**
	 * 切换界面时调用
	 * 
	 * @param position
	 */

	public void ChangeUI(int position, Bundle bundle) {
		currentFragment = FragmentFactory.createFragment(position);
		currentFragment.setBundle(bundle);
		vp.setCurrentItem(position, false);
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
			return 8;
		}

	}
}
