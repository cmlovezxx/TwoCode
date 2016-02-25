package com.zx.twocode.utils;

import android.util.Log;

public class LogUtils {
	/** ��־�������NONE */

	public static final int LEVEL_NONE = 0;

	/** ��־�������V */

	public static final int LEVEL_VERBOSE = 1;

	/** ��־�������D */

	public static final int LEVEL_DEBUG = 2;

	/** ��־�������I */

	public static final int LEVEL_INFO = 3;

	/** ��־�������W */

	public static final int LEVEL_WARN = 4;

	/** ��־�������E */

	public static final int LEVEL_ERROR = 5;



	/** ��־���ʱ��TAG */

	private static String mTag = "googleplay";

	/** �Ƿ��������log */

	private static int mDebuggable = LEVEL_ERROR;



	/** ���ڼ�ʱ�ı��� */

	private static long mTimestamp = 0;





	/** �Լ���Ϊ d ����ʽ���LOG */

	public static void v(String msg) {

		if (mDebuggable >= LEVEL_VERBOSE) {

			Log.v(mTag, msg);

		}

	}



	/** �Լ���Ϊ d ����ʽ���LOG */

	public static void d(String msg) {

		if (mDebuggable >= LEVEL_DEBUG) {

			Log.d(mTag, msg);

		}

	}



	/** �Լ���Ϊ i ����ʽ���LOG */

	public static void i(String msg) {

		if (mDebuggable >= LEVEL_INFO) {

			Log.i(mTag, msg);

		}

	}



	/** �Լ���Ϊ w ����ʽ���LOG */

	public static void w(String msg) {

		if (mDebuggable >= LEVEL_WARN) {

			Log.w(mTag, msg);

		}

	}



	/** �Լ���Ϊ w ����ʽ���Throwable */

	public static void w(Throwable tr) {

		if (mDebuggable >= LEVEL_WARN) {

			Log.w(mTag, "", tr);

		}

	}



	/** �Լ���Ϊ w ����ʽ���LOG��Ϣ��Throwable */

	public static void w(String msg, Throwable tr) {

		if (mDebuggable >= LEVEL_WARN && null != msg) {

			Log.w(mTag, msg, tr);

		}

	}



	/** �Լ���Ϊ e ����ʽ���LOG */

	public static void e(String msg) {

		if (mDebuggable >= LEVEL_ERROR) {

			Log.e(mTag, msg);

		}

	}



	/** �Լ���Ϊ e ����ʽ���Throwable */

	public static void e(Throwable tr) {

		if (mDebuggable >= LEVEL_ERROR) {

			Log.e(mTag, "", tr);

		}

	}


	/** �Լ���Ϊ e ����ʽ���LOG��Ϣ��Throwable */

	public static void e(String msg, Throwable tr) {

		if (mDebuggable >= LEVEL_ERROR && null != msg) {

			Log.e(mTag, msg, tr);

		}

	}


	/** �Լ���Ϊ e ����ʽ���msg��Ϣ,����ʱ������������һ��ʱ��ν�����* @param msg ��Ҫ�����msg */

	public static void elapsed(String msg) {

		long currentTime = System.currentTimeMillis();

		long elapsedTime = currentTime - mTimestamp;

		mTimestamp = currentTime;

		e("[Elapsed��" + elapsedTime + "]" + msg);

	}




}
