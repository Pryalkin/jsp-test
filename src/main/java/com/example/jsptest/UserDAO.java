package com.example.jsptest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static Connection conn;

    static {
        String userName = "root";
        String password = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/jsp";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select users.id, users.username, users.rating, users.NumberOfVisits, users.CurrentVisitingTime from users");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setUserId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setRating(rs.getDouble(3));
            user.setNumberOfVisits(rs.getInt(4));
            user.setCurrentVisitingTime(rs.getDate(5));
            users.add(user);
        }
        return users;
    }

    public void add(User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into users (username, rating, numberOfVisits, currentVisitingTime) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getUsername());
        ps.setDouble(2, user.getRating());
        ps.setInt(3, user.getNumberOfVisits());
        ps.setDate(4, user.getCurrentVisitingTime());
        ps.execute();
    }

    public void update(User user) throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate("UPDATE users SET username = '" + user.getUsername() +
                "', rating = " + user.getRating() + ", numberOfVisits = " + user.getNumberOfVisits() +
                " where id = " + user.getUserId());
    }
}
