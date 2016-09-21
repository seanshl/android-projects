package com.example.smstest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private TextView sender;
	
	private TextView content;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.sender = (TextView)this.findViewById(R.id.sender);
		this.content = (TextView)this.findViewById(R.id.content);
	}

}
