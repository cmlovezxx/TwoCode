package com.zx.twocode.fragment.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
import com.zx.twocode.bean.Document;
import com.zx.twocode.bean.DocumentListBean;
import com.zx.twocode.bean.DocumentListBean.DocumentBean;
import com.zx.twocode.bean.DocumentListBean2;
import com.zx.twocode.bean.Folder;
import com.zx.twocode.fragment.BaseFragment;
import com.zx.twocode.global.GlobalParams;
import com.zx.twocode.protocal.BaseProtocal;
import com.zx.twocode.protocal.DocumentProtocal;
import com.zx.twocode.utils.PromptManager;

public class DocumentFragment extends BaseFragment<DocumentListBean2> {
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

	// 去除数组中重复的记录
	public static List<String> array_unique(List<String> a) {
		// array_unique
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < a.size(); i++) {
			if (!list.contains(a.get(i))) {
				list.add(a.get(i));
			}
		}
		return list;
	}

	protected void setView(final DocumentListBean result) {
		List<String> documentfolders = new ArrayList<String>();

		for (DocumentBean documentBean : result.WenDangMuLu) {

			documentfolders.add(result.WenDangMuLu.get(0).getDocumentfolder());
		}
		final List<String> uniqueDocumentfolders = array_unique(documentfolders);
		final DocumentListBean2 bean2 = new DocumentListBean2();
		for (String documentfolder : documentfolders) {

			for (DocumentBean documentBean : result.WenDangMuLu) {
				if (documentfolder.equals(documentBean.getDocumentfolder())) {
					List<Folder> list = new ArrayList<Folder>();
					List<Document> listDocument = new ArrayList<Document>();
					Document document = new Document();
					document.setDocumentName(documentBean.getDocumentname());
					document.setDocumentUrl(documentBean.getDocumenturl());
					Folder folders = new Folder();
					folders.setFolderName(documentfolder);
					folders.setFolders(listDocument);
					listDocument.add(document);
					list.add(folders);
					bean2.setDocumentList(list);

				}
			}
		}
		equipmentName.setText(GlobalParams.currentEquipmentBean
				.getEquipmentName());
		DocListviewAdapter docAdapter = new DocListviewAdapter(context, bean2);
		docListView.setGroupIndicator(null);
		docListView.setSelector(R.color.list_item_click);
		docListView.setCacheColorHint(R.color.list_item_click);
		docListView.setDividerHeight(0);
		docListView.setAdapter(docAdapter);
		docListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {

				// currentDirectory.setText(result.getDocumentList()
				// .get(groupPosition).getFolderName());
				currentDirectory.setText(uniqueDocumentfolders
						.get(groupPosition));
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

				currentDirectory.setText(bean2.getDocumentList()
						.get(groupPosition).getFolderName());

				Intent intent = new Intent(getActivity(), PDFViewActivity.class);
				intent.putExtra("url",
						bean2.getDocumentList().get(groupPosition).getFolders()
								.get(childPosition).getDocumentUrl());
				getActivity().startActivity(intent);

				return true;
			}
		});
	}
}
