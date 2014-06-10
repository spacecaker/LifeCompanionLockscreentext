package com.touchwizres.lifecompaniontext;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class LifeCompanionTextView extends TextView {
	
	TextView lifename;
	String lifecompColor;
    String spacename;
    String textFontSize;
    String textFont;
    String companionShow;
    String message;
    
	public LifeCompanionTextView(final Context context, AttributeSet attrs) {
	super(context, attrs);
	
		// id0value
       	lifename = (TextView) findViewById(R.id.life_companion_tag);    
       	
       	// preference
	    SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	    // textchanger
	    spacename = sharedPreferences.getString("companionName","Life companion");
	    lifename.setText(spacename);
	    
	    // color
    	lifecompColor = sharedPreferences.getString("lifecompanionColor","#ffffffff");
    	lifename.setTextColor(Color.parseColor(lifecompColor));

	    textFontSize = sharedPreferences.getString("fontsize","40");
     	if ("40".equals(textFontSize)) {
     		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
    	}
    	else if ("30".equals(textFontSize)) {
            lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
    	} 
    	else if ("20".equals(textFontSize)) {
            lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
    	}
    	else if ("15".equals(textFontSize)) {
            lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
    	}
    	else if ("10".equals(textFontSize)) {
            lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
    	}		     	
    	else if ("5".equals(textFontSize)) {
            lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 5);
    	}		     	
	     	
		    textFont = sharedPreferences.getString("font","samsungs5");
	     	if ("samsungs5".equals(textFont)) {
	     		Typeface tf = Typeface.createFromFile("/system/fonts/SpaceFont.ttf");
	            lifename.setTypeface(tf);
	    	}
	    	else if ("droidsans".equals(textFont)) {
	            Typeface tf = Typeface.createFromFile("/system/fonts/DroidSans.ttf");
	            lifename.setTypeface(tf);
	    	} 
	    	else if ("droidsansmono".equals(textFont)) {
	            Typeface tf = Typeface.createFromFile("/system/fonts/DroidSansMono.ttf");
	            lifename.setTypeface(tf);
	    	}
	    	else if ("droidsansbold".equals(textFont)) {
	            Typeface tf = Typeface.createFromFile("/system/fonts/DroidSans-Bold.ttf");
	            lifename.setTypeface(tf);
	    	}
	    	else if ("droidserif".equals(textFont)) {
	            Typeface tf = Typeface.createFromFile("/system/fonts/DroidSerif-Regular.ttf");
	            lifename.setTypeface(tf);
	    	}		     	
	    	else if ("droidserifitalic".equals(textFont)) {
	            Typeface tf = Typeface.createFromFile("/system/fonts/DroidSerif-Italic.ttf");
	            lifename.setTypeface(tf);
	    	}	     	
	     	
	        BroadcastReceiver mTextFonterReceiver = new BroadcastReceiver() {
	            @Override
	            public void onReceive(Context c, Intent i) {
	            	message = i.getStringExtra("textFont");
	            	
	            	if ("samsungs5".equals(message )) {
	    	            Typeface tf = Typeface.createFromFile("/system/fonts/SpaceFont.ttf");
	    	            lifename.setTypeface(tf);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("font", message); //true or false
	                  	editor.commit();
	            	}
	            	else if ("droidsans".equals(message )) {
	            		Typeface tf = Typeface.createFromFile("/system/fonts/DroidSans.ttf");
	    	            lifename.setTypeface(tf);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("font", message); //true or false
	                  	editor.commit();
	            	}
	    	    	else if ("droidsansmono".equals(message)) {
	    	    		Typeface tf = Typeface.createFromFile("/system/fonts/DroidSansMono.ttf");
	    	            lifename.setTypeface(tf);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("font", message); //true or false
	                  	editor.commit();
	    	    	}
	    	    	else if ("droidsansbold".equals(message)) {
	    	    		Typeface tf = Typeface.createFromFile("/system/fonts/DroidSans-Bold.ttf");
	    	            lifename.setTypeface(tf);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("font", message); //true or false
	                  	editor.commit();
	    	    	}
	    	    	else if ("droidserif".equals(message)) {
	    	    		Typeface tf = Typeface.createFromFile("/system/fonts/DroidSerif-Regular.ttf");
	    	            lifename.setTypeface(tf);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("font", message); //true or false
	                  	editor.commit();
	    	    	}	
	    	    	else if ("droidserifitalic".equals(message)) {
	    	    		Typeface tf = Typeface.createFromFile("/system/fonts/DroidSerif-Italic.ttf");
	    	            lifename.setTypeface(tf);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("font", message); //true or false
	                  	editor.commit();
	    	    	}	            	
	            }	            
	        }; 
	        
			BroadcastReceiver mTextSizerReceiver = new BroadcastReceiver() {
	            @Override
	            public void onReceive(Context c, Intent i) {
	            	message = i.getStringExtra("textFontSize");
	            	
	            	if ("40".equals(message )) {
	    	            lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("fontsize", message); //true or false
	                  	editor.commit();
	            	}
	            	else if ("30".equals(message )) {
	            		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("fontsize", message); //true or false
	                  	editor.commit();
	            	}
	    	    	else if ("20".equals(message)) {
	    	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("fontsize", message); //true or false
	                  	editor.commit();
	    	    	}
	    	    	else if ("15".equals(message)) {
	    	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("fontsize", message); //true or false
	                  	editor.commit();
	    	    	}
	    	    	else if ("10".equals(message)) {
	    	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("fontsize", message); //true or false
	                  	editor.commit();
	    	    	}	
	    	    	else if ("5".equals(message)) {
	    	    		lifename.setTextSize(TypedValue.COMPLEX_UNIT_SP, 5);
	            		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
	                  	SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	                  	editor.putString("fontsize", message); //true or false
	                  	editor.commit();
	    	    	}	            	
	            }	            
	        }; 
	        
	    BroadcastReceiver mLifeColorReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent i) {
            	lifecompColor = i.getStringExtra("lifecompanionColor");
          	  	lifename.setTextColor(Color.parseColor(lifecompColor));
          	  	SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
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
        		SharedPreferences sharedPreferences = context.getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
        		SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
        		editor.putString("companionName", spacename); //true or false
        		editor.commit();	 
        }       
    };   
    
    context.registerReceiver(mTextFonterReceiver, new IntentFilter("lifecompanion.CHANGE_COMPANION_FONT"));
    context.registerReceiver(mTextSizerReceiver, new IntentFilter("lifecompanion.CHANGE_COMPANION_SIZE"));   
    context.registerReceiver(mLifeColorReceiver, new IntentFilter("lifecompanion.CHANGE_COMPANION_COLOR"));
    context.registerReceiver(mReceiver, new IntentFilter("lifecompanion.CHANGE_COMPANION"));    
	}
}
