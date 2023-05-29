package com.ensa.demo.auth;

import com.ensa.demo.model.User;
import com.ensa.demo.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService ;
    private final PasswordEncoder passwordEncoder ;
    private final AuthenticationManager authenticationManager ;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build() ;
        userRepository.save(user) ;
         String token = jwtService.generateToken(user) ;
        return AuthenticationResponse
                .builder()
                .token(token)
                .build() ;
    }

    public AuthenticationResponse authentication(AuthenticationResquest request) {
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail() , request.getPassword())) ;
           var user = userRepository.findByEmail(request.getEmail()) ;
           if(user.isEmpty()) throw new UsernameNotFoundException("User not found") ;
           String token = jwtService.generateToken(user.get()) ;
           return AuthenticationResponse.builder()
                   .token(token)
                   .build() ;
    }
}
