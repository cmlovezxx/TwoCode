package com.zx.twocode.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.zx.twocode.R;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.ConstantValue;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.manager.BottomUIMagager;
import com.zx.twocode.manager.MiddleUIManager;
import com.zx.twocode.view.WaitingDialog;

/**
 * 提示信息的管理
 */

public class PromptManager {
	private static ProgressDialog dialog;

	public static void showProgressDialog(Context context) {
		dialog = new WaitingDialog(context);

		dialog.show();
		dialog.setCanceledOnTouchOutside(false);
	}

	public static void closeProgressDialog() {
		if (dialog != null && dialog.isShowing()) {
			dialog.dismiss();
		}
	}

	/**
	 * 当判断当前手机没有网络时使用
	 * 
	 * @param context
	 */

	public static void showNoNetWork(final Context context) {
		final AlertDialog alertDialog = new Builder(context).create();
		alertDialog.show();
		alertDialog.setCanceledOnTouchOutside(false);
		alertDialog.getWindow().setContentView(R.layout.no_network);
		alertDialog.getWindow().findViewById(R.id.zx_bn_cancel)
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						alertDialog.dismiss();
					}
				});
		alertDialog.getWindow().findViewById(R.id.zx_bn_known)
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = null;

						if (android.os.Build.VERSION.SDK_INT > 10) {
							intent = new Intent(
									android.provider.Settings.ACTION_SETTINGS);
						} else {
							intent = new Intent();
							ComponentName component = new ComponentName(
									"com.android.settings",
									"com.android.settings.WirelessSettings");
							intent.setComponent(component);
							intent.setAction("android.intent.action.VIEW");
						}
						context.startActivity(intent);
						alertDialog.dismiss();
					}
				});
	}

	/**
	 * 服务器忙，没有获得数据，重试
	 * 
	 * @param context
	 */
	public static <Params> void showNoDataRetry(Context context,
			final BaseFragment<Params> fragment) {

		final AlertDialog alertDialog = new Builder(context).create();
		alertDialog.show();
		alertDialog.setCanceledOnTouchOutside(false);
		alertDialog.getWindow().setContentView(R.layout.server_busy);
		alertDialog.getWindow().findViewById(R.id.zx_bn_cancel)
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						alertDialog.dismiss();
					}
				});
		alertDialog.getWindow().findViewById(R.id.zx_bn_retry)
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						fragment.refreshView();
						alertDialog.dismiss();
					}
				});
	}

	/**
	 * 退出系统
	 * 
	 * @param context
	 */
	public static void showExitSystem(Context context) {
		final AlertDialog alertDialog = new Builder(context).create();
		alertDialog.show();
		alertDialog.setCanceledOnTouchOutside(false);
		alertDialog.getWindow().setContentView(R.layout.exit_system);
		alertDialog.getWindow().findViewById(R.id.zx_bn_cancel)
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						alertDialog.dismiss();
					}
				});
		alertDialog.getWindow().findViewById(R.id.zx_bn_positive)
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						android.os.Process.killProcess(android.os.Process
								.myPid());
						// 多个Activity——懒人听书：没有彻底退出应用
						// 将所有用到的Activity都存起来，获取全部，干掉
						// BaseActivity——onCreated——放到容器中
					}
				});

	}

	/**
	 * 注销
	 * 
	 * @param context
	 */
	public static void showLogout(Context context) {
		final AlertDialog alertDialog = new Builder(context).create();
		alertDialog.show();
		alertDialog.setCanceledOnTouchOutside(false);
		alertDialog.getWindow().setContentView(R.layout.logout);
		alertDialog.getWindow().findViewById(R.id.zx_bn_cancel)
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						alertDialog.dismiss();
					}
				});
		alertDialog.getWindow().findViewById(R.id.zx_bn_positive)
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						alertDialog.dismiss();
						GlobalParams.isLogout = true;
						MiddleUIManager.getInstance().ChangeUI(
								ConstantValue.LOGIN_INFO, null);
						BottomUIMagager.getInstance().setAllCheckFalse();
					}
				});

	}

	/**
	 * 显示错误提示框
	 * 
	 * @param context
	 * @param msg
	 */
	public static void showErrorDialog(Context context, String msg) {
		new AlertDialog.Builder(context)

		.setTitle(R.string.app_name)
				.setMessage(msg)
				//
				.setNegativeButton(context.getString(R.string.is_positive),
						null).show();
	}

	public static void showToast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	public static void showToast(Context context, int msgResId) {
		Toast.makeText(context, msgResId, Toast.LENGTH_LONG).show();
	}

	// 当测试阶段时true
	private static final boolean isShow = true;

	/**
	 * 测试用 在正式投入市场：删
	 * 
	 * @param context
	 * @param msg
	 */
	public static void showToastTest(Context context, String msg) {
		if (isShow) {
			Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
		}
	}

}
