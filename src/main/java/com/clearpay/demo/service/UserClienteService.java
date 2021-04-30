package com.clearpay.demo.service;

import com.clearpay.demo.service.interfaces.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserClienteService implements User {

    @Override
    public List getAll() {
        return null;
    }
}
