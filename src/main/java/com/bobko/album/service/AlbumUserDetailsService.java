package com.bobko.album.service;

/**
 * Service that provide user exists by username using almost at registration or authorization
 * 
 * @author oleksii bobko
 * @data 12.08.2013
 * @see UserDetailsService
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bobko.album.domain.UserEntity;
import com.bobko.album.service.interfaces.IUserService;

@Service("albumUserDetailsService")
public class AlbumUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;
    
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userStr)
            throws UsernameNotFoundException, DataAccessException {

        UserEntity userEntity = userService.getUserByName(userStr);
        if (userEntity == null) {
            throw new UsernameNotFoundException("user not found");
        }
        
        User user = new User(userEntity.getLogin(), userEntity.getPw(),
                userEntity.isActive(), true, true, true,
                userEntity.getAuthorities());
        
        return user;
    }

}