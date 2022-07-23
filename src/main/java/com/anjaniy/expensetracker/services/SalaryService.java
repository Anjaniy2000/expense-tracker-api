package com.anjaniy.expensetracker.services;

import com.anjaniy.expensetracker.models.AppUser;
import com.anjaniy.expensetracker.repositories.AppUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;


    public void update(int salary) {
        AppUser appUser = modelMapper.map(appUserService.getCurrentUser(), AppUser.class);
        appUser.setSalary(salary);
        appUserRepository.save(appUser);
    }
}
