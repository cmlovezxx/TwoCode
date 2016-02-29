package com.zx.twocode.fragment.impl;

import android.os.SystemClock;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;
import android.widget.Toast;

import com.zx.twocode.R;
import com.zx.twocode.adapter.DocListviewAdapter;
import com.zx.twocode.bean.DocumentListBean;
import com.zx.twocode.fragment.BaseFragment;

public class DocumentFragment extends BaseFragment {
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
		return view;
	}

	@Override
	public void refreshView() {

		new MyHttpTask<DocumentListBean>() {

			@Override
			protected DocumentListBean doInBackground(String... params) {

				// HttpResult httpResult = HttpHelper.get(HttpHelper.URL
				// + params[0] + "=" + params[1]);
				// String json = httpResult.getString();
				SystemClock.sleep(1000);
				// DocumentProtocal docProtocal = new DocumentProtocal();
				// DocumentListBean docListBean = docProtocal.load(params);

				// --------for test--------------
				DocumentListBean docListBean = new DocumentListBean();
				docListBean.setTestData();
				// ------------------------------
				return docListBean;
			}

			@Override
			protected void setViewInfo(final DocumentListBean result) {
				// TODO Auto-generated method stub
				equipmentName.setText(result.getEquipmentname());
				DocListviewAdapter docAdapter = new DocListviewAdapter(context,
						result);
				docListView.setGroupIndicator(null);
				docListView.setAdapter(docAdapter);
				docListView.setOnGroupExpandListener(new OnGroupExpandListener() {
					
					@Override
					public void onGroupExpand(int groupPosition) {
						currentDirectory.setText(result.getDocumentList().get(groupPosition).getFolderName());
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
					public boolean onChildClick(ExpandableListView parent,
							View v, int groupPosition, int childPosition,
							long id) {
						
						currentDirectory.setText(result.getDocumentList().get(groupPosition).getFolderName());
						Toast.makeText(context,
								result.getDocumentList().get(groupPosition)
										.getFolder().get(childPosition)
										.getDocumentUrl(), Toast.LENGTH_SHORT).show();
						return true;
					}
				});
			}

		}.executeProxy();
	};

	@Override
	protected String[] getParams() {
		// TODO Auto-generated method stub
		String[] strings = { "requestcode", "006" };
		return strings;
	}
}
