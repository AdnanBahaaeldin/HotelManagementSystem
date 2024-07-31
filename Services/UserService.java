package com.adnan.hotelreservationsystem.Services;

import com.adnan.hotelreservationsystem.Controller.UserController;
import com.adnan.hotelreservationsystem.Dto.DtoUser;
import com.adnan.hotelreservationsystem.DtoMapper.DtoUserMapper;
import com.adnan.hotelreservationsystem.Model.User;
import com.adnan.hotelreservationsystem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<DtoUser> getAllUsers(){
        List<User> users = userRepo.findAll();
        List<DtoUser> dtoUsers = new ArrayList<>();
        for (User user : users) {
            dtoUsers.add(DtoUserMapper.map(user));
        }
        return dtoUsers;
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }

    public String loginUser(DtoUser dtoUser) {
        String s = "User Not Found.";
        for (DtoUser dto : getAllUsers()) {
            if (dtoUser.equals(dto)){
                s = "Login Successful!";
                break;
            }
        }
        return s;
    }
}
