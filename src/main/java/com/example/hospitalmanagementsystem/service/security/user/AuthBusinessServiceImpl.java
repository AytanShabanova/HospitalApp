package com.example.hospitalmanagementsystem.service.security.user;//package com.example.securitylesson.service.security;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import static com.example.springsecurity.models.enums.response.ErrorResponseMessages.EMAIL_ALREADY_REGISTERED;
//import static com.example.springsecurity.models.enums.response.ErrorResponseMessages.PASSWORD_INCORRECT;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class AuthBusinessServiceImpl implements AuthBusinessService {
//
//    private final AuthenticationManager authenticationManager;
//    private final AccessTokenManager accessTokenManager;
//    private final RefreshTokenManager refreshTokenManager;
//    private final UserService userService;
//    private final UserDetailsService userDetailsService;
//    private final ObjectMapper objectMapper;
//    private final TokenService tokenService;
//
//    @Override
//    public LoginResponse login(LoginPayload payload) {
//        LoginResponse loginResponse = prepareLoginResponse(payload.getEmail(), payload.isRememberMe());
//        authenticate(payload);
//
//        return loginResponse;
//    }
//
//    @Override
//    public LoginResponse refresh(RefreshTokenPayload payload) {
//        return prepareLoginResponse(
//                refreshTokenManager.getEmail(payload.getRefreshToken()),
//                payload.isRememberMe()
//        );
//    }
//
//    @Override
//    public void logout(HttpServletRequest httpServletRequest) {
//        tokenService.deleteToken(httpServletRequest);
//
//    }
//
//    @Override
//    public void setAuthentication(String email) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//
//        SecurityContextHolder.getContext().setAuthentication(
//                new UsernamePasswordAuthenticationToken(userDetails, userDetails.getAuthorities(), userDetails.getAuthorities())
//        );
//    }
//
//    @Override
//    public RegisterResponse register(RegisterPayload registerPayload) {
//
//        return convertRegisterResponse(registerPayload);
//    }
//
//    // private util methods
//
//    private void authenticate(LoginPayload request) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//            );
//
//        } catch (AuthenticationException e) {
//            throw BaseException.of(PASSWORD_INCORRECT);
//        }
//    }
//
//    private LoginResponse prepareLoginResponse(String email, boolean rememberMe) {
//        UserEntity user = userService.getByEmail(email);
//        LoginResponse response=LoginResponse.builder()
//                .accessToken(accessTokenManager.generate(user))
//                .refreshToken(refreshTokenManager.generate(
//                        RefreshTokenDto.builder()
//                                .user(user)
//                                .rememberMe(rememberMe)
//                                .build()
//                ))
//                .userInfo(LoginResponse.UserInfo.builder().id(user.getId()).email(user.getEmail()).build())
//                .build();
//       tokenService.saveToken(response);
//        return response;
//    }
//
//    private RegisterResponse convertRegisterResponse(RegisterPayload registerPayload) {
//        if (userService.checkEmail(registerPayload.getEmail())) {
//            throw BaseException.of(EMAIL_ALREADY_REGISTERED);
//        }
//        UserEntity user = objectMapper.convertValue(registerPayload, UserEntity.class);
//        UserEntity userEntity = userService.save(user);
//        RegisterResponse registerResponse = objectMapper.convertValue(userEntity, RegisterResponse.class);
//        return registerResponse;
//    }
//}
