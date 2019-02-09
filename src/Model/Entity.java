/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class Entity {
    private String username;
    private String password;
    private Type type;
    
    public Entity(String username, String password, Type type){
        this.username=username;
        this.password=password;
        this.type=type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Type getType() {
        return type;
    }
    
    
}
