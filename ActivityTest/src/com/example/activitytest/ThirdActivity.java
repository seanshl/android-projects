package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;

public class ThirdActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.third_layout);
	}
}
