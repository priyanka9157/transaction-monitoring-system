package com.project.transaction_service.controller;

import com.project.transaction_service.model.User;
import com.project.transaction_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User loginRequest) {

        Map<String, Object> response = new HashMap<>();

        try {

            if (loginRequest.getUsername().equals(null) || loginRequest.getPassword().equals(null)) {

                response.put("status", 400);
                response.put("error", "Username and Password required");

                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            User user = userRepository.findById(loginRequest.getId())
                    .orElse(null);

            if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {

                response.put("status", 401);
                response.put("error", "Invalid credentials");

                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            }

            response.put("status", 200);
            response.put("message", "Login successful");
            response.put("userId", user.getId());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            response.put("status", 500);
            response.put("error", "Internal server error");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
