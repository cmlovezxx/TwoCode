package com.zx.twocode.utils;

import java.util.ArrayList;
import java.util.List;

import com.zx.twocode.bean.EquipmentListBean.EquipmentBean;
import com.zx.twocode.bean.Node;

public class Helper {
	/**
	 * 传入我们的普通bean，转化为我们排序后的Node
	 */
	public static List<Node> getNodes(List<EquipmentBean> datas) {
		List<Node> nodes = new ArrayList<Node>();
		Node node = null;
		for (EquipmentBean b : datas) {
			String id = null;
			String pId = null;
			String label = null;
			id = b.getEquipmentcode();
			pId = b.getParentequipmentcode();
			label = b.getEquipmentname();

			node = new Node(id, pId, label);
			nodes.add(node);
		}

		for (int i = 0; i < nodes.size(); i++) {
			Node n = nodes.get(i);
			for (int j = i + 1; j < nodes.size(); j++) {
				Node m = nodes.get(j);
				if (m.getpId().equals(n.getId())) {
					n.getChildren().add(m);
					m.setParent(n);
				} else if (m.getId().equals(n.getpId())) {
					m.getChildren().add(n);
					n.setParent(m);
				}
			}
		}

		return nodes;
	}

	/**
	 * 得到当前Node所有的父Node，并保存到result集合中
	 * 
	 * @param result
	 * @param currentNode
	 */
	public static void getAllParent(List<Node> result, Node currentNode) {

		if (currentNode.getParent() != null) {

			result.add(currentNode.getParent());
		} else {
			return;
		}
		getAllParent(result, currentNode.getParent());

	}

}
