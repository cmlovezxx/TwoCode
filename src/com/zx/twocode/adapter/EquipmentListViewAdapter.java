package com.zx.twocode.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.bean.Node;

public class EquipmentListViewAdapter extends BaseAdapter {
	private Node node;
	private Context context;

	public EquipmentListViewAdapter(Node node, Context context) {
		super();
		this.node = node;
		this.context = context;
	}

	@Override
	public int getCount() {
		return node.getChildren().size();
	}

	@Override
	public Object getItem(int position) {
		return node.getChildren().get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.equipment_list_file,
					null);
			holder = new ViewHolder();
			holder.zx_tv_equipmentcode = (TextView) convertView
					.findViewById(R.id.zx_tv_equipmentcode);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.zx_tv_equipmentcode.setText(node.getChildren().get(position)
				.getName());

		return convertView;
	}

	class ViewHolder {
		TextView zx_tv_equipmentcode;

	}
}
