package com.zx.twocode.bean;

import java.util.ArrayList;
import java.util.List;

import com.zx.twocode.global.GlobalParams;

public class EquipmentListBean {
	private List<EquipmentBean> Data = new ArrayList<EquipmentBean>();

	public List<EquipmentBean> getData() {
		return Data;
	}

	public void setData(List<EquipmentBean> data) {
		Data = data;
	}

	public void setTestData() {
		Node currentNode = null;
		EquipmentBean e1 = new EquipmentBean();
		e1.setEquipmentcode("0");
		e1.setParentequipmentcode("0");
		e1.setEquipmentname("总根目录");
		Data.add(e1);

		EquipmentBean e2 = new EquipmentBean();
		e2.setEquipmentcode("1");
		e2.setParentequipmentcode("0");
		e2.setEquipmentname("根目录1");
		Data.add(e2);

		EquipmentBean e3 = new EquipmentBean();
		e3.setEquipmentcode("2");
		e3.setParentequipmentcode("0");
		e3.setEquipmentname("根目录2");
		Data.add(e3);

		EquipmentBean e4 = new EquipmentBean();
		e4.setEquipmentcode("3");
		e4.setParentequipmentcode("0");
		e4.setEquipmentname("根目录3");
		Data.add(e4);

		EquipmentBean e5 = new EquipmentBean();
		e5.setEquipmentcode("4");
		e5.setParentequipmentcode("0");
		e5.setEquipmentname("根目录4");
		Data.add(e5);

		EquipmentBean e6 = new EquipmentBean();
		e6.setEquipmentcode("5");
		e6.setParentequipmentcode("1");
		e6.setEquipmentname("子目录1-1");
		Data.add(e6);

		EquipmentBean e7 = new EquipmentBean();
		e7.setEquipmentcode("6");
		e7.setParentequipmentcode("1");
		e7.setEquipmentname("子目录1-2");
		Data.add(e7);

		EquipmentBean e8 = new EquipmentBean();
		e8.setEquipmentcode("7");
		e8.setParentequipmentcode("5");
		e8.setEquipmentname("子目录1-1-1");
		Data.add(e8);

		EquipmentBean e9 = new EquipmentBean();
		e9.setEquipmentcode("8");
		e9.setParentequipmentcode("2");
		e9.setEquipmentname("子目录2-1");
		Data.add(e9);

		EquipmentBean e10 = new EquipmentBean();
		e10.setEquipmentcode("9");
		e10.setParentequipmentcode("4");
		e10.setEquipmentname("子目录4-1");
		Data.add(e10);

		EquipmentBean e11 = new EquipmentBean();
		e11.setEquipmentcode("10");
		e11.setParentequipmentcode("4");
		e11.setEquipmentname("子目录4-2");
		Data.add(e11);

		EquipmentBean e12 = new EquipmentBean();
		e12.setEquipmentcode("11");
		e12.setParentequipmentcode("10");
		e12.setEquipmentname("子目录4-2-1");
		Data.add(e12);

		EquipmentBean e13 = new EquipmentBean();
		e13.setEquipmentcode("12");
		e13.setParentequipmentcode("10");
		e13.setEquipmentname("子目录4-2-3");
		Data.add(e13);

		EquipmentBean e14 = new EquipmentBean();
		e14.setEquipmentcode("13");
		e14.setParentequipmentcode("10");
		e14.setEquipmentname("子目录4-2-2");
		Data.add(e14);

		EquipmentBean e15 = new EquipmentBean();
		e15.setEquipmentcode("14");
		e15.setParentequipmentcode("9");
		e15.setEquipmentname("子目录4-1-1");
		Data.add(e15);

		EquipmentBean e16 = new EquipmentBean();
		e16.setEquipmentcode("15");
		e16.setParentequipmentcode("9");
		e16.setEquipmentname("子目录4-1-2");
		Data.add(e16);

		EquipmentBean e17 = new EquipmentBean();
		e17.setEquipmentcode("16");
		e17.setParentequipmentcode("9");
		e17.setEquipmentname("子目录4-1-3");
		Data.add(e17);

		EquipmentBean e18 = new EquipmentBean();
		e18.setEquipmentcode("17");
		e18.setParentequipmentcode("16");
		e18.setEquipmentname("子目录4-1-3-1");
		Data.add(e18);
	}

	public class EquipmentBean {

		private String equipmentcode;
		private String equipmentname;
		private String parentequipmentcode;

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

		public String getParentequipmentcode() {
			return parentequipmentcode;
		}

		public void setParentequipmentcode(String parentequipmentcode) {
			this.parentequipmentcode = parentequipmentcode;
		}

	}
}
