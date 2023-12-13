package com.spring.selfstudy.service;


import com.spring.selfstudy.mapper.UserMapper;
import com.spring.selfstudy.web.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    private final UserMapper userMapper;

    @Transactional
    public void joinUser(UserVo userVo){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVo.setUserPw(passwordEncoder.encode(userVo.getUserPw()));
        userVo.setUserAuth("USER");
        userVo.setCreatedAt(localTime);
        userVo.setUpdatedAt(localTime);
        userMapper.saveUser(userVo);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserVo userVo = userMapper.getUserAccount(userId);
        if(userVo == null){
            throw new UsernameNotFoundException("User not authorized");
        }
        return userVo;
    }
}
