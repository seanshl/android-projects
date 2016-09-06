package com.example.sharedpreferencetest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button saveData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		saveData = (Button) this.findViewById(R.id.save_data);
		saveData.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences.Editor editor = MainActivity.this.getSharedPreferences("data", MODE_PRIVATE).edit();
				
				editor.putString("name", "Tom");
				editor.putInt("age", 28);
				editor.putBoolean("married", false);
				editor.commit();
			}
			
		});
	}

	
}
