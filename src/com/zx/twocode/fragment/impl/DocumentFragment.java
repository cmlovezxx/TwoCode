package com.zx.twocode.fragment.impl;

import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;

import com.zx.twocode.PDFViewActivity;
import com.zx.twocode.R;
import com.zx.twocode.adapter.DocListviewAdapter;
import com.zx.twocode.bean.DocumentListBean;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.DocumentProtocal;
import com.zx.twocode.utils.PromptManager;

public class DocumentFragment extends BaseFragment<DocumentListBean> {
	private TextView equipmentName;
	private TextView currentDirectory;
	private ExpandableListView docListView;

	@Override
	public View createView() {
		View view = View.inflate(context, R.layout.fragment_document, null);
		this.equipmentName = (TextView) view
				.findViewById(R.id.zx_tv_equipmentname);
		this.currentDirectory = (TextView) view
				.findViewById(R.id.zx_tv_currentdirectory);
		this.docListView = (ExpandableListView) view
				.findViewById(R.id.zx_lv_documentlist);

		return view;
	}

	@Override
	protected String[] getParams() {
		String[] strings = { "requestcode", "006", "equipmentcode",
				GlobalParams.currentEquipmentBean.getEquipmentCode() };
		return strings;
	}

	@Override
	public void refreshView() {
		if (GlobalParams.currentEquipmentBean.getEquipmentCode() != null) {
			new MyHttpTask<DocumentListBean>() {

				protected void onPreExecute() {
					PromptManager.showProgressDialog(context);

				};

				@Override
				protected DocumentListBean doInBackground(String... params) {
					SystemClock.sleep(300);
					BaseProtocal<DocumentListBean> protocal = new DocumentProtocal();
					DocumentListBean result = protocal.load(params);
					return result;
				}

				@Override
				protected void onPostExecute(DocumentListBean result) {
					PromptManager.closeProgressDialog();
					if (result != null) {
						setView(result);
					} else {
						PromptManager.showNoDataRetry(context,
								DocumentFragment.this);
					}

				}
			}.executeProxy();
		}
	}

	protected void setView(final DocumentListBean result) {

		equipmentName.setText(result.getEquipmentname());
		DocListviewAdapter docAdapter = new DocListviewAdapter(context, result);
		docListView.setGroupIndicator(null);
		docListView.setSelector(R.color.list_item_click);
		docListView.setCacheColorHint(R.color.list_item_click);
		docListView.setDividerHeight(0);
		docListView.setAdapter(docAdapter);
		docListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {

				currentDirectory.setText(result.getDocumentList()
						.get(groupPosition).getFolderName());
			}
		});
		docListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				currentDirectory.setText("");
			}
		});
		docListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {

				currentDirectory.setText(result.getDocumentList()
						.get(groupPosition).getFolderName());

				Intent intent = new Intent(getActivity(), PDFViewActivity.class);
				intent.putExtra("url",
						"http://192.168.8.125:6001/炼钢_连铸批量计划与调度仿真研究_余小安.pdf");
				getActivity().startActivity(intent);

				return true;
			}
		});
	}

}
