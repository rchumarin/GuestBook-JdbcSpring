package ru.icl.test.dao;

import java.sql.SQLException;
import java.util.List;
import ru.icl.test.entity.User;

public interface UserDao {
    public void addUser(User user) throws SQLException;
    public void deleteUser(User user) throws SQLException;
    public User getUser(String id) throws SQLException;
    public List<User> getUsers() throws SQLException;
}
