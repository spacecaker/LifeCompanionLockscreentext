package com.touchwizres.lifecompaniontext;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CompanionText extends Activity {
	
	ImageView imageView;
	ImageView done;
	EditText name;
	String companionsName;
	TextView owner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.companion_layout);
		
		  owner = (TextView) findViewById(R.id.Owner);
		  name = (EditText) findViewById(R.id.name_field);
		  done = (ImageView) findViewById(R.id.name);
		
		  //checks shared preferences
		     SharedPreferences sharedPreferences = getSharedPreferences("LifeCompanionFile",Context.MODE_PRIVATE); 
		     companionsName = sharedPreferences.getString("companionName","null");
		     if (companionsName == "null") {
					owner.setText("Life companion"); 					
			     } else {
				    	owner.setText(companionsName);
				    	name.setText(companionsName); 
				     };
		  
				done.setOnClickListener(new View.OnClickListener() {
			
				public void onClick(View v) {
					Editable profileName = name.getText();
					owner.setText(profileName.toString());
					Intent intent = new Intent();
					intent.setAction("lifecompanion.CHANGE_COMPANION");
					intent.putExtra("NAME", profileName.toString() );
					sendBroadcast(intent);
			        SharedPreferences sharedPreferences = getSharedPreferences("LifeCompanionFile",Context.MODE_PRIVATE);
			        SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
			        editor.putString("companionName", profileName.toString()); //true or false
			        editor.commit();
		        }
		});
	}
}

