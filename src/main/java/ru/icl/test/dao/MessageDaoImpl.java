package ru.icl.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ru.icl.test.entity.Message;
import ru.icl.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import org.springframework.transaction.annotation.Transactional;


public class MessageDaoImpl implements MessageDao{
    
    Connection conn =null;
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;
    
    @Override
    public void addMessage(Message message) throws SQLException {
        String sqlAddMessage = "insert into public.message (clientid, message) values (?, ?)";
        try {
            conn = DataBase.getConnection();                       
            pstmt = conn.prepareStatement(sqlAddMessage);
            pstmt.setString(1, message.getClientid());
            pstmt.setString(2, message.getMessage());
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
    public void deleteMessage(int id) throws SQLException {
        String sqlDeleteMessage = "delete from public.message where id=?";  
        try {
            conn = DataBase.getConnection();   
            pstmt = conn.prepareStatement(sqlDeleteMessage);
            pstmt.setInt(1, id);
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
    public Message getMessage(int id) throws SQLException {
        Message result = null; 
        String sqlGetMessage = "select id, clientid, message from public.message where id=?";
        
        try {
            conn = DataBase.getConnection();                       
            pstmt = conn.prepareStatement(sqlGetMessage);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                result.setId(resultSet.getInt(1));
                result.setClientid(resultSet.getString(2));
                result.setMessage(resultSet.getString(3));           
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
    public List<Message> getMessages() throws SQLException {        
        List<Message> messages = new ArrayList<Message>();
        String sqlGetMessages = "select id, clientid, message from public.message";        
        try {
            conn = DataBase.getConnection();                       
            pstmt = conn.prepareStatement(sqlGetMessages);
            ResultSet resultSet = pstmt.executeQuery();
            
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String clientid = resultSet.getString(2);
                String message = resultSet.getString(3);
                messages.add(new Message(id, clientid, message));          
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
        return messages;
    }
    
    //    @Autowired
//    private DataSource dataSource;
    
//    @Override
//    @Transactional
//    public void addMessage(Message message) throws SQLException {
//        String sqlAddMessage = "insert into public.message (clientid, message) values (?, ?)";
//        try {
//            conn = dataSource.getConnection();                       
//            pstmt = conn.prepareStatement(sqlAddMessage);
//            pstmt.setString(1, message.getClientid());
//            pstmt.setString(2, message.getMessage());
//            pstmt.executeUpdate();
//            pstmt.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {             
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                } 
//            }
//        }                           
//    }
//
//    @Override
//    @Transactional
//    public void deleteMessage(int id) throws SQLException {
//        String sqlDeleteMessage = "delete from public.message where id=?";  
//        try {
//            conn = dataSource.getConnection();   
//            pstmt = conn.prepareStatement(sqlDeleteMessage);
//            pstmt.setInt(1, id);
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
//
//        
////        try(Connection conn = DataBase.getConnection();  
////            PreparedStatement pstmt = conn.prepareStatement(sqlDeleteMessage);
////            ) {
////            pstmt.setInt(1, id);
////            pstmt.executeUpdate();
////        }
//    }
//    
//    @Override
//    @Transactional
//    public Message getMessage(int id) throws SQLException {
//        Message result = null; 
//        String sqlGetMessage = "select id, clientid, message from public.message where id=?";
//        
//        try {
//            conn = dataSource.getConnection();                      
//            pstmt = conn.prepareStatement(sqlGetMessage);
//            pstmt.setInt(1, id);
//            ResultSet resultSet = pstmt.executeQuery();
//            while(resultSet.next()){
//                result.setId(resultSet.getInt(1));
//                result.setClientid(resultSet.getString(2));
//                result.setMessage(resultSet.getString(3));           
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
//    public List<Message> getMessages() throws SQLException {        
//        List<Message> messages = new ArrayList<Message>();
//        String sqlGetMessages = "select id, clientid, message from public.message";
//        
//        try {
//            conn = dataSource.getConnection();                       
//            pstmt = conn.prepareStatement(sqlGetMessages);
//            ResultSet resultSet = pstmt.executeQuery();
//            
//            while(resultSet.next()){
//                int id = resultSet.getInt(1);
//                String clientid = resultSet.getString(2);
//                String message = resultSet.getString(3);
//                messages.add(new Message(id, clientid, message));          
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
//        return messages;
//    }
   
}
