package lk.Ijse.dao.custom;

import lk.Ijse.dao.CrudDAO;
import lk.Ijse.entity.User;

public interface UserDAO extends CrudDAO<User> {
    public User findUserById(String userId) throws Exception;
    public User findUserByname(String username) throws Exception;
}
