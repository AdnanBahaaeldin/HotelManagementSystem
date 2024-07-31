package com.adnan.hotelreservationsystem.DtoMapper;

import com.adnan.hotelreservationsystem.Dto.DtoUser;
import com.adnan.hotelreservationsystem.Model.User;

public class DtoUserMapper {
    public static DtoUser map(User user) {
        return new DtoUser(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }
}
