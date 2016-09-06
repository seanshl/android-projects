package com.example.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity{
	
	private SharedPreferences pref;
	
	private SharedPreferences.Editor editor;
	
	private EditText accountEdit;
	
	private EditText passwordEdit;
	
	private Button login;
	
	private CheckBox rememberPass;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.login);
		this.pref = PreferenceManager.getDefaultSharedPreferences(this);
		
		this.accountEdit = (EditText) this.findViewById(R.id.account);
		this.passwordEdit = (EditText) this.findViewById(R.id.password);
		this.rememberPass = (CheckBox) this.findViewById(R.id.remember_pass);
		boolean isRemember = pref.getBoolean("remember_password", false);
		
		if (isRemember) {
			String account = pref.getString("account", "");
			String password = pref.getString("password", "");
			
			accountEdit.setText(account);
			passwordEdit.setText(password);
			rememberPass.setChecked(true);
		}
		
		login = (Button) this.findViewById(R.id.login);

		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String account = accountEdit.getText().toString();
				String password = passwordEdit.getText().toString();
				
				if ("admin".equals(account) && "123456".equals(password)) {
					
					editor = pref.edit();
					if (rememberPass.isChecked()) {
						editor.putBoolean("remember_password", true);
						editor.putString("account", account);
						editor.putString("password", password);
					} else {
						editor.clear();
					}
					editor.commit();
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(LoginActivity.this, "Account or Password is invalid", Toast.LENGTH_SHORT).show();
				}
					
					
			}
			
		});
	}
}
