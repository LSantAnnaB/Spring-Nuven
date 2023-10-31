package com.santanna.nuvemspring.services;

import com.santanna.nuvemspring.domain.model.User;

public interface UserService {

  User findById(Long id);

  User create(User userToCreate);
}
