package com.money.mydutch;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Start extends Activity {
	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		ourSong=MediaPlayer.create(Start.this,R.raw.sound);
		ourSong.start();
		Thread timer=new Thread()
		{
			public void run ()
			{
				try
				{
					sleep(5000);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}finally
				{
					Intent openStartingPoint=new Intent("com.money.mydutch.DISPLAY"
							);
					startActivity(openStartingPoint);
					
				}
			
			}
			
		};
		timer.start();
		
		
		
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}
