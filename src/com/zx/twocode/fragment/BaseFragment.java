package com.zx.twocode.fragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zx.twocode.utils.NetUtil;
import com.zx.twocode.utils.PromptManager;

public abstract class BaseFragment<Params> extends Fragment {
	private View view;
	protected FragmentActivity context;

	// 储存其他页面传过来的数据
	protected Bundle bundle;

	public Bundle getBundle() {
		return bundle;
	}

	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}

	@Override
	public void onAttach(Activity activity) {
		context = getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = createView();
		// refreshView();
		return view;
	}

	/**
	 * 创建一个新视图
	 * 
	 * @return
	 */
	public abstract View createView();

	/**
	 * 刷新界面
	 * 
	 * @return
	 */

	public void refreshView() {

	}

	// TODO 异步加载框架 读取网络 获取数据
	@SuppressWarnings("hiding")
	protected abstract class MyHttpTask<Params> extends
			AsyncTask<String, Void, Params> {

		/**
		 * 类似与Thread.start方法 由于final修饰，无法Override，方法重命名 省略掉网络判断
		 * 
		 * @param params
		 * @return
		 */
		public final AsyncTask<String, Void, Params> executeProxy() {
			if (NetUtil.checkNet(context)) {
				return super.execute(getParams());
			} else {
				PromptManager.showNoNetWork(context);
			}
			return null;
		}

	}

	/**
	 * 填写该页面的请求参数
	 * 
	 * @return
	 */
	protected abstract String[] getParams();

}
