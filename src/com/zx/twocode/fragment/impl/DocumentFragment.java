package com.zx.twocode.fragment.impl;

import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;
import android.widget.Toast;

import com.zx.twocode.PDFViewActivity;
import com.zx.twocode.R;
import com.zx.twocode.adapter.DocListviewAdapter;
import com.zx.twocode.bean.DocumentListBean;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.DocumentProtocal;

public class DocumentFragment extends BaseFragment<DocumentListBean> {
	private TextView equipmentName;
	private TextView currentDirectory;
	// private ListView docList;
	private ExpandableListView docListView;

	@Override
	public View createView() {
		View view = View.inflate(context, R.layout.fragment_document, null);
		this.equipmentName = (TextView) view
				.findViewById(R.id.zx_tv_equipmentname);
		this.currentDirectory = (TextView) view
				.findViewById(R.id.zx_tv_currentdirectory);
		// this.docList = (ListView) view.findViewById(R.id.zx_lv_documentlist);
		this.docListView = (ExpandableListView) view
				.findViewById(R.id.zx_lv_documentlist);
		setView1(makeData());
		return view;
	}
	protected DocumentListBean makeData() {
		
		SystemClock.sleep(500);
		
		DocumentListBean docListBean = new DocumentListBean();
		docListBean.setTestData();
		return docListBean;
	}


	@Override
	protected String[] getParams() {
		String[] strings = { "requestcode", "006" };
		return strings;
	}
	
	
	
	protected void setView1(final DocumentListBean result) {
		equipmentName.setText(result.getEquipmentname());
		DocListviewAdapter docAdapter = new DocListviewAdapter(context,
				result);
		docListView.setGroupIndicator(null);
		docListView.setAdapter(docAdapter);
		docListView
				.setOnGroupExpandListener(new OnGroupExpandListener() {

					@Override
					public void onGroupExpand(int groupPosition) {
						currentDirectory.setText(result
								.getDocumentList().get(groupPosition)
								.getFolderName());
					}
				});
		docListView
				.setOnGroupCollapseListener(new OnGroupCollapseListener() {

					@Override
					public void onGroupCollapse(int groupPosition) {
						currentDirectory.setText("");
					}
				});
		docListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent,
					View v, int groupPosition, int childPosition,
					long id) {

				currentDirectory.setText(result.getDocumentList()
						.get(groupPosition).getFolderName());
				Intent intent = new Intent(context,PDFViewActivity.class);
				intent.putExtra("url", "http://192.168.8.125:6001/炼钢_连铸批量计划与调度仿真研究_余小安.pdf");
				getActivity().startActivity(intent);
				return true;
			}
		});		
	}
	@Override
	protected void setView(final DocumentListBean result) {
		
//		equipmentName.setText(result.getEquipmentname());
//		DocListviewAdapter docAdapter = new DocListviewAdapter(context,
//				result);
//		docListView.setGroupIndicator(null);
//		docListView.setAdapter(docAdapter);
//		docListView
//				.setOnGroupExpandListener(new OnGroupExpandListener() {
//
//					@Override
//					public void onGroupExpand(int groupPosition) {
//						currentDirectory.setText(result
//								.getDocumentList().get(groupPosition)
//								.getFolderName());
//					}
//				});
//		docListView
//				.setOnGroupCollapseListener(new OnGroupCollapseListener() {
//
//					@Override
//					public void onGroupCollapse(int groupPosition) {
//						currentDirectory.setText("");
//					}
//				});
//		docListView.setOnChildClickListener(new OnChildClickListener() {
//
//			@Override
//			public boolean onChildClick(ExpandableListView parent,
//					View v, int groupPosition, int childPosition,
//					long id) {
//
//				currentDirectory.setText(result.getDocumentList()
//						.get(groupPosition).getFolderName());
//				Toast.makeText(
//						context,
//						result.getDocumentList().get(groupPosition)
//								.getFolder().get(childPosition)
//								.getDocumentUrl(), Toast.LENGTH_SHORT)
//						.show();
//				return true;
//			}
//		});		
	}

	@Override
	protected BaseProtocal<DocumentListBean> createImplProtocal() {
		return new DocumentProtocal();
	}
}
