/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qurey;

import db.SavingsEntity;
import exception.NullException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
interface Savings {

    public SavingsEntity total_saving(int user_id, Statement statement) throws NullException;

    public List<SavingsEntity> history(int user_id, Statement statement) throws NullException;
}

public class SavingsQuery implements Savings {

    @Override
    public SavingsEntity total_saving(int user_id, Statement statement) throws NullException {
        SavingsEntity results = null;
        String query = "SELECT SUM(expense) as total_expense,SUM(income) as total_income\n"
                + "FROM savings\n"
                + "WHERE YEAR(date) = YEAR(CURDATE()) AND MONTH(date) = MONTH(CURDATE()) AND user_id = " + user_id + "";
        try {
            ResultSet result;
            result = statement.executeQuery(query);
            if (result.next()) {
                results = new SavingsEntity(result.getDouble("total_income"), result.getDouble("total_expense"));
            } else {
                throw new NullException();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return results;
    }

    @Override
    public List<SavingsEntity> history(int user_id, Statement statement) throws NullException {
        List<SavingsEntity> results = new ArrayList<>();

        String query = "SELECT SUM(savings.income) as total_income,SUM(savings.expense) as total_expense,DATE_FORMAT(savings.date,'%M,%Y') as date,users.user_name FROM savings JOIN users ON savings.user_id = users.user_id WHERE savings.user_id = " + user_id + " GROUP BY MONTH(savings.date)";

        try {
            ResultSet result;
            result = statement.executeQuery(query);
            if (result.next()) {
                results.add(new SavingsEntity(result.getDouble("total_income"), result.getDouble("total_expense"), result.getString("date"), result.getString("user_name")));
                while (result.next()) {
                    results.add(new SavingsEntity(result.getDouble("total_income"), result.getDouble("total_expense"), result.getString("date"), result.getString("user_name")));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return results;

    }
}
