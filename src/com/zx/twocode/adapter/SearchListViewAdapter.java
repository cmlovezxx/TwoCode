package com.zx.twocode.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zx.twocode.R;
import com.zx.twocode.bean.SearchListBean.SearchBean;

public class SearchListViewAdapter extends BaseAdapter {
	private List<SearchBean> searchBeans;
	private Context context;

	public SearchListViewAdapter(List<SearchBean> searchBeans, Context context) {
		super();
		this.searchBeans = searchBeans;
		this.context = context;
	}

	@Override
	public int getCount() {
		return searchBeans.size();
	}

	@Override
	public Object getItem(int position) {
		return searchBeans.get(position);
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
					.inflate(context, R.layout.search_list_file, null);
			holder = new ViewHolder();
			holder.zx_tv_equipmentcode = (TextView) convertView
					.findViewById(R.id.zx_tv_equipmentcode);
			holder.zx_tv_equipmentname = (TextView) convertView
					.findViewById(R.id.zx_tv_equipmentname);
			holder.zx_tv_equipmenttype = (TextView) convertView
					.findViewById(R.id.zx_tv_equipmenttype);
			holder.zx_tv_placementposition = (TextView) convertView
					.findViewById(R.id.zx_tv_placementposition);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.zx_tv_equipmentcode.setText(searchBeans.get(position)
				.getEquipmentcode());
		holder.zx_tv_equipmentname.setText(searchBeans.get(position)
				.getEquipmentname());
		holder.zx_tv_equipmenttype.setText(searchBeans.get(position)
				.getEquipmenttype());
		holder.zx_tv_placementposition.setText(searchBeans.get(position)
				.getPlacementposition());
		return convertView;
	}

	class ViewHolder {
		TextView zx_tv_equipmentcode;
		TextView zx_tv_equipmentname;
		TextView zx_tv_equipmenttype;
		TextView zx_tv_placementposition;
	}
}
