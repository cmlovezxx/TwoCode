package com.zx.twocode.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.bean.DetailListBean.parts;

public class DetailListViewAdapter extends BaseAdapter {
	private List<parts> parts;
	private Context context;

	public DetailListViewAdapter(List<parts> parts, Context context) {
		super();
		this.parts = parts;
		this.context = context;
	}

	@Override
	public int getCount() {
		return parts.size();
	}

	@Override
	public Object getItem(int position) {
		return parts.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = View
					.inflate(context, R.layout.detail_list_file, null);
			holder = new ViewHolder();
			holder.zx_tv_partsname = (TextView) convertView
					.findViewById(R.id.zx_tv_partsname);
			holder.zx_tv_subordinateequipment = (TextView) convertView
					.findViewById(R.id.zx_tv_subordinateequipment);
			holder.zx_tv_specification = (TextView) convertView
					.findViewById(R.id.zx_tv_specification);
			holder.zx_tv_texture = (TextView) convertView
					.findViewById(R.id.zx_tv_texture);
			holder.zx_tv_number = (TextView) convertView
					.findViewById(R.id.zx_tv_number);
			holder.zx_tv_modificationtime = (TextView) convertView
					.findViewById(R.id.zx_tv_modificationtime);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.zx_tv_partsname.setText(parts.get(position).getPartsname());
		holder.zx_tv_subordinateequipment.setText(parts.get(position)
				.getSubordinateequipment());
		holder.zx_tv_specification.setText(parts.get(position)
				.getSpecification());
		holder.zx_tv_texture.setText(parts.get(position).getTexture());
		holder.zx_tv_number.setText(parts.get(position).getNumber());
		holder.zx_tv_modificationtime.setText(parts.get(position)
				.getModificationtime());
		return convertView;
	}

	private class ViewHolder {
		TextView zx_tv_partsname;
		TextView zx_tv_subordinateequipment;
		TextView zx_tv_specification;
		TextView zx_tv_texture;
		TextView zx_tv_number;
		TextView zx_tv_modificationtime;
	}
}
