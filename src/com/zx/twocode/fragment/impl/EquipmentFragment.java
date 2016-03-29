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
import com.zx.twocode.utils.PromptManager;

public class EquipmentFragment extends BaseFragment<EquipmentListBean> {
	private ListView zx_lv_currentchild;
	private TextView zx_tv_current_equipmentname;
	private TextView zx_tv_current_equipmentcode;
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
		zx_tv_current_equipmentname = (TextView) view
				.findViewById(R.id.zx_tv_current_equipmentname);
		zx_tv_current_equipmentcode = (TextView) view
				.findViewById(R.id.zx_tv_current_equipmentcode);
		zx_ll_path = (LinearLayout) view.findViewById(R.id.zx_ll_path);
		zx_lv_currentchild.setSelector(R.color.list_item_click);
		zx_lv_currentchild.setCacheColorHint(R.color.list_item_click);
		zx_lv_currentchild.setDividerHeight(0);
		return view;
	}

	@Override
	public void refreshView() {
		if (GlobalParams.currentEquipmentBean.getEquipmentCode() != null) {
			new MyHttpTask<EquipmentListBean>() {

				protected void onPreExecute() {
					PromptManager.showProgressDialog(context);

				};

				@Override
				protected EquipmentListBean doInBackground(String... params) {
					SystemClock.sleep(300);
					BaseProtocal<EquipmentListBean> protocal = new EquipmentProtocal();
					EquipmentListBean result = protocal.load(params);
					return result;
				}

				@Override
				protected void onPostExecute(EquipmentListBean result) {
					PromptManager.closeProgressDialog();
					if (result != null) {
						setView(result);
					} else {
						PromptManager.showNoDataRetry(context,
								EquipmentFragment.this);
					}

				}
			}.executeProxy();
		}
	}

	private void getAllData() {

		currentAllParent.clear();
		zx_ll_path.removeAllViews();
		TextView tvHead = new TextView(context);
		tvHead.setText("Path：");
		tvHead.setTextColor(getResources().getColor(R.color.textcolor_login));
		tvHead.setTextSize(10f);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.leftMargin = 38;
		zx_ll_path.addView(tvHead, layoutParams);
		Helper.getAllParent(currentAllParent, currentNode);
		Collections.reverse(currentAllParent);
		for (int i = 0; i < currentAllParent.size(); i++) {

			final TextView tv = new TextView(context);

			tv.setTextColor(getResources().getColor(R.color.textcolor_login));
			tv.setTextSize(10f);
			if (i == currentAllParent.size() - 1) {
				tv.setText(currentAllParent.get(i).getName());
			} else {

				tv.setText(currentAllParent.get(i).getName() + " / ");
			}
			tv.setTag(i);
			tv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentNode = currentAllParent.get((Integer) tv.getTag());
					GlobalParams.currentEquipmentBean
							.setEquipmentCode(currentNode.getId());
					GlobalParams.currentEquipmentBean
							.setEquipmentName(currentNode.getName());
					getAllData();

				}
			});
			zx_ll_path.addView(tv, new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		}
		zx_tv_current_equipmentcode.setText(currentNode.getId());
		zx_tv_current_equipmentname.setText(currentNode.getName());
		adapter = new EquipmentListViewAdapter(currentNode, context);

		zx_lv_currentchild.setAdapter(adapter);

	}

	@Override
	protected String[] getParams() {
		String[] strings = new String[] { "requestcode", "005",
				"equipmentcode",
				GlobalParams.currentEquipmentBean.getEquipmentCode() };
		return strings;
	}

	protected void setView(EquipmentListBean result) {
		nodes = Helper.getNodes(result.getSheBeiMuLu());
		for (Node n : nodes) {

			if (n.getId().equals(
					GlobalParams.currentEquipmentBean.getEquipmentCode())) {

				currentNode = n;
				break;
			}
		}
		getAllData();
		zx_lv_currentchild.setSelector(R.color.list_item_click);
		zx_lv_currentchild.setCacheColorHint(R.color.list_item_click);
		zx_lv_currentchild.setDividerHeight(0);
		zx_lv_currentchild.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				currentNode = currentNode.getChildren().get(arg2);

				GlobalParams.currentEquipmentBean.setEquipmentCode(currentNode
						.getId());
				GlobalParams.currentEquipmentBean.setEquipmentName(currentNode
						.getName());

				getAllData();
			}
		});

	}

}
