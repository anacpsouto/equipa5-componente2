package com.upt.lp.rest_api5.controller;
 
import com.upt.lp.rest_api5.model.UserType;
import com.upt.lp.rest_api5.service.UserTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 
@RestController
@RequestMapping("/api/user-types")
public class UserTypeController {

    private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping
    public List<UserType> getAllUserTypes() {
        return userTypeService.getAllUserTypes();
    }

    @PostMapping
    public UserType createUserType(@RequestBody UserType userType) {
        return userTypeService.createUserType(userType);
    }
}
