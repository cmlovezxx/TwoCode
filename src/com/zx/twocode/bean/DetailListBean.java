package com.zx.twocode.bean;

import java.util.ArrayList;
import java.util.List;

public class DetailListBean {
	private List<DetailBean> Table1 = new ArrayList<DetailBean>();

	public List<DetailBean> getTable1() {
		return Table1;
	}

	public void setTable1(List<DetailBean> Table1) {
		this.Table1 = Table1;
	}

	private List<parts> Table2 = new ArrayList<parts>();

	public List<parts> getTable2() {
		return Table2;
	}

	public void setTable2(List<parts> table2) {
		Table2 = table2;
	}

	public class parts {
		private String partsname;// 零件名称
		private String subordinateequipment;// 所属设备
		private String specification;// 规格
		private String texture;// 材质
		private String number;// 数量
		private String modificationtime;// 修改时间

		public String getPartsname() {
			return partsname;
		}

		public void setPartsname(String partsname) {
			this.partsname = partsname;
		}

		public String getSubordinateequipment() {
			return subordinateequipment;
		}

		public void setSubordinateequipment(String subordinateequipment) {
			this.subordinateequipment = subordinateequipment;
		}

		public String getSpecification() {
			return specification;
		}

		public void setSpecification(String specification) {
			this.specification = specification;
		}

		public String getTexture() {
			return texture;
		}

		public void setTexture(String texture) {
			this.texture = texture;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getModificationtime() {
			return modificationtime;
		}

		public void setModificationtime(String modificationtime) {
			this.modificationtime = modificationtime;
		}

	}

	public class DetailBean {

		private String equipmentcode;// 设备编码
		private String equipmentname;// 设备名称
		private String placementposition;// 安置地点
		private String procurementdate;// 采购日期
		private String provider;// 供应商
		private String specification;// 规格
		private String trademark;// 品牌
		private String type;// 型号
		private String batchnumbe;// 批次号
		private String equipmenttype;// 设备类型
		private String superequipment;// 上级设备
		private String externaldimension;// 外观尺寸
		private String weight;// 重量
		private String manufacture;// 制造商
		private String factorycode;// 出厂编码
		private String produceddate;// 生产日期
		private String durableyears;// 使用年限
		private String maintechnicalparameters;// 主要技术参数
		private String remark;// 备注
		private String equipmentstate;// 设备状态
		private String modificationtime;// 修改时间

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

		public String getEquipmenttype() {
			return equipmenttype;
		}

		public void setEquipmenttype(String equipmenttype) {
			this.equipmenttype = equipmenttype;
		}

		public String getSuperequipment() {
			return superequipment;
		}

		public void setSuperequipment(String superequipment) {
			this.superequipment = superequipment;
		}

		public String getExternaldimension() {
			return externaldimension;
		}

		public void setExternaldimension(String externaldimension) {
			this.externaldimension = externaldimension;
		}

		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}

		public String getManufacture() {
			return manufacture;
		}

		public void setManufacture(String manufacture) {
			this.manufacture = manufacture;
		}

		public String getFactorycode() {
			return factorycode;
		}

		public void setFactorycode(String factorycode) {
			this.factorycode = factorycode;
		}

		public String getProduceddate() {
			return produceddate;
		}

		public void setProduceddate(String produceddate) {
			this.produceddate = produceddate;
		}

		public String getDurableyears() {
			return durableyears;
		}

		public void setDurableyears(String durableyears) {
			this.durableyears = durableyears;
		}

		public String getMaintechnicalparameters() {
			return maintechnicalparameters;
		}

		public void setMaintechnicalparameters(String maintechnicalparameters) {
			this.maintechnicalparameters = maintechnicalparameters;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getEquipmentstate() {
			return equipmentstate;
		}

		public void setEquipmentstate(String equipmentstate) {
			this.equipmentstate = equipmentstate;
		}

		public String getModificationtime() {
			return modificationtime;
		}

		public void setModificationtime(String modificationtime) {
			this.modificationtime = modificationtime;
		}

	}
}
