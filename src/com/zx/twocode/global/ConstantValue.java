package com.zx.twocode.global;

public interface ConstantValue {

	// long SEVENDAY = 24 * 60 * 60 * 1000 * 7;
	// long SEVENDAY1 = TimeUtils.getMilliSecondsFromDate("7");
	long SEVENDAY = 10000;
	//服务器访问地址
	String SERVER_URL = "http://218.24.232.66:99/Switches?";
	// 下面七个为页面的索引值
	int LOGIN_INFO = 0;
	int DETAIL_INFO = 1;
	int EQUIPMENT_INFO = 2;
	int DOCUMENT_INFO = 3;
	int MY_INFO = 4;
	int BASIC_INFO = 5;
	int SEARCH_INFO = 6;
	int BLANK_INFO = 7;
}
