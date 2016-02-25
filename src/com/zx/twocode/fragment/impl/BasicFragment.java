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

	// 璁惧缂栫爜 equipmentcode
	// 璁惧鍚嶇О equipmentname
	// 鍝佺墝 trademark
	// 鍨嬪彿 type
	// 瑙勬牸 specification
	// 渚涘簲鍟� provider
	// 閲囪喘鏃ユ湡 procurementdate
	// 鎵规鍙� batchnumber
	// 瀹夌疆鍦扮偣 placementposition
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
		// view.setText("鍩烘湰淇℃伅闋侀潰");
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
			// TODO 浜岀淮鐮佽幏鍙栨暟鎹鐞嗗湪姝ゅ
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
