package com.zx.twocode.global;

import com.zx.twocode.bean.CurrentEquipmentBean;

public class GlobalParams {

	/**
	 * 代理的ip
	 */
	public static String PROXY = "";
	/**
	 * 代理的端口
	 */
	public static int PORT = 0;
	/**
	 * 判断是否是第一次进入程序
	 */
	public static boolean isFirst = true;
	/**
	 * 判断是否是注销过来的
	 */
	public static boolean isLogout = false;

	public static int number;
	/**
	 * 当前正操作的设备Node
	 */
	
	public static CurrentEquipmentBean currentEquipmentBean = new CurrentEquipmentBean();
}
