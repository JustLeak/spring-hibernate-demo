package by.intexsoft.demo.service;

import by.intexsoft.demo.dao.IUserDAO;
import by.intexsoft.demo.entity.User;
import by.intexsoft.demo.model.ServiceResponse;
import by.intexsoft.demo.util.Validator;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final IUserDAO userDAO;

    public UserService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public ServiceResponse find(Long id) {
        if (!Validator.isValidId(id)) {
            return new ServiceResponse<>(false, "Illegal user id value. User id  = " + id + ".");
        }
        User user = userDAO.find(id);
        if (user == null) {
            return new ServiceResponse<>(false, "User with id = " + id + " is not found.");
        }
        return new ServiceResponse<>(true, user);
    }

    @Override
    public ServiceResponse create(User entity) {
        String errors = validateUser(entity);
        if (errors != null) {
            return new ServiceResponse<>(false, errors);
        }
        return new ServiceResponse<>(true, userDAO.create(entity));
    }

    @Override
    public ServiceResponse update(User entity) {
        String errors = validateUser(entity);
        if (errors != null) {
            return new ServiceResponse<>(false, errors);
        }
        if (!Validator.isValidId(entity.getId())) {
            return new ServiceResponse<>(false, "Illegal user id value. User id = " + entity.getId() + ".");
        }
        return new ServiceResponse<>(true, userDAO.update(entity));
    }

    @Override
    public ServiceResponse delete(User entity) {
        if (entity == null) {
            return new ServiceResponse<>(false, "User entity must not be null.");
        }
        if (!Validator.isValidId(entity.getId())) {
            return new ServiceResponse<>(false, "Illegal user id value. User id  = " + entity.getId() + ".");
        }
        userDAO.delete(entity);
        return new ServiceResponse<>(true, "User with id = " + entity.getId() + " deleted successfully.");
    }

    private String validateUser(User user) {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder("Invalid user entity date: ");
        if (user == null) {
            return "User entity must not be null.";
        }
        if (!Validator.isValidName(user.getName())) {
            isValid = false;
            errorMessage.append("User name: ").append(user.getName());
        }
        if (!Validator.isValidName(user.getSurname())) {
            isValid = false;
            errorMessage.append("User surname.").append(user.getSurname());
        }
        return isValid ? null : errorMessage.toString();
    }
}
