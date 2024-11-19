package com.upt.lp.rest_api5.service;

import com.upt.lp.rest_api5.model.UserType;
import com.upt.lp.rest_api5.repository.UserTypeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserTypeService {

    private final UserTypeRepository userTypeRepository;

    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public List<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }

    public UserType getUserTypeById(Long id) {
        return userTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserType not found with ID: " + id));
    }

    public UserType createUserType(UserType userType) {
        return userTypeRepository.save(userType);
    }
}
