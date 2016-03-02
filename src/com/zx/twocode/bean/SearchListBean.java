package com.zx.twocode.bean;

import java.util.ArrayList;
import java.util.List;

public class SearchListBean {
	private List<SearchBean> Table1 = new ArrayList<SearchBean>();

	public List<SearchBean> getTable1() {
		return Table1;
	}

	public void setTable1(List<SearchBean> table1) {
		Table1 = table1;
	}

	public void setTestData() {

		SearchBean s1 = new SearchBean();
		s1.setEquipmentcode("01");
		s1.setEquipmentname("E");
		s1.setEquipmenttype("类型");
		s1.setPlacementposition("安置位置");
		Table1.add(0, s1);
		SearchBean s2 = new SearchBean();
		s2.setEquipmentcode("02");
		s2.setEquipmentname("E");
		s2.setEquipmenttype("类型");
		s2.setPlacementposition("安置位置");
		Table1.add(1, s2);
		SearchBean s3 = new SearchBean();
		s3.setEquipmentcode("03");
		s3.setEquipmentname("E");
		s3.setEquipmenttype("类型");
		s3.setPlacementposition("安置位置");
		Table1.add(2, s3);
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
