package ru.icl.test.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.icl.test.dao.MessageDao;
import ru.icl.test.dao.MessageDaoImpl;
import ru.icl.test.entity.Message;
import ru.icl.test.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.icl.test.dao.UserDao;

@WebServlet(name="AllMessage", urlPatterns = {"/allmessage"})

public class AllMessage extends HttpServlet {
    
    //SpringBean
    private MessageDao msgdao;
//    private UserDao usrdao;
    public MessageDao getMsgdao() {
        return msgdao;
    }
    public void setMsgdao(MessageDao messageDao) {
        this.msgdao = messageDao;
    }
 
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
              
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        BeanFactory factory = (BeanFactory) context;
        AllMessage allBean = (AllMessage) factory.getBean("allbean");
        ArrayList<Message> messageList = new ArrayList<Message>(); 
        if (!messageList.isEmpty()) {
            request.setAttribute("mess", messageList);
        } else {            
            try {
                request.setAttribute("mess", allBean.getMsgdao().getMessages());
            } catch (SQLException ex) {
                Logger.getLogger(AllMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.getRequestDispatcher("pages/allmessage.jsp").forward(request, response);

        }
}
