package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;


    public UserDTO findById(Long id){
        User entity = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        return new UserDTO(entity);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("Email not found");
                });
    }

//    public User loadUserByUsername(String username) throws UsernameNotFoundException {
//        return this.userRepository.findByUsername(username)
//                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
//    }
}
