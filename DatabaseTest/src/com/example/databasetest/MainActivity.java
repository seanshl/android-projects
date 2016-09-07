package com.example.databasetest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
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

		Button addData = (Button) findViewById(R.id.add_data);
		addData.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SQLiteDatabase db = dbHelper.getWritableDatabase();

				ContentValues values = new ContentValues();
				values.put("name", "The Da Vinci Code");
				values.put("author", "Dan Brown");
				values.put("pages", 454);
				values.put("price", 16.96);

				db.insert("Book", null, values);
				values.clear();

				values.put("name", "The Lost Symbol");
				values.put("author", "Dan Brown");
				values.put("pages", 510);
				values.put("price", 19.95);
				db.insert("Book", null, values);
			}
		});

		Button updateData = (Button) findViewById(R.id.update_data);
		updateData.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				
				ContentValues values = new ContentValues();
				values.put("price", 10.99);
				
				db.update("Book", values, "name = ?", new String[] {"The Da Vinci Code"});
			}
		});
	}

}
