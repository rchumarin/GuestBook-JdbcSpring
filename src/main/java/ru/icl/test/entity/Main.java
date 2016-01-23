
package ru.icl.test.entity;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.icl.test.dao.MessageDao;
import ru.icl.test.dao.MessageDao;
import ru.icl.test.dao.MessageDaoImpl;
import ru.icl.test.dao.UserDao;
import ru.icl.test.dao.UserDao;
import ru.icl.test.dao.UserDaoImpl;
import ru.icl.test.entity.Message;

public class Main {
    

    private MessageDao messagedao;
    
    private UserDao userdao;

    public MessageDao getMessagedao() {
        return messagedao;
    }
    public void setMessagedao(MessageDao messageDao) {
        this.messagedao = messageDao;
    }

    public UserDao getUserdao() {
        return userdao;
    }
    public void setUserdao(UserDao userDao) {
        this.userdao = userDao;
    }

    public static void main(String[] args) throws SQLException {
        
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springContext.xml");
//        MessageDao myBean = ctx.getBean("mainbean", MessageDaoImpl.class);            
//        for (Message msg : myBean.getMessages()){        
//            System.out.println(msg.getId() + "\t"
//                    + msg.getUser().getClientid() + "\t"
//                    + msg.getMessage());
//            System.out.println();
//        }
        
        
//        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
//        BeanFactory factory = (BeanFactory) context;
//        Main myBean = (Main) factory.getBean("mainbean");        
//        
//        for (Message msg : myBean.getMessagedao().getMessages()){        
//            System.out.println(msg.getId() + "\t"
//                    + msg.getClientid() + "\t"
//                    + msg.getMessage());
//            System.out.println();
//        }
//        
//        System.out.println();
        

//            MessageDao messageDao = new MessageDaoImpl();
//            for (Message msg : messageDao.getMessages()) {
//                System.out.println(msg.getId() + "\t"
//                            + msg.getClientid() + "\t"
//                            + msg.getMessage());
//                System.out.println();
//    }            
////            System.out.println("====================================================");
            
//            User user = new User("89270301306", "Sex mashinA");
//            UserDao userDao = new UserDaoImpl();
//            userDao.addUser(user);
// 
//            for (User usr : userDao.getUsers()) {
//                System.out.println(usr.getClientid() + "\t"
//                            + usr.getFname());
//                System.out.println();
//            }            
//            System.out.println("====================================================");


            
    }
    
}


     