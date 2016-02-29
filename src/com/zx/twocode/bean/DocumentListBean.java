package com.zx.twocode.bean;

import java.util.ArrayList;
import java.util.List;

public class DocumentListBean {
	private String equipmentname;
	private List<Folder> documentList = new ArrayList<Folder>();
	
	public String getEquipmentname() {
		return equipmentname;
	}
	public List<Folder> getDocumentList() {
		return documentList;
	}
	public void setDocumentList(List<Folder> documentList) {
		this.documentList = documentList;
	}
	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}
	
	public void setTestData(){
		this.setEquipmentname("当前设备");
		Folder f1 = new Folder();
		Folder f2 = new Folder();
		Folder f3 = new Folder();
		f1.setFolderName("文件夹1");
		f2.setFolderName("文件夹2");
		f3.setFolderName("文件夹3");
		ArrayList<Document> a = new ArrayList<Document>();
		a.add(new Document("文件1", "url1"));
		a.add(new Document("文件2", "url2"));
		a.add(new Document("文件3", "url3"));
		f1.setFolder(a);
		f2.setFolder(a);
		f3.setFolder(a);
		this.documentList.add(f1);
		this.documentList.add(f2);
		this.documentList.add(f3);
	}

	public class Folder{
		private String folderName;
		private List<Document> Folder = new ArrayList<Document>();
		
		

		public List<Document> getFolder() {
			return Folder;
		}

		public void setFolder(List<Document> Folder) {
			this.Folder = Folder;
		}

		public String getFolderName() {
			return folderName;
		}

		public void setFolderName(String folderName) {
			this.folderName = folderName;
		}

	}
	public class Document{
		private String documentName;
		private String documentUrl;
		
		Document(String name, String url){
			this.documentName = name;
			this.documentUrl = url;
		}
		
		public String getDocumentName() {
			return documentName;
		}
		public void setDocumentName(String documentName) {
			this.documentName = documentName;
		}
		public String getDocumentUrl() {
			return documentUrl;
		}
		public void setDocumentUrl(String documentUrl) {
			this.documentUrl = documentUrl;
		}
	}
}
