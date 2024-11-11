package kr.co.rland.rland_boot3_api.auth.controller;

import kr.co.rland.rland_boot3_api.auth.dto.AuthRequestDto;
import kr.co.rland.rland_boot3_api.auth.dto.AuthResponseDto;
import kr.co.rland.rland_boot3_api.auth.entity.RlandUserDetails;
import kr.co.rland.rland_boot3_api.auth.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("signin")
    public ResponseEntity<?> signin(@RequestBody AuthRequestDto requestDto) {

        String username = requestDto.getUsername();
        String password = requestDto.getPassword();

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        try {
            // 인증 수행
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            // UserDetailsService를 통해서 사용자 정보를 받아서 인증을 처리한 후
            // 인증에 성공하게 되면 SecurityContextHolder에 사용자 인증 정보를 담아 놓게 됨.

            // 인증 성공 시 사용자 정보 가져오기
            RlandUserDetails userDetails = (RlandUserDetails) authentication.getPrincipal();

            String token = jwtUtil.generateToken(userDetails); // 여기에 인증 상태

            // JWT 토큰만 반환
            return ResponseEntity.ok(AuthResponseDto
                    .builder()
                    .memberId(userDetails.getId())
                    .token(token) // 여기에 인증 상태 정보를 모두 담아서 전달함
                    .build());

        }
        catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }



    // 자난 시간 수업 내용 400 에러 상태
//    @PostMapping("signin")
//    public ResponseEntity<?> signin(@RequestParam("username") String username,
//                                 @RequestParam("password") String password){
//
//        System.out.println(username);
//
//        return ResponseEntity.ok("Signin successful");
//    }
}

