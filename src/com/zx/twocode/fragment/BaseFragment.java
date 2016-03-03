package com.zx.twocode.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.zx.twocode.R;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.utils.NetUtil;
import com.zx.twocode.utils.PromptManager;

public abstract class BaseFragment<Params> extends Fragment implements
		OnClickListener {

	private View view;
	protected FragmentActivity context;

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
	 */

	/**
	 * 返回一个请求协议的string数组
	 * 
	 * @return
	 */

	public void refreshView() {
		new MyHttpTask<Params>() {

			@Override
			protected void setViewInfo(Params result) {
				setView(result);
			}

			@Override
			protected BaseProtocal<Params> createProtocal() {
				
				return createImplProtocal();
			}

		}.executeProxy();
	}

	protected abstract void setView(Params result);

	protected abstract BaseProtocal<Params> createImplProtocal();

	/**
	 * 处理该页面的点击事件
	 */
	@Override
	public void onClick(View v) {

	}

	// TODO 异步加载框架 读取网络 获取数据
	protected abstract class MyHttpTask<Params> extends
			AsyncTask<String, Void, Params> {
		private BaseProtocal<Params> protocal;

		/**
		 * 刷新界面信息在这个方法中进行
		 * 
		 * @param result
		 */
		protected abstract void setViewInfo(Params result);

		protected Params doInBackground(String... params) {
			SystemClock.sleep(500);
			protocal = createProtocal();
			Params result = protocal.load(params);
			return result;
		}

		protected abstract BaseProtocal<Params> createProtocal();

		@Override
		protected void onPostExecute(Params result) {
			// Log.e("Test", result.getProvider());
			PromptManager.closeProgressDialog();
			// PromptManager.showToast(context, result.getData().get(0)
			// .getEquipmentcode());

			if (result != null) {

				setViewInfo(result);
			} else {
				new AlertDialog.Builder(context)
						.setIcon(R.drawable.icon)
						.setTitle(R.string.app_name)
						.setMessage("获取数据失败，请重试")
						.setNegativeButton("取消", null)
						.setPositiveButton(
								"重试",
								new android.content.DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
//										PromptManager
//												.showProgressDialog(context);
										refreshView();
									}
								})
						.show()
						.setCanceledOnTouchOutside(false);
			}
		}

		/**
		 * 在进入子线程前做的工作
		 */
		@Override
		protected void onPreExecute() {
			PromptManager.showProgressDialog(context);
			super.onPreExecute();

		}

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
	 * 子线程加载数据后，设置当前界面信息
	 * 
	 * @param result
	 */

	/**
	 * 填写该页面的请求参数
	 * 
	 * @return
	 */
	protected abstract String[] getParams();

}
