package ru.icl.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ru.icl.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl implements UserDao{
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;
    
    @Override
    public void addUser(User user) throws SQLException {
        String sqlAddUser = "insert into public.user (clientid, fname) values (?, ?)";
        try {
            conn = DataBase.getConnection();                       
            pstmt = conn.prepareStatement(sqlAddUser);
            pstmt.setString(1, user.getClientid());
            pstmt.setString(2, user.getFname());
            pstmt.executeUpdate();                                            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {                
            try {                    
                if (pstmt!=null) pstmt.close();
//                if (conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
        }                    
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        String sqlDeleteUser = "delete from public.user where clientid=?";        
        try(Connection conn = DataBase.getConnection();  
            PreparedStatement pstmt = conn.prepareStatement(sqlDeleteUser);
            ) {
            pstmt.setString(1, user.getClientid());
            pstmt.executeUpdate();
        } 
    }

    @Override
    public User getUser(String id) throws SQLException {
        User result = null;        
        String sqlGetUser = "select clientid, fname from public.user where clientid=?";
        try {
            conn = DataBase.getConnection();                       
            pstmt = conn.prepareStatement(sqlGetUser);
            pstmt.setString(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                result.setClientid(resultSet.getString(1));
                result.setFname(resultSet.getString(2));                          
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {                
            try {                    
                if (pstmt!=null) pstmt.close();
//                if (conn!=null)conn.close();
                if(resultSet !=null) resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
        }    
        return result;  
    }

    @Override
    public List<User> getUsers() throws SQLException {
       
        List<User> users = new ArrayList<>();               
        
        String sqlGetUsers = "select clientid, fname from public.user";
        
        try {
            conn = DataBase.getConnection();                       
            pstmt = conn.prepareStatement(sqlGetUsers);
            ResultSet resultSet = pstmt.executeQuery();
            
            while(resultSet.next()){
                String clientid = resultSet.getString(1);
                String fname = resultSet.getString(2);
                users.add(new User(clientid, fname));          
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {                
            try {                    
                if (pstmt!=null) pstmt.close();
//                if (conn!=null)conn.close();
                if(resultSet !=null) resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
        }       

        return users;
    }
    
    
//    @Autowired
//    private DataSource dataSource;
//        
//    @Override
//    @Transactional
//    public void addUser(User user) throws SQLException {
//        String sqlAddUser = "insert into public.user (clientid, fname) values (?, ?)";
//        try {
//            conn = dataSource.getConnection();                       
//            pstmt = conn.prepareStatement(sqlAddUser);
//            pstmt.setString(1, user.getClientid());
//            pstmt.setString(2, user.getFname());
//            pstmt.executeUpdate();                                            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {                
//            try {                    
//                if (pstmt!=null) pstmt.close();
////                if (conn!=null)conn.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            } 
//        }                    
//    }
//
//    @Override
//    @Transactional
//    public void deleteUser(User user) throws SQLException {
//        String sqlDeleteUser = "delete from public.user where clientid=?";        
//        try(Connection conn = DataBase.getConnection();  
//            PreparedStatement pstmt = conn.prepareStatement(sqlDeleteUser);
//            ) {
//            pstmt.setString(1, user.getClientid());
//            pstmt.executeUpdate();
//        } 
//    }
//
//    @Override
//    @Transactional
//    public User getUser(String id) throws SQLException {
//        User result = null;        
//        String sqlGetUser = "select clientid, fname from public.user where clientid=?";
//        try {
//            conn = dataSource.getConnection();                      
//            pstmt = conn.prepareStatement(sqlGetUser);
//            pstmt.setString(1, id);
//            ResultSet resultSet = pstmt.executeQuery();
//            while(resultSet.next()){
//                result.setClientid(resultSet.getString(1));
//                result.setFname(resultSet.getString(2));                          
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {                
//            try {                    
//                if (pstmt!=null) pstmt.close();
////                if (conn!=null)conn.close();
//                if(resultSet !=null) resultSet.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            } 
//        }    
//        return result;  
//    }
//
//    @Override
//    @Transactional
//    public List<User> getUsers() throws SQLException {
//       
//        List<User> users = new ArrayList<>();               
//        
//        String sqlGetUsers = "select clientid, fname from public.user";
//        
//        try {
//            conn = dataSource.getConnection();                  
//            pstmt = conn.prepareStatement(sqlGetUsers);
//            ResultSet resultSet = pstmt.executeQuery();
//            
//            while(resultSet.next()){
//                String clientid = resultSet.getString(1);
//                String fname = resultSet.getString(2);
//                users.add(new User(clientid, fname));          
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {                
//            try {                    
//                if (pstmt!=null) pstmt.close();
////                if (conn!=null)conn.close();
//                if(resultSet !=null) resultSet.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            } 
//        }       
//
//        return users;
//    }

}
