package com.zx.twocode.fragment.impl;

import android.os.SystemClock;
import android.provider.Settings.Global;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.bean.BasicListBean;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.manager.MiddleUIManager;
import com.zx.twocode.protocal.BasicProtocal;
import com.zx.twocode.utils.PromptManager;

public class BasicFragment extends BaseFragment {

	// 设备编码 equipmentcode
	// 设备名称 equipmentname
	// 品牌 trademark
	// 型号 type
	// 规格 specification
	// 供应商 provider
	// 采购日期 procurementdate
	// 批次号 batchnumber
	// 安置地点 placementposition
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
		// TextView view = new TextView(getActivity());
		// view.setText("基本信息頁面");
		// return view;
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
			new MyHttpTask<BasicListBean>() {

				@Override
				protected BasicListBean doInBackground(String... params) {

					// HttpResult httpResult = HttpHelper.get(HttpHelper.URL
					// + params[0] + "=" + params[1]);
					// String json = httpResult.getString();
					SystemClock.sleep(1000);
					BasicProtocal basicProtocal = new BasicProtocal();
					BasicListBean basicListBean = basicProtocal.load(params);

					return basicListBean;
				}

				@Override
				protected void setViewInfo(BasicListBean result) {
					equipmentcode.setText(result.getData().get(0)
							.getEquipmentcode());
					equipmentname.setText(result.getData().get(0)
							.getEquipmentname());
					trademark.setText(result.getData().get(0).getTrademark());
					type.setText(result.getData().get(0).getType());
					specification.setText(result.getData().get(0)
							.getSpecification());
					provider.setText(result.getData().get(0).getProvider());
					procurementdate.setText(result.getData().get(0)
							.getProcurementdate());
					batchnumber
							.setText(result.getData().get(0).getBatchnumbe());
					placementposition.setText(result.getData().get(0)
							.getPlacementposition());
				}

			}.executeProxy();
		} else {
			String codeResult = MiddleUIManager.getInstance().getCodeResult();
			// TODO 二维码获取数据处理在此处
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

}
