package com.example.smstest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsMessage;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private TextView sender;
	
	private TextView content;
	
	private IntentFilter receiveFilter;
	
	private MessageReceiver messageReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.sender = (TextView)this.findViewById(R.id.sender);
		this.content = (TextView)this.findViewById(R.id.content);
		this.receiveFilter = new IntentFilter();
		receiveFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
		this.messageReceiver = new MessageReceiver();
		this.registerReceiver(messageReceiver, receiveFilter);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		this.unregisterReceiver(messageReceiver);
	}
	
	protected class MessageReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			Bundle bundle = intent.getExtras();
			Object[] pdus = (Object[]) bundle.get("pdus");
			SmsMessage[] messages = new SmsMessage[pdus.length];
			
			for (int i = 0; i < messages.length; i++) {
				messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
			}
			String address = messages[0].getOriginatingAddress();
			
			String fullMessage = "";
			for (SmsMessage message : messages) {
				fullMessage += message.getMessageBody();
			}
			sender.setText(address);
			content.setText(fullMessage);
		}
		
	}
}
