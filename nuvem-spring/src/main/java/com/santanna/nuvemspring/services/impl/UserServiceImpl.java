package com.santanna.nuvemspring.services.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanna.nuvemspring.domain.model.User;
import com.santanna.nuvemspring.domain.repositories.UserRepository;
import com.santanna.nuvemspring.services.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User findById(Long id) {
    return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public User create(User userToCreate) {
    if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
      throw new IllegalArgumentException("This Account number already exists.");
    }
    return userRepository.save(userToCreate);
  }

}
