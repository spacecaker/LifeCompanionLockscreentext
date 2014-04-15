package com.touchwizres.lifecompaniontext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.provider.Settings;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.margaritov.preference.colorpicker.ColorPickerPreference;

public class CompanionText extends PreferenceActivity {
	
	ImageView imageView;
	ImageView done;
	EditText name;
	String comptext;
	String companionsName;
	TextView spacecompanion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.lifercomp);
		setContentView(R.layout.companion_layout);
		
	  
		  spacecompanion = (TextView) findViewById(R.id.Owner);
		  name = (EditText) findViewById(R.id.name_field);
		  done = (ImageView) findViewById(R.id.name);
		
		  //checks shared preferences
		     SharedPreferences sharedPreferences = getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE);

		    	String textSize = sharedPreferences.getString("textsizerchange","40");
		    	((ListPreference)findPreference("textsizerchange")).setSummary(textSize);
		    	
		        ((ListPreference)findPreference("textsizerchange")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

					@Override
					public boolean onPreferenceChange(Preference preference, Object newValue) {
						String type = (String.valueOf(newValue));
						Intent i = new Intent();
						i.setAction("lifecompanion.CHANGE_COMPANION_SIZE");
						i.putExtra("textSizer",type);
						sendBroadcast(i);
						preference.setSummary(type);
						SharedPreferences sharedPreferences = getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE);
			            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
			            editor.putString("textsizerchange", type); //true or false
			            editor.commit();			
						return true;
					}

		        });
		    		        
		     companionsName = sharedPreferences.getString("companionName","null");
		     if (companionsName == "null") {
		    	 spacecompanion.setText("Life companion"); 					
			     } else {
			    	 	spacecompanion.setText(companionsName);
				    	name.setText(companionsName); 
				     };
		  
				done.setOnClickListener(new View.OnClickListener() {
			
				public void onClick(View v) {
					Editable companionName = name.getText();
					spacecompanion.setText(companionName.toString());
					Intent intent = new Intent();
					intent.setAction("lifecompanion.CHANGE_COMPANION");
					intent.putExtra("NAME", companionName.toString() );
					sendBroadcast(intent);
			        SharedPreferences sharedPreferences = getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE);
			        SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
			        editor.putString("companionName", companionName.toString()); //true or false
			        editor.commit();			        
			        try {
			        	ClickedTextBox("Companion name changed!");			        	
			        } catch (Exception ex) {
			        	ClickedTextBox("Companion name not changed!");
					}
		        }
		});	

		        ((ColorPickerPreference)findPreference("lifecompanionColor")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

		 			@Override
		 			public boolean onPreferenceChange(Preference preference, Object newValue) {
		 				comptext = (ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(newValue))));;
		 				preference.setSummary(comptext);
		 	            SharedPreferences sharedPreferences = getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE);
		 	            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
		 	            editor.putString("lifecompanionColor", comptext); //true or false
		 	            editor.commit();
		 				Intent intent = new Intent();
		 				intent.setAction("lifecompanion.CHANGE_COMPANION_COLOR");
		 				intent.putExtra("lifecompanionColor",comptext.toString());
		 				sendBroadcast(intent);				
		 				return false;
		 			}

		         });
		         String lifecompanioncolor = getSharedPreferences("LifeCompanionFile",Context.MODE_WORLD_READABLE).getString("lifecompanionColor","#ffffffff");
		 	    
		 	    ((ColorPickerPreference)findPreference("lifecompanionColor")).setDefaultValue(lifecompanioncolor);
		 	    ((ColorPickerPreference)findPreference("lifecompanionColor")).setSummary(lifecompanioncolor);				
	}
	
	public void ClickedTextBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}	
}

