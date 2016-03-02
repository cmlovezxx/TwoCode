package com.zx.twocode.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * http://blog.csdn.net/lmj623565791/article/details/40212367 准备把bean数据到这个Node中
 * 
 * @author zhy
 * 
 */
public class Node {

	private String id;
	/**
	 * 根节点pId为0
	 */
	private String pId = null;

	private String name;

	/**
	 * 下一级的子Node
	 */
	private List<Node> children = new ArrayList<Node>();

	/**
	 * 父Node
	 */
	private Node parent;

	public Node() {
	}

	public Node(String id, String pId, String name) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * 是否为跟节点
	 * 
	 * @return
	 */
	public boolean isRoot() {
		return parent == null;
	}

	/**
	 * 判断父节点是否展开
	 * 
	 * @return
	 */
	// public boolean isParentExpand()
	// {
	// if (parent == null)
	// return false;
	// return parent.isExpand();
	// }

	/**
	 * 是否是叶子界点
	 * 
	 * @return
	 */
	public boolean isLeaf() {
		return children.size() == 0;
	}

}
