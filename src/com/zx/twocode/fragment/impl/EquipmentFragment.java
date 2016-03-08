package com.zx.twocode.fragment.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.adapter.EquipmentListViewAdapter;
import com.zx.twocode.bean.EquipmentListBean;
import com.zx.twocode.bean.Node;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.EquipmentProtocal;
import com.zx.twocode.utils.Helper;

public class EquipmentFragment extends BaseFragment<EquipmentListBean> {
	private ListView zx_lv_currentchild;
	private TextView zx_tv_currentequipment;
	private Node currentNode;
	private List<Node> currentAllParent = new ArrayList<Node>();
	private LinearLayout zx_ll_path;
	private EquipmentListViewAdapter adapter;
	// 所有的数据转成Node
	private List<Node> nodes;

	@Override
	public View createView() {
		View view = View.inflate(context, R.layout.fragment_equipment, null);
		zx_lv_currentchild = (ListView) view
				.findViewById(R.id.zx_lv_currentchild);
		zx_tv_currentequipment = (TextView) view
				.findViewById(R.id.zx_tv_currentequipment);
		zx_ll_path = (LinearLayout) view.findViewById(R.id.zx_ll_path);
		return view;
	}

	// protected EquipmentListBean doInBackground(String... params) {
	// SystemClock.sleep(500);
	// EquipmentListBean equipmentListBean = new EquipmentListBean();
	// equipmentListBean.setTestData();
	// return equipmentListBean;
	// }

	private void getAllData() {

		currentAllParent.clear();
		zx_ll_path.removeAllViews();
		TextView tvHead = new TextView(context);
		tvHead.setText("路径：");
		zx_ll_path.addView(tvHead, new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		Helper.getAllParent(currentAllParent, currentNode);
		Collections.reverse(currentAllParent);
		for (int i = 0; i < currentAllParent.size(); i++) {

			final TextView tv = new TextView(context);
			tv.setText(currentAllParent.get(i).getName() + "/");
			tv.setTag(i);
			tv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentNode = currentAllParent.get((Integer) tv.getTag());
					GlobalParams.currentEquipment = currentNode.getId();
					getAllData();

				}
			});
			zx_ll_path.addView(tv, new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		}
		zx_tv_currentequipment.setText(currentNode.getName() + ":");
		adapter = new EquipmentListViewAdapter(currentNode, context);

		zx_lv_currentchild.setAdapter(adapter);
	}

	@Override
	protected String[] getParams() {
		String[] strings = new String[] { "requestcode", "005" };
		return strings;
	}

	@Override
	protected void setView(EquipmentListBean result) {
		nodes = Helper.getNodes(result.getData());
		for (Node n : nodes) {

			if (n.getId().equals(GlobalParams.currentEquipment)) {

				currentNode = n;
				break;
			}
		}
		getAllData();

		zx_lv_currentchild.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				currentNode = currentNode.getChildren().get(arg2);
				GlobalParams.currentEquipment = currentNode.getId();
				getAllData();
			}
		});

	}

	@Override
	protected BaseProtocal<EquipmentListBean> createImplProtocal() {
		// TODO 发布时删除
		GlobalParams.hasData = false;
		return new EquipmentProtocal();
	}

}
