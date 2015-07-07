package com.money.mydutch;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends Activity implements OnClickListener {
   
	EditText ename,ecredit;
	TextView tname,tcredit;
	Button breg;
	
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		ename=(EditText)findViewById(R.id.etName);
	
		ecredit=(EditText)findViewById(R.id.etCredit);
		tname=(TextView)findViewById(R.id.tvName);
	    
		tcredit=(TextView)findViewById(R.id.tvCredit);
     breg=(Button)findViewById(R.id.bRegister);
		breg.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
		case R.id.bRegister:
			boolean didItWork=true;
			try
			{
			String name=ename.getText().toString();
			
			String credit=ecredit.getText().toString();
			Keeprecord k=new Keeprecord(Register.this);
			k.open();
			k.createEntry(name,credit);
			k.close();
			
			}
			
		catch(Exception e)
		
		{
			didItWork=false;
			String error=e.toString();
			Dialog d= new Dialog(this);
			d.setTitle("oops");
			TextView tv=new TextView(this);
			tv.setText(error);
			d.setContentView(tv);
			d.show();
			
		}
			finally
			{
						if(didItWork)
						{
				Dialog d= new Dialog(this);
				d.setTitle("SUCCESS");
				TextView tv=new TextView(this);
				tv.setText("Successfully feeded entry");
				d.setContentView(tv);
				d.show();
				
						}
			}
			
			
			
			break;
		}
		
		
		
	}
	


}
