package com.example.contactstest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ListView contactsView;
	
	private ArrayAdapter<String> adapter;
	
	private List<String> contactsList = new ArrayList<String> ();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		contactsView = (ListView) this.findViewById(R.id.contacts_view);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsList); 
		contactsView.setAdapter(adapter);
		
	}
	
	private void readContacts() {
		Cursor cursor = null;
		
		try {
			cursor = this.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI
					, null, null, null, null);
			
			while(cursor.moveToNext()) {
				String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
				String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				
				contactsList.add(displayName + "\n" + number); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
	}


}
