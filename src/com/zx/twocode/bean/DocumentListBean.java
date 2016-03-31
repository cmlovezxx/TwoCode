package com.zx.twocode.bean;

import java.util.ArrayList;
import java.util.List;

public class DocumentListBean {
	public List<DocumentBean> WenDangMuLu = new ArrayList<DocumentBean>();

	public class DocumentBean {
		private String documentfolder;
		private String documenturl;
		private String documentname;

		public String getDocumentfolder() {
			return documentfolder;
		}

		public void setDocumentfolder(String documentfolder) {
			this.documentfolder = documentfolder;
		}

		public String getDocumenturl() {
			return documenturl;
		}

		public void setDocumenturl(String documenturl) {
			this.documenturl = documenturl;
		}

		public String getDocumentname() {
			return documentname;
		}

		public void setDocumentname(String documentname) {
			this.documentname = documentname;
		}
	}
}
