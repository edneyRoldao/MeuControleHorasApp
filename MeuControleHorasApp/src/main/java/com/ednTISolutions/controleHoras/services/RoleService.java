package com.ednTISolutions.controleHoras.services;

import com.ednTISolutions.controleHoras.enums.RoleType;
import com.ednTISolutions.controleHoras.models.Role;
import com.ednTISolutions.controleHoras.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edneyroldao on 07/06/17.
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    public Role findByRoleName(String roleName) {
        return repository.findByName(roleName);
    }

    public List<Role> addRolesByRoleType(RoleType type) {
        List<Role> roles = new ArrayList<>();
        roles.add(findByRoleName(type.name()));

        return roles;
    }

    public List<Role> addAllRoles() {
        return getAllRoles();
    }

}
