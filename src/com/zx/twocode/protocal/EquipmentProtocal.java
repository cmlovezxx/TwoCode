package com.zx.twocode.protocal;

import com.google.gson.Gson;
import com.zx.twocode.bean.EquipmentListBean;

public class EquipmentProtocal extends BaseProtocal<EquipmentListBean> {

	@Override
	public EquipmentListBean paserJson(String json) {
		Gson gson = new Gson();
		EquipmentListBean equipmentListBean = (EquipmentListBean) gson
				.fromJson(json, EquipmentListBean.class);
		return equipmentListBean;
	}

}
