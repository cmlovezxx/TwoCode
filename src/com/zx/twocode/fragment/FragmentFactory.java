package com.zx.twocode.fragment;

import java.util.HashMap;
import java.util.Map;

import com.zx.twocode.fragment.impl.BasicFragment;
import com.zx.twocode.fragment.impl.DetailFragment;
import com.zx.twocode.fragment.impl.MyFragment;
import com.zx.twocode.fragment.impl.EquipmentFragment;
import com.zx.twocode.fragment.impl.LoginFragment;
import com.zx.twocode.fragment.impl.DocumentFragment;
import com.zx.twocode.fragment.impl.SearchFragment;
import com.zx.twocode.global.ConstantValue;

public class FragmentFactory {

	private static Map<Integer, BaseFragment> mFragments = new HashMap<Integer, BaseFragment>();

	public static BaseFragment createFragment(int position) {
		BaseFragment fragment = null;
		fragment = mFragments.get(position); // �ڼ�����ȡ����Fragment
		if (fragment == null) { // ����ټ�����û��ȡ���� ��Ҫ���´���
			if (position == ConstantValue.LOGIN_INFO) {
				fragment = new LoginFragment();

			} else if (position == ConstantValue.DETAIL_INFO) {
				fragment = new DetailFragment();
			} else if (position == ConstantValue.EQUIPMENT_INFO) {
				fragment = new EquipmentFragment();
			} else if (position == ConstantValue.DOCUMENT_INFO) {
				fragment = new DocumentFragment();
			} else if (position == ConstantValue.MY_INFO) {
				fragment = new MyFragment();
			} else if (position == ConstantValue.BASIC_INFO) {
				fragment = new BasicFragment();
			} else if (position == ConstantValue.SEARCH_INFO) {
				fragment = new SearchFragment();
			}
			if (fragment != null) {
				mFragments.put(position, fragment);// �Ѵ����õ�Fragment��ŵ������л�������
			}
		}
		return fragment;

	}

}
