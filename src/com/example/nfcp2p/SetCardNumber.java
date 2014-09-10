package com.example.nfcp2p;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SetCardNumber extends Activity {
	
	private Button btnAddCardNumber;
	private EditText mBeamText;
	
	private static final String TAG = "XML";  

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cardnumber);
		
		btnAddCardNumber = (Button)findViewById(R.id.AddCardNumber);
		mBeamText = (EditText) findViewById(R.id.edittext_beam_text);
		
		SharedPreferences userInfo = getSharedPreferences("Card", 0);  
        String CardID = userInfo.getString("CardID", "");    
		if(!CardID.equals(""))
			mBeamText.setText(CardID);

		btnAddCardNumber.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				SharedPreferences cardNumber = getSharedPreferences("Card", 0);  
				cardNumber.edit().putString("CardID", mBeamText.getText().toString()).commit();  
				//Toast.makeText(this, "…Ë÷√ø®∫≈≥…π¶", Toast.LENGTH_LONG).show();
			}
		});
		
		
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.setCardNumber:
            
            return true;
        case R.id.MainActivy:
        	Intent serverIntent = new Intent(this, AndroidBeamMainActivity.class);
            startActivity(serverIntent);
            return true;
        }
        return false;
    }

}
