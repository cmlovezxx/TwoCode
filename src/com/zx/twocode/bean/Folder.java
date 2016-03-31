package com.zx.twocode.bean;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	private String folderName;
	private List<Document> Folders = new ArrayList<Document>();

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public List<Document> getFolders() {
		return Folders;
	}

	public void setFolders(List<Document> folders) {
		Folders = folders;
	}

}
