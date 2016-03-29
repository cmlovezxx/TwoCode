package com.zx.twocode.bean;

import java.util.ArrayList;
import java.util.List;

public class SearchListBean {
	private List<SearchBean> SouSuoJieGuo = new ArrayList<SearchBean>();

	public List<SearchBean> getSouSuoJieGuo() {
		return SouSuoJieGuo;
	}

	public void setTable1(List<SearchBean> SouSuoJieGuo) {
		this.SouSuoJieGuo = SouSuoJieGuo;
	}

	

	public class SearchBean {
		private String equipmentcode;
		private String equipmentname;
		private String placementposition;
		private String equipmenttype;

		public String getEquipmentcode() {
			return equipmentcode;
		}

		public void setEquipmentcode(String equipmentcode) {
			this.equipmentcode = equipmentcode;
		}

		public String getEquipmentname() {
			return equipmentname;
		}

		public void setEquipmentname(String equipmentname) {
			this.equipmentname = equipmentname;
		}

		public String getPlacementposition() {
			return placementposition;
		}

		public void setPlacementposition(String placementposition) {
			this.placementposition = placementposition;
		}

		public String getEquipmenttype() {
			return equipmenttype;
		}

		public void setEquipmenttype(String equipmenttype) {
			this.equipmenttype = equipmenttype;
		}

	}
}
