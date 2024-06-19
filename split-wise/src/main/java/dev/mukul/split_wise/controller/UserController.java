package dev.mukul.split_wise.controller;

import dev.mukul.split_wise.dto.*;
import dev.mukul.split_wise.models.User;
import dev.mukul.split_wise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public ResponseDTO<RegisterUserResponseDTO> register(RegisterUserDTO body){
        User responseUser = this.userService.register(body.getName(), body.getPhone(), body.getPassword());

        ResponseDTO<RegisterUserResponseDTO> responseDTO = new ResponseDTO<RegisterUserResponseDTO>();
        if(responseUser == null){
            responseDTO.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setData(null);
            return responseDTO;
        }
        RegisterUserResponseDTO registerUserResponseDTO = new RegisterUserResponseDTO();
        registerUserResponseDTO.setUserId(responseUser.getId());

        responseDTO.setData(registerUserResponseDTO);
        responseDTO.setCode(HttpStatus.OK);

        return responseDTO;
    }

    public ResponseDTO<UpdateProfileResponseDto> updateProfile(UpdateProfileRequestDto body){
        User updatedUser = this.userService.updateProfile(body.getUserId(), body.getPassword());
        ResponseDTO<UpdateProfileResponseDto> responseDTO =  new ResponseDTO<UpdateProfileResponseDto>();
        responseDTO.setCode(HttpStatus.OK);
        if(updatedUser == null){
            responseDTO.setCode(HttpStatus.NOT_FOUND);
        }
        return responseDTO;
    }
}
