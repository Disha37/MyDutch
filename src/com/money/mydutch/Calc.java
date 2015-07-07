package com.money.mydutch;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calc extends Activity implements OnClickListener {

	
	Button p,calc;
	EditText no,food,trans,utility;
	TextView dispdutch;
	double l1=0;
	double l2=0;
	double l3=0;
	double l4=0;
	double price=0;
 double perhead=0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calc);
		p=(Button)findViewById(R.id.bpay);
		calc=(Button)findViewById(R.id.bCalculatedutch);
		p.setOnClickListener(this);
		calc.setOnClickListener(this);
		no=(EditText)findViewById(R.id.etnoofpeople);
		food=(EditText)findViewById(R.id.etfood);
		trans=(EditText)findViewById(R.id.ettransport);
		utility=(EditText)findViewById(R.id.etutilities);
		dispdutch=(TextView)findViewById(R.id.tvdisplaydutch);
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
			case R.id.bCalculatedutch:
				try
				{
				String num =no.getText().toString();
				String foody=food.getText().toString();
				String tran=trans.getText().toString();
				String utily=utility.getText().toString();
				 l1=Double.parseDouble(num);
				 l2=Double.parseDouble(foody);
				l3=Double.parseDouble(tran);
				 l4=Double.parseDouble(utily);
				 price=l2+l3+l4;
				 perhead=price/l1;
				dispdutch.setText(Double.toString(perhead));
				Keeprecord k=new Keeprecord(this);
				k.open();
				k.createEntry2(Double.toString(price));
				k.close();
				
				}
				catch(Exception e)
				{
					
					String error=e.toString();
					Dialog d= new Dialog(this);
					d.setTitle("Something went wrong!");
					TextView tv=new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
				}
				break;
			case R.id.bpay:			
				try
				{
				
						
				  Bundle basket= new Bundle();
				  basket.putDouble("send", perhead);
				  Intent topay=new Intent(Calc.this,Pay.class);
				 topay.putExtras(basket);
				  startActivity(topay);
				}
				catch(Exception e)
				{
					
					String error=e.toString();
					Dialog d= new Dialog(this);
					d.setTitle("Something went wrong!");
					TextView tv=new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
				}
				break;
			
		}
		
		
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}


}
