package com.money.mydutch;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends Activity implements OnClickListener {
   
	
	Button greg,gcre,gres,gdut,BVIEW,babt,bexp;
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		greg=(Button)findViewById(R.id.bgotoReg);
		gcre=(Button)findViewById(R.id.bgotocreditdetails);
		gres=(Button)findViewById(R.id.bgotoReset);
		gdut=(Button)findViewById(R.id.bgotocalcdutch);
		bexp=(Button)findViewById(R.id.bVIEWEXP);
		BVIEW=(Button)findViewById(R.id.bVIEWDET);
		babt=(Button)findViewById(R.id.bAbout);
		bexp.setOnClickListener(this);
		babt.setOnClickListener(this);
		greg.setOnClickListener(this);
		gcre.setOnClickListener(this);
		gres.setOnClickListener(this);
		gdut.setOnClickListener(this);
		BVIEW.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		
		{
		case R.id.bgotoReg:Intent a=new Intent(Display.this,Register.class);
		                   startActivity(a);
			break;
		case R.id.bgotocreditdetails:Intent b=new Intent(Display.this,CreditDetails.class);
                                     startActivity(b);
			break;
		case R.id.bgotocalcdutch:Intent c=new Intent(Display.this,Calc.class);
                                 startActivity(c);
			break;
		case R.id.bgotoReset: Keeprecord k=new Keeprecord(Display.this);
                      k.open();
                      k.deleteall();
                    k.deleteall2();
        k.close();
			Toast t=Toast.makeText(Display.this, "All entries are deleted"
					, Toast.LENGTH_LONG);
		           	t.show();
			
			break;
		case R.id.bVIEWDET:Intent i=new Intent(Display.this,Showtab.class);
		                startActivity(i);
		                break;
		

			
		case R.id.bAbout: 
			
			Dialog d=new Dialog(this);
			d.setTitle("         About the App");
			TextView tv= new TextView(this);
		 tv.setText("Friends going for a trip or a dinner.This is the App for you!!Register yourself by depositing money.Dutch and Pay.Credits will be updated automatically.User can add extra credit.Access your credit via an useriD.Reset clears all previous Entries!");
		d.setContentView(tv);
		d.show();
		 break;
		case R.id.bVIEWEXP:Intent i2=new Intent(Display.this,Showexp.class);
                     startActivity(i2);
        break;
			
		}
		
	}

}
