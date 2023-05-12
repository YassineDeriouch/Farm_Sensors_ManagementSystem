package uir.ac.projet2.Service;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uir.ac.projet2.Entity.User;
import uir.ac.projet2.Entity.User;
import uir.ac.projet2.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created By Youssef on 11/05/2023
 *
 * @Author : Youssef
 * @Date : 11/05/2023
 * @Project : projet2
 */

@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    @Autowired private ModelMapper modelMapper;

    @Transactional
    public User SaveUser(User user) {
        user.setIdUser(user.getIdUser());
        user.setName(user.getName());
        user.setLogin(user.getLogin());
        user.setPassword(user.getPassword());
        user.setPhone(user.getPhone());
        user.setUserFarms(user.getUserFarms());
        return modelMapper.map(userRepository.save(user),User.class);
    }
    public User getUserByID(int id) throws EntityNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            return modelMapper.map(user, User.class);
        else
            throw new EntityNotFoundException("User id= " + id + "name= " + user.get().getName() + " not found");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, User.class))
                .collect(Collectors.toList());
    }

    public User updateUser(int id, User user) throws EntityNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user1 = modelMapper.map(user, User.class);
            user1.setIdUser(id);
            User updatedUser = userRepository.save(user1);
            return modelMapper.map(updatedUser, User.class);
        } else {
            throw new EntityNotFoundException("User id= " + id + " name= " + user.getName() + "not found");
        }
    }

    @Transactional
    public User deleteUserByID(int id) throws EntityNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return modelMapper.map(user, User.class);
        } else
            throw new EntityNotFoundException("User id= " + id + " not found");
    }

    /**
     * DELETE ALL FARMS
     *
     * @return
     * @throws EntityNotFoundException
     */
    @Transactional
    public List<User> deleteAllUsers() throws EntityNotFoundException {
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()) {
            userRepository.deleteAll();
            return users.stream().map(element -> modelMapper.map(element, User.class))
                    .collect(Collectors.toList());
        } else {
            throw new EntityNotFoundException("NO user has been found !");
        }
    }

}
