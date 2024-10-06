/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author nadiaislam
 */
public class UserEntity {

    public int user_id;
    public String user_name;
    public String user_pass;

    public UserEntity(int user_id, String user_name, String user_pass) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pass = user_pass;
    }

    public UserEntity(int user_id, String user_pass) {
        this.user_id = user_id;
        this.user_pass = user_pass;
    }

}
