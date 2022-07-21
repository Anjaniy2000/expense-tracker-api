package com.anjaniy.expensetracker.services;

import com.anjaniy.expensetracker.dto.LoginRequest;
import com.anjaniy.expensetracker.dto.LoginResponse;
import com.anjaniy.expensetracker.dto.RegisterRequest;
import com.anjaniy.expensetracker.exceptions.UserAlreadyPresentException;
import com.anjaniy.expensetracker.models.AppUser;
import com.anjaniy.expensetracker.repositories.AppUserRepository;
import com.anjaniy.expensetracker.security.JwtUtilities;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.Instant;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtilities jwtUtilities;

    public void register(RegisterRequest registerRequest) throws Exception {

        Optional<AppUser> appUserOptional = appUserRepository.findByEmail(registerRequest.getEmail());
        if(appUserOptional.isEmpty()){
            AppUser appUser = new AppUser();
            appUser.setName(registerRequest.getName());
            appUser.setEmail(registerRequest.getEmail());
            appUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            appUserRepository.save(appUser);
        }else{
            throw new UserAlreadyPresentException("User Is Already Present With The Given Email Address:- " + registerRequest.getEmail());
        }

    }

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtUtilities.generateToken(authenticate);
        return LoginResponse.builder()
                .authenticationToken(token)
                .expiresAt(Instant.now().plusMillis(jwtUtilities.getJwtExpirationInMillis()))
                .email(loginRequest.getEmail())
                .build();
    }
}
