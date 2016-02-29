package com.zx.twocode.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.bean.DocumentListBean;

public class DocListviewAdapter extends BaseAdapter {

	private Context context;
	private DocumentListBean docList;
	
	public DocListviewAdapter(Context context, DocumentListBean doc) {
		super();
		this.context = context;
		this.docList = doc;
	}

	@Override
	public int getCount() {
		return docList.getDocumentList().size();
	}

	@Override
	public Object getItem(int position) {
		return docList.getDocumentList().get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		Log.e("position", position+","+this.getCount());
		if(convertView == null){
			convertView = View.inflate(context, R.layout.doc_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView.findViewById(R.id.doc_list_icon);
			viewHolder.label = (TextView) convertView.findViewById(R.id.doc_list_label);
			viewHolder.arrow = (ImageView) convertView.findViewById(R.id.doc_list_arrow);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		viewHolder.label.setText(docList.getDocumentList().get(position).getFolderName());
		
		return convertView;
	}
	private final class ViewHolder
	{
		ImageView icon;
		TextView label;
		ImageView arrow;
	}

}
