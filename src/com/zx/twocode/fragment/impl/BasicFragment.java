package com.zx.twocode.fragment.impl;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.bean.BasicListBean;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.BasicProtocal;
import com.zx.twocode.utils.PromptManager;

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
			// super.refreshView();

			new MyHttpTask<BasicListBean>() {

				protected void onPreExecute() {
					PromptManager.showProgressDialog(context);

				};

				@Override
				protected BasicListBean doInBackground(String... params) {
					SystemClock.sleep(300);
					BaseProtocal<BasicListBean> protocal = new BasicProtocal();
					BasicListBean result = protocal.load(params);
					return result;
				}

				@Override
				protected void onPostExecute(BasicListBean result) {
					PromptManager.closeProgressDialog();
					if (result != null) {
						setView(result);
					} else {
						PromptManager.showNoDataRetry(context,
								BasicFragment.this);
					}

				}
			}.executeProxy();
		} else {
			if (getBundle() != null) {

				// Gson gson = new Gson();
				// BasicListBean basicListBean = (BasicListBean) gson.fromJson(
				// getBundle().getString("scanresult"),
				// BasicListBean.class);
				setView((BasicListBean) getBundle().getSerializable(
						"scanresult"));
//				bundle = null;

			} else {
				setView();
			}
		}

	}

	@Override
	protected String[] getParams() {
		String[] strings = new String[] { "requestcode", "003",
				"equipmentcode",
				GlobalParams.currentEquipmentBean.getEquipmentCode()

		};
		return strings;
	}

	private void setView(BasicListBean result) {
		equipmentcode.setText(result.getJiBenXinXi().get(0).getEquipmentcode());
		equipmentname.setText(result.getJiBenXinXi().get(0).getEquipmentname());
		trademark.setText(result.getJiBenXinXi().get(0).getTrademark());
		type.setText(result.getJiBenXinXi().get(0).getType());
		specification.setText(result.getJiBenXinXi().get(0).getSpecification());
		provider.setText(result.getJiBenXinXi().get(0).getProvider());
		procurementdate.setText(result.getJiBenXinXi().get(0)
				.getProcurementdate());
		batchnumber.setText(result.getJiBenXinXi().get(0).getBatchnumbe());
		placementposition.setText(result.getJiBenXinXi().get(0)
				.getPlacementposition());
	}

	private void setView() {
		equipmentcode.setText("");
		equipmentname.setText("");
		trademark.setText("");
		type.setText("");
		specification.setText("");
		provider.setText("");
		procurementdate.setText("");
		batchnumber.setText("");
		placementposition.setText("");
	}
}
