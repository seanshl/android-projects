package com.example.uiwidgettest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private Button button;
	
	private EditText editText;
	
	private ImageView imageView;
	
	private ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) this.findViewById(R.id.button);
		editText = (EditText) this.findViewById(R.id.edit_text);
		imageView = (ImageView) this.findViewById(R.id.image_view);
		progressBar = (ProgressBar) this.findViewById(R.id.progress_bar);
		
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.button:
			String inputText = editText.getText().toString();
			Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show();
			imageView.setImageResource(R.drawable.jelly_bean);
			
			ProgressDialog progressDialog = new ProgressDialog(this);
			progressDialog.setTitle("This is a progress dialog");
			progressDialog.setMessage("Loading...");
			progressDialog.setCancelable(true);
			progressDialog.show();
			
			break;
		default: break;
		}
	}

}
