/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.andruszko.lepapp;

import android.os.Bundle;
import roboguice.activity.RoboPreferenceActivity;

/**
 *
 * @author wtk300
 */
public class PreferencesActivity extends RoboPreferenceActivity
 {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.userpref);
        
    }
}
