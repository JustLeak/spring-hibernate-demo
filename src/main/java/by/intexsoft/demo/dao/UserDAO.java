package by.intexsoft.demo.dao;

import by.intexsoft.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends CrudDAO<User, Long> implements IUserDAO {
    public UserDAO() {
        super(User.class);
    }
}
