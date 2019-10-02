package by.intexsoft.demo.service;

import by.intexsoft.demo.entity.User;
import by.intexsoft.demo.model.ServiceResponse;

public interface IUserService {
    ServiceResponse find(Long id);

    ServiceResponse create(User entity);

    ServiceResponse update(User entity);

    ServiceResponse delete(User entity);
}
