package com.zx.twocode.fragment.impl;

import android.view.View;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.bean.BasicListBean;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.manager.MiddleUIManager;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.BasicProtocal;

public class BasicFragment extends BaseFragment<BasicListBean> {

	private TextView equipmentcode;
	private TextView equipmentname;
	private TextView trademark;
	private TextView type;
	private TextView specification;
	private TextView provider;
	private TextView procurementdate;
	private TextView batchnumber;
	private TextView placementposition;

	@Override
	public View createView() {

		View view = View.inflate(context, R.layout.fragment_basic, null);

		equipmentcode = (TextView) view.findViewById(R.id.zx_tv_equipmentcode);
		equipmentname = (TextView) view.findViewById(R.id.zx_tv_equipmentname);
		trademark = (TextView) view.findViewById(R.id.zx_tv_trademark);
		type = (TextView) view.findViewById(R.id.zx_tv_type);
		specification = (TextView) view.findViewById(R.id.zx_tv_specification);
		provider = (TextView) view.findViewById(R.id.zx_tv_provider);
		procurementdate = (TextView) view
				.findViewById(R.id.zx_tv_procurementdate);
		batchnumber = (TextView) view.findViewById(R.id.zx_tv_batchnumber);
		placementposition = (TextView) view
				.findViewById(R.id.zx_tv_placementposition);
		return view;
	}

	public void refreshView() {

		if (!GlobalParams.isFirst) {
			super.refreshView();
		} else {
			String codeResult = MiddleUIManager.getInstance().getCodeResult();
			if (codeResult != null) {

				String[] codeResultArray = codeResult.split(",");

			}
		}

	}

	@Override
	protected String[] getParams() {
		String[] strings = new String[] { "requestcode", "003" };
		return strings;
	}

	@Override
	protected void setView(BasicListBean result) {
		equipmentcode.setText(result.getData().get(0).getEquipmentcode());
		equipmentname.setText(result.getData().get(0).getEquipmentname());
		trademark.setText(result.getData().get(0).getTrademark());
		type.setText(result.getData().get(0).getType());
		specification.setText(result.getData().get(0).getSpecification());
		provider.setText(result.getData().get(0).getProvider());
		procurementdate.setText(result.getData().get(0).getProcurementdate());
		batchnumber.setText(result.getData().get(0).getBatchnumbe());
		placementposition.setText(result.getData().get(0)
				.getPlacementposition());
	}

	@Override
	protected BaseProtocal<BasicListBean> createImplProtocal() {
		// TODO 发布时删除
		GlobalParams.hasData = true;
		return new BasicProtocal();
	}

}
