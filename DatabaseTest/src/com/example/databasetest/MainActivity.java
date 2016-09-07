package com.example.databasetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private MyDatabaseHelper dbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 3);
		Button createDatabase = (Button) this.findViewById(R.id.create_database);
		createDatabase.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dbHelper.getWritableDatabase();
			}
			
		});
	}

}
