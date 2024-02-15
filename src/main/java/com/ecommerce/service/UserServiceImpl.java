package com.ecommerce.service;

import com.ecommerce.dto.UserDto;
import com.ecommerce.entity.UserData;
import com.ecommerce.exception.UserException;
import com.ecommerce.mapper.UserMapper;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto findByFiscalCode(String fiscalCode) throws UserException {

        UserData userData = userRepository.findByFiscalCode(fiscalCode).orElseThrow(() -> new UserException("Nessun utente trovato con fiscalCode: " + fiscalCode));
        return userMapper.toUserDto(userData);
    }

    @Override
    public UserDto findByUsername(String username) throws UserException {

        UserData userData = userRepository.findByUserName(username).orElseThrow(() -> new UserException("Nessun utente trovato con username: " + username));
        return userMapper.toUserDto(userData);
    }
}
