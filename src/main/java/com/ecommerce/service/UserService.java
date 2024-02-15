package com.ecommerce.service;

import com.ecommerce.dto.UserDto;
import com.ecommerce.exception.UserException;

public interface UserService {

    UserDto findByFiscalCode (String fiscalCode) throws UserException;

    UserDto findByUsername (String userName) throws UserException;
}
