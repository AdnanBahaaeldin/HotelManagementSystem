package com.adnan.hotelreservationsystem.Controller;
import com.adnan.hotelreservationsystem.Dto.DtoUser;
import com.adnan.hotelreservationsystem.Model.User;
import com.adnan.hotelreservationsystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotel/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String loginUser(@RequestBody DtoUser dtoUser) {
        return userService.loginUser(dtoUser);
    }

    @GetMapping("/getAll")
    public List<DtoUser> getUsers() {
       return userService.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity<User[]> addUser(@RequestBody User[] user) {
        for (User user1 : user) {
            userService.addUser(user1);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }


}
