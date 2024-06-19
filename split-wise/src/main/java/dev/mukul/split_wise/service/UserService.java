package dev.mukul.split_wise.service;

import dev.mukul.split_wise.models.User;
import dev.mukul.split_wise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User register(String name, String phone, String password){

        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setHashedPassword(password);
        return this.userRepository.save(user);

    }

    public User updateProfile(Long userId, String password) {
        //find user by id
        Optional<User> existingUser = this.userRepository.findById(userId);
        if(existingUser.isEmpty()){
            return null;
        }
        existingUser.get().setHashedPassword(password);

        return this.userRepository.save(existingUser.get());
        // if not exist then

        //update the user
//        return the user;
    }
}
