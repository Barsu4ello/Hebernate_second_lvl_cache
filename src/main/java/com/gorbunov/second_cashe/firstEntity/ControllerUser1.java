package com.gorbunov.second_cashe.firstEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user1")
@RequiredArgsConstructor
public class ControllerUser1 {

    private final User1Repo user1Repo;
    private final User1Repo2 user1Repo2;

    @GetMapping("/{id}")
    public User1 getById(@PathVariable Long id) {
        return user1Repo.findById(id).orElse(null);
    }

    @GetMapping
    public List<User1> getById() {
//        return user1Repo.findAll();
        return user1Repo.customFindAll();
    }

    @GetMapping("/natural/{email}")
    public User1 getByNaturalId(@PathVariable String email) {
        return user1Repo2.findByNaturalId(email);
    }

}
