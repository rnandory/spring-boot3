package kr.co.rland.rland_boot3_api.auth.controller;

import kr.co.rland.rland_boot3_api.auth.dto.SigninDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @PostMapping("signin")
    public ResponseEntity<String> signin(@RequestBody SigninDto signinDto) {
        return ResponseEntity.ok("123123");
    }
}
