package com.zsn.springactiviti.service;

import com.zsn.springactiviti.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService<T extends User>  extends UserDetailsService {


}