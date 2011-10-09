/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.andruszko.lepapp.module;

import com.google.inject.AbstractModule;
import net.andruszko.lepapp.service.RandomLepItemService;
import net.andruszko.lepapp.service.RandomLepItemServiceImpl;

/**
 *
 * @author wtk300
 */
public class LepModule extends AbstractModule {

    @Override
    protected void configure() {
        // requestStaticInjection(DBAdapter.class);
        bind(RandomLepItemService.class).to(RandomLepItemServiceImpl.class);
    }
    
}
