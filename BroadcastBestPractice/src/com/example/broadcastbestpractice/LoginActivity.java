package com.example.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity{
	private EditText accountEdit;
	private EditText passwordEdit;
	private Button login;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.login);
		
		accountEdit = (EditText) this.findViewById(R.id.account);
		passwordEdit = (EditText) this.findViewById(R.id.password);
		login = (Button) this.findViewById(R.id.login);
		
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String account = accountEdit.getText().toString();
				String password = passwordEdit.getText().toString();
				
				if ("admin".equals(account) && "123456".equals(password)) {
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
