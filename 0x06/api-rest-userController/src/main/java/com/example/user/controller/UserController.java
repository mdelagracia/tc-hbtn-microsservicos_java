package com.example.user.controller;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api-user/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable("id") int id) {
        if(isId(id)){
            return "You have entered valid ID";
        }else{
            throw new UserIdException();
            //return "You have entered invalid ID";
        }
    }

    public boolean isId(int id) {
        if(id > 0 && id < 100){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable("userName") String userName) {
        if(isName(userName)){
            return "You have entered valid USERNAME";
        }else{
            throw new UserNameException();
            //return "You have entered invalid USERNAME";
        }
    }

    public boolean isName(String userName) {
        if(userName.length() > 3 && userName.length() < 15){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable("cpf") String cpf) {
        if(isCPF(cpf)){
            return "You have entered valid CPF";
        }else{
            throw new CPFException();
           // return "You have entered invalid CPF";
        }
    }

    public boolean isCPF(String CPF) {
        if(CPF.length() > 3 && CPF.length() < 15) {
            return true;
        }else{
            return false;
        }
    }
}
