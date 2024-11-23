package com.bank.banco.virtual.controller;

import com.bank.banco.virtual.model.LoginModel;
import com.bank.banco.virtual.response.AuthResponse;
import com.bank.banco.virtual.service.LoginService;
import com.bank.banco.virtual.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/login/controlador")
public class LoginController extends LoginService {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel) {
        LoginModel userLogin = new LoginModel(loginModel.getUsername(), loginModel.getPassword());
        if (findByLogin(userLogin)) {
            String token = jwtUtil.generateToken(userLogin.getUsername());
            return ResponseEntity.status(HttpStatus.OK).body(token);
//            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Falha ao autenticar usuário");
    }

    @GetMapping("/check/checkusername/{username}")
    public ResponseEntity<Boolean> checkUserName(@PathVariable String username) {
        System.out.println(username);
        if (findByUserName(username)) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
