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
import android.widget.Toast;
public class Pay extends Activity implements OnClickListener{
	EditText epayname,epayid,eoldcre,enewcre,etdeposit;
	Button bpay,bup,b1,b2;
	TextView tvdeposit;
	double change=0;
	double changed=0;
	double payment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pay);
		epayname=(EditText)findViewById(R.id.etpayname);
		epayid=(EditText)findViewById(R.id.etpayid);
		eoldcre=(EditText)findViewById(R.id.etprecredit);
		enewcre=(EditText)findViewById(R.id.etaftercredit);
		etdeposit=(EditText)findViewById(R.id.etafterdeposit);
		tvdeposit=(TextView)findViewById(R.id.tvinvisible);
		bpay=(Button)findViewById(R.id.bpayment);
		b1=(Button)findViewById(R.id.b1);
		b2=(Button)findViewById(R.id.b2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		bup=(Button)findViewById(R.id.bUPDATE);
		bpay.setOnClickListener(this);
		bup.setOnClickListener(this);
		Bundle gotbasket=getIntent().getExtras();
		payment=gotbasket.getDouble("send");

	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bpayment: 
		try
		{
		String id=epayid.getText().toString();
		long l=Long.parseLong(id);
		Keeprecord k=new Keeprecord(this);
		k.open();
		String c=k.getCredit(l);
		k.close();
	    eoldcre.setText(c);
	
		change =Double.parseDouble(c);
		if(change-payment>=0)
		{

	
	
		changed=change-payment;
		String cha=Double.toString(changed);
		Keeprecord rd1=new Keeprecord(this);
		rd1.open();
		rd1.updateCredit(l,cha);
		String newcred=rd1.getCredit(l);
		rd1.close();
		enewcre.setText(newcred);
	

		}
		else
		{
		Toast t=Toast.makeText(Pay.this, "NOT ENOUGH CREDIT", Toast.LENGTH_LONG);
		t.show();
		tvdeposit.setVisibility(View.VISIBLE);
		etdeposit.setVisibility(View.VISIBLE);
		bup.setVisibility(View.VISIBLE);
		}
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
		case R.id.bUPDATE:
			try
			{
		String id2=epayid.getText().toString();
		long l2=Long.parseLong(id2);
		String feed=etdeposit.getText().toString();
		double m=Double.parseDouble(feed);
		double mon,cre;
		Keeprecord rd=new Keeprecord(this);
		rd.open();
		String c=rd.getCredit(l2);
		String mn=rd.getMoney(l2);
		mon=m+(Double.parseDouble(mn));
		cre=m+(Double.parseDouble(c));
		String mon1=Double.toString(mon);
		String cre1=Double.toString(cre);
		rd.updateEntry(l2,cre1,mon1);
		rd.close();
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
		case R.id.b1:Intent hm=new Intent(Pay.this,Display.class);
		startActivity(hm);
		break;
		case R.id.b2:Intent ex=new Intent(Pay.this,Exit.class);
        startActivity(ex);
		break;
	}}
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
			finish();
		}
}
