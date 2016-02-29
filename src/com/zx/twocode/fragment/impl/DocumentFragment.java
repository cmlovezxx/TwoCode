package com.zx.twocode.fragment.impl;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.adapter.DocListviewAdapter;
import com.zx.twocode.bean.DocumentListBean;
import com.zx.twocode.fragment.BaseFragment;

public class DocumentFragment extends BaseFragment {
	private TextView equipmentName;
	private TextView currentDirectory;
	private ListView docList;

	@Override
	public View createView() {
//		TextView view = new TextView(getActivity());
		View view = View.inflate(context, R.layout.fragment_document, null);
		this.equipmentName = (TextView) view.findViewById(R.id.zx_tv_equipmentname);
		this.currentDirectory = (TextView) view.findViewById(R.id.zx_tv_currentdirectory);
		this.docList = (ListView) view.findViewById(R.id.zx_lv_documentlist);
//		view.setText("第三个页面");
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
//				DocumentProtocal docProtocal = new DocumentProtocal();
//				DocumentListBean docListBean = docProtocal.load(params);
				
				//--------for test--------------
				DocumentListBean docListBean = new DocumentListBean();
				docListBean.setTestData();
				//------------------------------
				return docListBean;
			}

			@Override
			protected void setViewInfo(DocumentListBean result) {
				// TODO Auto-generated method stub
				equipmentName.setText(result.getEquipmentname());
				DocListviewAdapter docAdapter = new DocListviewAdapter(context, result);
				docList.setAdapter(docAdapter);
				Log.e("setviewinfo", "0");
			}

		}.executeProxy();
	};
	@Override
	protected String[] getParams() {
		// TODO Auto-generated method stub
		String[] strings = {"requestcode","006"};
		return strings;
	}
}
