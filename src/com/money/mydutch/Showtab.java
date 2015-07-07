package com.money.mydutch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Showtab extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showtab);
		TextView tv=(TextView)findViewById(R.id.tvSQLinfo);
		Keeprecord get=new Keeprecord(this);
		get.open();
		String info=get.getData();
		get.close();
		tv.setText(info);
	}
	
	
	

	

}
