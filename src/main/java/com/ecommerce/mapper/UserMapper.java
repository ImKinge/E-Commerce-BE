package com.ecommerce.mapper;

import com.ecommerce.dto.UserDto;
import com.ecommerce.entity.UserData;

public interface UserMapper {

    UserDto toUserDto (UserData userData);

}
