package com.money.mydutch;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;


public class Keeprecord {

	
	
	

	public static final String KEY_ROWID="_id";
	public static final String KEY_NAME="persons_name";
	public static final String KEY_CREDITLEFT="persons_creditleft";
	public static final String KEY_MONEYDEPOSITED="persons_moneydeposited";
	public static final String KEY_EXPENSE="persons_expense";
	private static final String DATABASE_NAME="Dutch";
	private static final String DATABASE_TABLE1="creditTable";
	private static final String DATABASE_TABLE2="expenseTable";
	private static final int DATABASE_VERSION=1;
	
	
	private DbHelp ourHelper;
	private SQLiteDatabase ourDatabase;
	private final Context our;
	
	private static class DbHelp extends SQLiteOpenHelper
	{

		public DbHelp(Context context) {
			super(context,DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE "+ DATABASE_TABLE1 +" (" +
					   KEY_ROWID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
					    KEY_NAME + " TEXT NOT NULL, " +
					  KEY_CREDITLEFT + " TEXT NOT NULL, " +
					   KEY_MONEYDEPOSITED + " TEXT NOT NULL);" 
					  );
			db.execSQL("CREATE TABLE "+ DATABASE_TABLE2 +" (" +
					   KEY_ROWID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
					    KEY_EXPENSE + " TEXT NOT NULL);"
					 
					  );
					   		 							
					   		 									
		}

							   		 									
		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
			db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE1);
			db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE2);
			onCreate(db);
		}
		

	
	

}
	public Keeprecord(Context c) {
		// TODO Auto-generated constructor stub
		our=c;
	}

	public  Keeprecord open() throws SQLException{
		// TODO Auto-generated method stub
		ourHelper=new DbHelp(our);
		ourDatabase=ourHelper.getWritableDatabase();
		return this;
		
	}

	public long createEntry(String name,String credit) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(KEY_NAME,name);
	
		cv.put(KEY_CREDITLEFT,credit);
		cv.put(KEY_MONEYDEPOSITED,credit);
		return ourDatabase.insert(DATABASE_TABLE1, null, cv);
		}

	public long createEntry2(String expense) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(KEY_EXPENSE,expense);
		return ourDatabase.insert(DATABASE_TABLE2, null, cv);
		}
	

	public void close() {
		// TODO Auto-generated method stub
		ourHelper.close();
	}

	public String getCredit(long l) throws SQLException{
		// TODO Auto-generated method stub
		String [] columns=new String []{KEY_ROWID,KEY_NAME,KEY_CREDITLEFT,KEY_MONEYDEPOSITED};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE1, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null)
		{
		c.moveToFirst()	;
		String cred=c.getString(2);
				return cred;
		
		}
		
		return null;
	}

	public String getData() {
		// TODO Auto-generated method stub
String [] columns=new String []{KEY_ROWID,KEY_NAME,KEY_CREDITLEFT,KEY_MONEYDEPOSITED};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE1, columns,null, null, null, null, null);
		String result="";
		int iRow=c.getColumnIndex(KEY_ROWID);
	
		int iName=c.getColumnIndex(KEY_NAME);
		int iCredit=c.getColumnIndex(KEY_CREDITLEFT);
		int iMoney=c.getColumnIndex(KEY_MONEYDEPOSITED);
		 for (c.moveToFirst();!c.isAfterLast();c.moveToNext())
		 {
			
			 
			 result=result + c.getString(iRow)+"              "+  c.getString(iName)+ "           " + c.getString(iCredit)+ "                " +c.getString(iMoney)+ "\n";
           		 }
		
		
		return result;
	}
	public String getData2() {
		// TODO Auto-generated method stub
String [] columns=new String []{KEY_ROWID,KEY_EXPENSE};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE2, columns,null, null, null, null, null);
		String result="";
	
		 for (c.moveToFirst();!c.isAfterLast();c.moveToNext())
		 {
			
			 
			 result=result + c.getString(0)+"               "+c.getString(1)+ "\n";
           		
		 }
		
		return result;
	}
	

	public void updateEntry(Long lr, String credit,String money) throws SQLException{
		// TODO Auto-generated method stub
		
		ContentValues cvUpdate=new ContentValues();
		
		cvUpdate.put(KEY_CREDITLEFT,credit);
		cvUpdate.put(KEY_MONEYDEPOSITED,money);
		
		ourDatabase.update(DATABASE_TABLE1, cvUpdate, KEY_ROWID + "=" + lr, null);
	}


		
	
	public void deleteall(){
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE1,null, null);
	   
	}
	
	public void deleteall2(){
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE2,null, null);
	   
	}
	
	public void deleteEntry(Long lr) throws SQLException{
		// TODO Auto-generated method stub
      
		ourDatabase.delete(DATABASE_TABLE1, KEY_ROWID + "=" + lr, null);
	}

	public String getMoney(Long lr) {
		// TODO Auto-generated method stub
String [] columns=new String []{KEY_ROWID,KEY_NAME,KEY_CREDITLEFT,KEY_MONEYDEPOSITED};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE1, columns, KEY_ROWID + "=" + lr, null, null, null, null);
		if(c!=null)
		{
		c.moveToFirst()	;
		String cred=c.getString(3);
				return cred;
		
		}
		return null;
	}

	public void updateCredit(long l, String cha)throws SQLException {
		// TODO Auto-generated method stub
	ContentValues cvUpdate=new ContentValues();
		
		cvUpdate.put(KEY_CREDITLEFT,cha);
	
		
		ourDatabase.update(DATABASE_TABLE1, cvUpdate, KEY_ROWID + "=" + l, null);
	}
	

	
	
}