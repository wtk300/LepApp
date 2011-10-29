/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.andruszko.lepapp.vo;

/**
 *
 * @author wtk300
 */
public class SpinnerDict {
    
    private Integer id;
    
    private String descrition;

    public SpinnerDict(Integer id, String descrition) {
        this.id = id;
        this.descrition = descrition;
    }
    
    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return descrition;
    }
    
}
