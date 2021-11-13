package com.example.DAO;

import com.example.Model.Member;

import java.sql.*;


public class MemberDAO {
    static String driver = "com.mysql.jdbc.Driver";
    static String connectionUrl = "jdbc:mysql://localhost:3306/";
    static String database = "WebLHK";
    static String userid = "root";
    static String password = "root";

    private static final String SELECT_MEMBER = "SELECT * FROM Member";
    private static final String INSERT_MEMBER_BY_ID = "INSERT INTO Member VALUES(?, ?, ?, 'user',  'pass', ?, 'email', ?, 'date', 'time');";
    private static final String DELETE_MEMBER_BY_ID = "DELETE FROM Member WHERE Id = ?";
    private static final String UPDATE_MEMBER_BY_ID = "UPDATE Member SET Firstname = ?, Lastname = ?, Phone = ?, Description = ? WHERE Id = ?";



    public MemberDAO(){}

    protected static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl + database, userid, password);

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    //Select profile by id
    public static Member selectMeber()  {
        Member profile = new Member();
        try(Connection connection = getConnection(); PreparedStatement prepareStatement = connection.prepareStatement( SELECT_MEMBER);){
            ResultSet rs = prepareStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("Id");
                String firstName = rs.getString("Firstname");
                String lastName = rs.getString("Lastname");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                String description = rs.getString("Description");
                profile = new Member(id, firstName, lastName, email, phone, description);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return profile;
    }

    //Insert profile by id
    public static boolean insertMember(Member member) throws SQLException {
        boolean updateCheck = false;
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_MEMBER_BY_ID);) {
            statement.setString(2, member.getFirstName());
            statement.setString(3, member.getLastName());
            statement.setString(4, member.getPhoneNumber());
            statement.setString(5, member.getDescription());
            statement.setInt(1, member.getId());
            updateCheck = statement.executeUpdate() > 0;
        }
        return updateCheck;
    }

    //Update member by id
    public static boolean updateMember(Member member) throws SQLException {
        boolean updateCheck = false;
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_MEMBER_BY_ID);) {
            statement.setString(1, member.getFirstName());
            statement.setString(2, member.getLastName());
            statement.setString(3, member.getPhoneNumber());
            statement.setString(4, member.getDescription());
            statement.setInt(5, member.getId());
            updateCheck = statement.executeUpdate() > 0;
        }
        return updateCheck;
    }

    //Update member by id
    public static boolean deleteMember(int id) throws SQLException {
        boolean updateCheck = false;
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_MEMBER_BY_ID);) {

            statement.setInt(1, id);
            updateCheck = statement.executeUpdate() > 0;
        }
        return updateCheck;
    }

    public static void main(String[] arr) {
        Connection con = getConnection();
        if (con == null){
            System.out.println("error");
        }
        else {
            System.out.println("success");
        }
    }
}