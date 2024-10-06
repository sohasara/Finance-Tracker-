/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qurey;

import java.sql.*;
import db.UserEntity;
import exception.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nadiaislam
 */
interface User {

    public void insurt(UserEntity userEntity, Statement statement) throws AlreadyExsitException;

    public UserEntity read(UserEntity userEntity, Statement statement) throws NullException;
}

public class UserQuery implements User {

    @Override
    public void insurt(UserEntity userEntity, Statement statement) throws AlreadyExsitException {
        String query = "INSERT INTO users(user_id, user_name, user_pass) VALUES(" + userEntity.user_id + ",'" + userEntity.user_name + "','" + userEntity.user_pass + "')";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new AlreadyExsitException();
        }
    }

    @Override
    public UserEntity read(UserEntity userEntity, Statement statement) throws NullException {
        UserEntity user = null;
        String query = "SELECT * FROM users WHERE user_id = " + userEntity.user_id + " AND user_pass = '" + userEntity.user_pass + "'";
        try {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                user = new UserEntity(result.getInt("user_id"), result.getString("user_name"), result.getString("user_pass"));
            } else {
                throw new NullException();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return user;
    }

}
