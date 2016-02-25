package com.zx.twocode.bean;

import java.util.ArrayList;
import java.util.List;

public class BasicListBean {
	private List<BasicBean> Data = new ArrayList<BasicBean>();

	public List<BasicBean> getData() {
		return Data;
	}

	public void setData(List<BasicBean> data) {
		Data = data;
	}

	public class BasicBean {

		private String equipmentcode;
		private String equipmentname;
		private String placementposition;
		private String procurementdate;
		private String provider;
		private String specification;
		private String trademark;
		private String type;
		private String batchnumbe;

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

		public String getProcurementdate() {
			return procurementdate;
		}

		public void setProcurementdate(String procurementdate) {
			this.procurementdate = procurementdate;
		}

		public String getProvider() {
			return provider;
		}

		public void setProvider(String provider) {
			this.provider = provider;
		}

		public String getSpecification() {
			return specification;
		}

		public void setSpecification(String specification) {
			this.specification = specification;
		}

		public String getTrademark() {
			return trademark;
		}

		public void setTrademark(String trademark) {
			this.trademark = trademark;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getBatchnumbe() {
			return batchnumbe;
		}

		public void setBatchnumbe(String batchnumbe) {
			this.batchnumbe = batchnumbe;
		}

	}
}
