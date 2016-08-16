package com.example.uiwidgettest;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
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
			
			int progress = progressBar.getProgress();
			progress += 10;
			progressBar.setProgress(progress);
			
			
			Builder dialog = new Builder(this);
			dialog.setTitle("This is a dialog");
			dialog.setMessage("Something important");
			dialog.setCancelable(false);
			dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}			
			});
			dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			dialog.show();
			break;
		default: break;
		}
	}

}
