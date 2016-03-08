package com.zx.twocode.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zx.twocode.R;

public class WaitingDialog extends ProgressDialog {

	private ImageView iv;
	private AnimationDrawable mAnimationDrawable;

	public WaitingDialog(Context context) {
		super(context);
	}

	public WaitingDialog(Context context, int theme) {
		super(context, theme);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		View view = View.inflate(getContext(), R.layout.waiting_loading, null);

		iv = (ImageView) view.findViewById(R.id.zx_iv_loading);
		iv.setImageResource(R.drawable.waiting_loading);
		setContentView(view);
	}

	@Override
	public void show() {
		super.show();

		mAnimationDrawable = (AnimationDrawable) iv.getDrawable();
		mAnimationDrawable.start();
	}

	@Override
	public void dismiss() {
		super.dismiss();

		mAnimationDrawable = (AnimationDrawable) iv.getDrawable();
		mAnimationDrawable.stop();
	}
}
