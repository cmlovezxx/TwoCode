package com.zx.twocode.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.bean.DocumentListBean;

public class DocListviewAdapter extends BaseExpandableListAdapter {

	private Context context;
	private DocumentListBean docList;

	public DocListviewAdapter(Context context, DocumentListBean doc) {
		super();
		this.context = context;
		this.docList = doc;
	}

	private final class GroupViewHolder {
		TextView label;
		ImageView doc_list_arrow;
	}

	private final class ChildViewHolder {
		TextView label;
	}

	@Override
	public int getGroupCount() {
		return docList.getDocumentList().size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return docList.getDocumentList().get(groupPosition).getFolder().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return docList.getDocumentList().get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return docList.getDocumentList().get(groupPosition).getFolder()
				.get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition * 100;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return groupPosition * 100 + childPosition;

	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {

		GroupViewHolder groupViewHolder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.doc_list_folder, null);
			groupViewHolder = new GroupViewHolder();

			groupViewHolder.label = (TextView) convertView
					.findViewById(R.id.doc_list_label);
			groupViewHolder.doc_list_arrow = (ImageView) convertView
					.findViewById(R.id.doc_list_arrow);

			convertView.setTag(groupViewHolder);
		} else {
			groupViewHolder = (GroupViewHolder) convertView.getTag();
		}

		groupViewHolder.label.setText(docList.getDocumentList()
				.get(groupPosition).getFolderName());
		if (isExpanded) {

			groupViewHolder.doc_list_arrow.setBackground(context.getResources()
					.getDrawable(R.drawable.arrow_3));
		} else {
			groupViewHolder.doc_list_arrow.setBackground(context.getResources()
					.getDrawable(R.drawable.arrow_1));
		}
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		ChildViewHolder childViewHolder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.doc_list_file, null);
			childViewHolder = new ChildViewHolder();
			childViewHolder.label = (TextView) convertView
					.findViewById(R.id.doc_list_filename);

			convertView.setTag(childViewHolder);
		} else {
			childViewHolder = (ChildViewHolder) convertView.getTag();
		}

		childViewHolder.label.setText(docList.getDocumentList()
				.get(groupPosition).getFolder().get(childPosition)
				.getDocumentName());

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
