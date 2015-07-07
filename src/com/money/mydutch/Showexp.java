package com.money.mydutch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Showexp extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showexp);
		TextView tv=(TextView)findViewById(R.id.tvSQLinfo2);
		Keeprecord get=new Keeprecord(this);
		get.open();
		String info=get.getData2();
		get.close();
		tv.setText(info);
	}
	
	
	

	

}
