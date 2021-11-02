//package com.epam.newsPortal.service.impl;
//
//
//import com.epam.newsPortal.service.SecurityService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SecurityServiceImpl implements SecurityService {
//
//    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
//
//    @Autowired
//    private AuthenticationProvider authenticationProvider;
//
//    @Autowired
//    private UserDetailsService userDetailService;
//
//    @Override
//    public String findLoggedInUsername() {
//        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
//        if (userDetails instanceof UserDetails) {
//            return ((UserDetails) userDetails).getUsername();
//        }
//        return null;
//    }
//
//    @Override
//    public void autoLogin(String name, String password) {
//        UserDetails userDetails = userDetailService.loadUserByUsername(name);
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//        authenticationProvider.authenticate(authenticationToken);
//
//        if (authenticationToken.isAuthenticated()) {
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            logger.debug(String.format("Succesfully %s auto logged in", name));
//        }
//    }
//}
