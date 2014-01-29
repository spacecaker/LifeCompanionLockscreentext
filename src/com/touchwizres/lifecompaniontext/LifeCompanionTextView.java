package com.touchwizres.lifecompaniontext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class LifeCompanionTextView extends TextView {
	
	TextView profilename;
    String name;
	public LifeCompanionTextView(final Context context, AttributeSet attrs) {
	super(context, attrs); 
	
		 profilename = (TextView) findViewById(R.id.life_companion_tag);
	     SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_PRIVATE);    
	     name = sharedPreferences.getString("companionName","Life companion");
     	 profilename.setText(name);
         Typeface tf = Typeface.createFromFile("/system/fonts/SpaceFont.ttf");
         profilename.setTypeface(tf);

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent i) {
        	name = i.getStringExtra("NAME");
        	profilename.setText(name);
            SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
            editor.putString("companionName", name); //true or false
            editor.commit();	 
        }
        
    };      
    
    context.registerReceiver(mReceiver, new IntentFilter("lifecompanion.CHANGE_COMPANION"));  
	}


}
