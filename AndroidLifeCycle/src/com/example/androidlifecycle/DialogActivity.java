package com.example.androidlifecycle;

import android.app.Activity;
import android.os.Bundle;

public class DialogActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.dialog_layout);
	}
}
