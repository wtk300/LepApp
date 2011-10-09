/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.andruszko.lepapp;

import com.google.inject.Module;
import java.util.List;
import net.andruszko.lepapp.module.LepModule;
import roboguice.application.RoboApplication;

/**
 * 
 * @author wtk300
 */
public class LepApplication extends RoboApplication{
    
    @Override
     protected void addApplicationModules(List<Module> modules) {
        modules.add(new LepModule());
    }

    
}
