package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private Button sendNotice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.sendNotice = (Button)this.findViewById(R.id.send_notice);
		this.sendNotice.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.send_notice:
			NotificationManager manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
			Notification.Builder builder = new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher)
					.setTicker("This is ticker text")
					.setWhen(System.currentTimeMillis())
					.setContentTitle("This is content title")
					.setContentText("This is content text");
			Notification notification = builder.build();
			manager.notify(1, notification);
			break;
		default:
			break;

		}
	}
}
