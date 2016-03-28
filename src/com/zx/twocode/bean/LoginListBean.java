package com.zx.twocode.bean;

import java.util.ArrayList;
import java.util.List;

public class LoginListBean {
	private List<LoginBean> DengLu = new ArrayList<LoginBean>();

	public List<LoginBean> getDengLu() {
		return DengLu;
	}

	public void setDengLu(List<LoginBean> DengLu) {
		this.DengLu = DengLu;
	}

	public class LoginBean {

		private String responsecode;

		public String getResponsecode() {
			return responsecode;
		}

		public void setResponsecode(String responsecode) {
			this.responsecode = responsecode;
		}

	}
}
