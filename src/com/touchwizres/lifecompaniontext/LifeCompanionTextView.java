package com.touchwizres.lifecompaniontext;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class LifeCompanionTextView extends TextView {
	
	TextView lifename;
	String lifecompColor;
    String spacename;
    String textSizer;
    String companionShow;
    String message;
    
	public LifeCompanionTextView(final Context context, AttributeSet attrs) {
	super(context, attrs);
	
		// id0value
       	lifename = (TextView) findViewById(R.id.life_companion_tag);    
       	
       	// preference
	    SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE);
	    
	    // textchanger
	    spacename = sharedPreferences.getString("companionName","Life companion");
	    lifename.setText(spacename);
	    
	    // color
    	lifecompColor = sharedPreferences.getString("lifecompanionColor","#ffffffff");
    	lifename.setTextColor(Color.parseColor(lifecompColor));
    		    
	    // font
        Typeface tf = Typeface.createFromFile("/system/fonts/SpaceFont.ttf");
        lifename.setTypeface(tf);
	    
        // options
	    textSizer = sharedPreferences.getString("type","40");
	     	if ("40".equals(textSizer)) {
	     		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
	    	}
	    	else if ("30".equals(textSizer)) {
	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
	    	} 
	    	else if ("20".equals(textSizer)) {
	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
	    	}
	    	else if ("15".equals(textSizer)) {
	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
	    	}
	    	else if ("10".equals(textSizer)) {
	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
	    	}		     	
	    	else if ("5".equals(textSizer)) {
	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 5);
	    	}	     	
	     		        
	        BroadcastReceiver mTextSizerReceiver = new BroadcastReceiver() {
	            @Override
	            public void onReceive(Context c, Intent i) {
	            	message = i.getStringExtra("textSizer");
	            	
	            	if ("40".equals(message )) {
	            		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
	            	}
	            	else if ("30".equals(message )) {
	            		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
	            	}
	    	    	else if ("20".equals(message)) {
	    	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
	    	    	}
	    	    	else if ("15".equals(message)) {
	    	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
	    	    	}
	    	    	else if ("10".equals(message)) {
	    	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
	    	    	}	
	    	    	else if ("5".equals(message)) {
	    	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 5);
	    	    	}	            	
	            }
	            
	        };  
	        
	    BroadcastReceiver mLifeColorReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent i) {
            	lifecompColor = i.getStringExtra("lifecompanionColor");
          	  	lifename.setTextColor(Color.parseColor(lifecompColor));
          	  	SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE);
              	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
              	editor.putString("lifecompanionColor", lifecompColor); //true or false
              	editor.commit();	 
            }            
        };
        
        BroadcastReceiver mReceiver = new BroadcastReceiver() {
        	@Override
        	public void onReceive(Context c, Intent i) {
        		spacename = i.getStringExtra("NAME");
        		lifename.setText(spacename);
        		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE);
        		SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
        		editor.putString("companionName", spacename); //true or false
        		editor.commit();	 
        }       
    };   
    
    context.registerReceiver(mTextSizerReceiver, new IntentFilter("lifecompanion.CHANGE_COMPANION_SIZE"));   
    context.registerReceiver(mLifeColorReceiver, new IntentFilter("lifecompanion.CHANGE_COMPANION_COLOR"));
    context.registerReceiver(mReceiver, new IntentFilter("lifecompanion.CHANGE_COMPANION"));    
	}
}
