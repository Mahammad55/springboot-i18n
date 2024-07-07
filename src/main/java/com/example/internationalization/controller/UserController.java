package com.example.internationalization.controller;

import com.example.internationalization.dto.request.UserRequest;
import com.example.internationalization.dto.response.UserResponse;
import com.example.internationalization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.internationalization.util.LocalizationUtil.getLocalizedMessageByKey;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserRequest userRequest) {
        userService.saveUser(userRequest);
        var message = getLocalizedMessageByKey("i18n/success", "user.save.success");
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserRequest userRequest, @PathVariable Long id) {
        userService.updateUser(id, userRequest);
        var message = getLocalizedMessageByKey("i18n/success", "user.update.success");
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        var message = getLocalizedMessageByKey("i18n/success", "user.delete.success");
        return ResponseEntity.ok(message);
    }
}
