/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author AhNAF TAzWAR
 */
public abstract class User implements Serializable {
    protected int id;
    protected String name, pass, contactNo, country, cardNo, dob;
    protected char gender;
    boolean isBanned;
    
    abstract boolean isBanned(int id, String pass);

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }
    
    
    
    
}
