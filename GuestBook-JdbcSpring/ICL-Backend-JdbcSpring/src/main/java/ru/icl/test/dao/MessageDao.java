package ru.icl.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ru.icl.test.entity.Message;

public interface MessageDao {
    public void addMessage(Message message) throws SQLException;
    public void deleteMessage(int id) throws SQLException;
    public Message getMessage(int id) throws SQLException;
    public List<Message> getMessages() throws SQLException;
}
