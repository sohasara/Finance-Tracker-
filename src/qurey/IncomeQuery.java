/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qurey;

import db.*;
import java.util.*;
import exception.NullException;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nadiaislam
 */
interface Income {

    public void insert(IncomeEntity income, Statement statement) throws Exception;

    public void delete(int income_id, Statement statement) throws Exception;

    public void deleteAllbin(int user_id, Statement statement) throws Exception;

    public void deletebin(int income_id, Statement statement) throws Exception;

    public void update(IncomeEntity income, Statement statement) throws Exception;

    public List<IncomeEntity> read(int user_id, Statement statement) throws NullException;

    public List<IncomeEntity> bin(int user_id, Statement statement) throws NullException;

    public void restoreAll(int user_id, Statement statement);

    public void restore(int income_id, Statement statement);

}

public class IncomeQuery implements Income {

    @Override
    public void insert(IncomeEntity income, Statement statement) throws Exception {
        System.out.println("Income ID :" + income.income_id);
        String query = "INSERT INTO income(category, amount, date, user_id) VALUES ('" + income.category + "'," + income.amount + ",'" + income.date + "'," + income.user_id + ")";
        if (income.income_id != 0) {
            query = "INSERT INTO income(id,category, amount, date, user_id) VALUES (" + income.income_id + ",'" + income.category + "'," + income.amount + ",'" + income.date + "'," + income.user_id + ")";
        }
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception();
        }
    }

    @Override
    public List<IncomeEntity> read(int user_id, Statement statement) throws NullException {
        List<IncomeEntity> results = new ArrayList<>();
        String query = "SELECT * FROM income WHERE user_id = " + user_id + " AND YEAR(date) = YEAR(CURDATE()) AND MONTH(date) = MONTH(CURDATE()) ORDER BY id DESC";
        try {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                results.add(new IncomeEntity(result.getInt("id"), result.getInt("user_id"), result.getDouble("amount"), result.getString("category"), result.getString("date")));
                while (result.next()) {
                    results.add(new IncomeEntity(result.getInt("id"), result.getInt("user_id"), result.getDouble("amount"), result.getString("category"), result.getString("date")));
                }

            } else {
                throw new NullException();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return results;
    }

    @Override
    public void delete(int income_id, Statement statement) throws Exception {
        String query = "DELETE FROM income WHERE id = " + income_id + "";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception();
        }
    }

    @Override
    public void update(IncomeEntity income, Statement statement) throws Exception {
        String query = "UPDATE income SET category ='" + income.category + "',amount =" + income.amount + ",date='" + income.date + "' WHERE id =" + income.income_id + "";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception();
        }
    }

    @Override
    public List<IncomeEntity> bin(int user_id, Statement statement) throws NullException {
        List<IncomeEntity> results = new ArrayList<>();
        String query = "SELECT * FROM income_backup WHERE user_id = " + user_id + " ORDER BY id DESC";
        try {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                results.add(new IncomeEntity(result.getInt("id"), result.getInt("user_id"), result.getDouble("amount"), result.getString("category"), result.getString("date")));
                while (result.next()) {
                    results.add(new IncomeEntity(result.getInt("id"), result.getInt("user_id"), result.getDouble("amount"), result.getString("category"), result.getString("date")));
                }

            } else {
                throw new NullException();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return results;
    }

    @Override
    public void deleteAllbin(int user_id, Statement statement) throws Exception {
        String query = "DELETE FROM income_backup WHERE user_id = " + user_id + "";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception();
        }
    }

    @Override
    public void restoreAll(int user_id, Statement statement) {
        try {
            List<IncomeEntity> backup = bin(user_id, statement);
            for (IncomeEntity i : backup) {
                insert(i, statement);
            }

            deleteAllbin(user_id, statement);
        } catch (NullException ex) {

        } catch (Exception ex) {
        }
    }

    @Override
    public void deletebin(int income_id, Statement statement) throws Exception {
        String query = "DELETE FROM income_backup WHERE id = " + income_id + "";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception();
        }
    }

    @Override
    public void restore(int income_id, Statement statement) {
        String query = "SELECT * FROM income_backup WHERE id = " + income_id + "";

        try {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                insert(new IncomeEntity(result.getInt("id"), result.getInt("user_id"), result.getDouble("amount"), result.getString("category"), result.getString("date")), statement);
                deletebin(income_id, statement);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } catch (Exception ex) {
        }
    }

}
