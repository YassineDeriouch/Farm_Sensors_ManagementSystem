package uir.ac.projet2.Controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uir.ac.projet2.Entity.User;
import uir.ac.projet2.Entity.User;
import uir.ac.projet2.Service.UserService;

import java.util.List;

/**
 * Created By Youssef on 11/05/2023
 *
 * @Author : Youssef
 * @Date : 11/05/2023
 * @Project : projet2
 */

@RestController
@RequestMapping("Users")
public class UserController {

    @Autowired private UserService userService;
    
    @PostMapping("/save")
    public ResponseEntity<User> SaveUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.SaveUser(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get/id")
    public ResponseEntity<User> getUserById(@RequestParam int idUser) {
        try {
            return new ResponseEntity<>(userService.getUserByID(idUser), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/get/all")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/id")
    public ResponseEntity<User> updateUser(@RequestParam int idUser, @RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(idUser, user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/id")
    public ResponseEntity<User> deleteUser(@RequestParam int idUser) {
        try {
            return new ResponseEntity<>(userService.deleteUserByID(idUser), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<List<User>> deleteAllUsers() {
        try {
            List<User> user = userService.deleteAllUsers();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
