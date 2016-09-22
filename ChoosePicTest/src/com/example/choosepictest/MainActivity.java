package com.example.choosepictest;

import java.io.File;
import java.io.IOException;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	public static final int TAKE_PHOTO = 1;
	
	public static final int CROP_PHOTO = 2;

	private Button takePhoto;
	
	private ImageView picture;
	
	private Uri imageUri;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.takePhoto = (Button)this.findViewById(R.id.take_photo);
		this.picture = (ImageView) this.findViewById(R.id.picture);
		
		takePhoto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				File outputImage = new File(Environment.getExternalStorageDirectory(), "tempImage.jpg");
				try {
					if (outputImage.exists()) {
						outputImage.delete();
					}
					outputImage.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	}

}
