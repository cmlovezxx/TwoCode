package com.zx.twocode.fragment.impl;

import android.os.SystemClock;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.adapter.DetailListViewAdapter;
import com.zx.twocode.bean.DetailListBean;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.DetailProtocal;
import com.zx.twocode.utils.ContextUtil;
import com.zx.twocode.utils.PromptManager;

public class DetailFragment extends BaseFragment<DetailListBean> {
	private TextView equipmentcode;// 设备编码
	private TextView equipmentname;// 设备名称
	private TextView placementposition;// 安置地点
	private TextView procurementdate;// 采购日期
	private TextView provider;// 供应商
	private TextView specification;// 规格
	private TextView trademark;// 品牌
	private TextView type;// 型号
	private TextView batchnumbe;// 批次号
	private TextView equipmenttype;// 设备类型
	private TextView superequipment;// 上级设备
	private TextView externaldimension;// 外观尺寸
	private TextView weight;// 重量
	private TextView manufacture;// 制造商
	private TextView factorycode;// 出厂编码
	private TextView produceddate;// 生产日期
	private TextView durableyears;// 使用年限
	private TextView maintechnicalparameters;// 主要技术参数
	private TextView remark;// 备注
	private TextView equipmentstate;// 设备状态
	private TextView modificationtime;// 修改时间
	private ListView listViewParts;

	@Override
	public View createView() {
		View view = View.inflate(context, R.layout.fragment_detail, null);
		listViewParts = (ListView) view.findViewById(R.id.zx_lv_parts);
		equipmentcode = (TextView) view.findViewById(R.id.zx_tv_equipmentcode);// 设备编码
		equipmentname = (TextView) view.findViewById(R.id.zx_tv_equipmentname);// 设备名称
		placementposition = (TextView) view
				.findViewById(R.id.zx_tv_placementposition);// 安置地点
		procurementdate = (TextView) view
				.findViewById(R.id.zx_tv_procurementdate);// 采购日期
		provider = (TextView) view.findViewById(R.id.zx_tv_provider);// 供应商
		specification = (TextView) view.findViewById(R.id.zx_tv_specification);// 规格
		trademark = (TextView) view.findViewById(R.id.zx_tv_trademark);// 品牌
		type = (TextView) view.findViewById(R.id.zx_tv_type);// 型号
		batchnumbe = (TextView) view.findViewById(R.id.zx_tv_batchnumber);// 批次号
		equipmenttype = (TextView) view.findViewById(R.id.zx_tv_equipmenttype);// 设备类型
		superequipment = (TextView) view
				.findViewById(R.id.zx_tv_superequipment);// 上级设备
		externaldimension = (TextView) view
				.findViewById(R.id.zx_tv_externaldimension);// 外观尺寸
		weight = (TextView) view.findViewById(R.id.zx_tv_weight);// 重量
		manufacture = (TextView) view.findViewById(R.id.zx_tv_manufacture);// 制造商
		factorycode = (TextView) view.findViewById(R.id.zx_tv_factorycode);// 出厂编码
		produceddate = (TextView) view.findViewById(R.id.zx_tv_produceddate);// 生产日期
		durableyears = (TextView) view.findViewById(R.id.zx_tv_durableyears);// 使用年限
		maintechnicalparameters = (TextView) view
				.findViewById(R.id.zx_tv_maintechnicalparameters);// 主要技术参数
		remark = (TextView) view.findViewById(R.id.zx_tv_remark);// 备注
		equipmentstate = (TextView) view
				.findViewById(R.id.zx_tv_equipmentstate);// 设备状态
		modificationtime = (TextView) view
				.findViewById(R.id.zx_tv_modificationtime);// 修改时间
		return view;
	}

	@Override
	protected String[] getParams() {
		String[] strings = new String[] { "requestcode", "004" };
		return strings;
	}

	@Override
	protected void setView(DetailListBean result) {
		equipmentcode.setText(result.getTable1().get(0).getEquipmentcode());
		equipmentname.setText(result.getTable1().get(0).getEquipmentname());
		trademark.setText(result.getTable1().get(0).getTrademark());
		type.setText(result.getTable1().get(0).getType());
		specification.setText(result.getTable1().get(0).getSpecification());
		provider.setText(result.getTable1().get(0).getProvider());
		procurementdate.setText(result.getTable1().get(0).getProcurementdate());
		batchnumbe.setText(result.getTable1().get(0).getBatchnumbe());
		placementposition.setText(result.getTable1().get(0)
				.getPlacementposition());
		equipmenttype.setText(result.getTable1().get(0).getEquipmenttype());// 设备类型
		superequipment.setText(result.getTable1().get(0).getSuperequipment());// 上级设备
		externaldimension.setText(result.getTable1().get(0)
				.getExternaldimension());// 外观尺寸
		weight.setText(result.getTable1().get(0).getWeight());// 重量
		manufacture.setText(result.getTable1().get(0).getManufacture());// 制造商
		factorycode.setText(result.getTable1().get(0).getFactorycode());// 出厂编码
		produceddate.setText(result.getTable1().get(0).getProduceddate());// 生产日期
		durableyears.setText(result.getTable1().get(0).getDurableyears());// 使用年限
		maintechnicalparameters.setText(result.getTable1().get(0)
				.getMaintechnicalparameters());// 主要技术参数
		remark.setText(result.getTable1().get(0).getRemark());// 备注
		equipmentstate.setText(result.getTable1().get(0).getEquipmentstate());// 设备状态
		modificationtime.setText(result.getTable1().get(0)
				.getModificationtime());// 修改时间
		listViewParts.setAdapter(new DetailListViewAdapter(result.getTable2(),
				context));
		listViewParts.setSelector(R.color.list_item_click);
		listViewParts.setCacheColorHint(R.color.list_item_click);
		listViewParts.setDividerHeight(0);
	}

	@Override
	protected BaseProtocal<DetailListBean> createImplProtocal() {
		// TODO 发布时删除
		GlobalParams.hasData = true;
		return new DetailProtocal();
	}

}
