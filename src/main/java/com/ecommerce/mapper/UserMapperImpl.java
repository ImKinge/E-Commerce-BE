package com.ecommerce.mapper;

import com.ecommerce.dto.UserDto;
import com.ecommerce.entity.UserData;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public UserDto toUserDto(UserData userData) {

        if(userData == null) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setFiscalCode(userData.getFiscalCode());
        userDto.setAddress(userData.getAddress());
        userDto.setName(userData.getName());
        userDto.setSurname(userData.getSurname());
        userDto.setEmail(userData.getEmail());
        userDto.setPassword(userData.getPassword());
        userDto.setInfoPhone(userData.getInfoPhone());
        userDto.setDateOfBirth(userData.getDateOfBirth());


        return userDto;
    }
}
