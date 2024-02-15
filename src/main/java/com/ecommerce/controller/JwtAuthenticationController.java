package com.ecommerce.controller;


import com.ecommerce.dto.*;
import com.ecommerce.exception.UserException;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.security.jwt.JWTGenerator;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authenticate")
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class JwtAuthenticationController {

	private final UserService userService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;

    @Autowired
    public JwtAuthenticationController(UserService userService, UserRepository userRepository, AuthenticationManager authenticationManager, JWTGenerator jwtGenerator) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }


    @PostMapping(value = "/register")
    public ResponseEntity<ResponseDto<String>> register(@RequestBody UserDto userDto) /*throws RoleException*/ {
        if (userRepository.existsByUserName(userDto.getUsername())) {
            return new ResponseEntity<>(new ResponseDto<>("Username is taken!",  false), HttpStatus.OK);
        }

//        userService.saveUser(userDto);
        return new ResponseEntity<>(new ResponseDto<>("Customer registered success!", true), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public BaseResponse<ResponseDto<AuthResponseDto>> login(@RequestBody JwtRequest jwtRequest) {

        ResponseDto<AuthResponseDto> responseDto = new ResponseDto<>();

        try{
            UserDto userDto = userService.findByUsername(jwtRequest.getUsername());
            String fiscalCode = userDto.getFiscalCode();

//            if()
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication.getName(), fiscalCode);
            AuthResponseDto authResponseDto = new AuthResponseDto(token);

            responseDto.setResponse(authResponseDto);
            responseDto.setSuccess(true);
            return new BaseResponse<ResponseDto<AuthResponseDto>>().asSuccess(responseDto);
        } catch (UserException ex){

            return new BaseResponse().asError(ex.getMessage());
        }
    }
}
