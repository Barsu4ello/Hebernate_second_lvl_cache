package com.gorbunov.second_cashe.secondEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.Cache;
import org.hibernate.SessionFactory;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.QueryStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user2")
@RequiredArgsConstructor
public class ControllerUser2 {

    private final User2Repo user2Repo;

//    @PersistenceContext
//    private EntityManager entityManager;

    @GetMapping("/{id}")
    public User2 getById(@PathVariable Long id) {
        return user2Repo.findById(id).orElse(null);
    }

    @GetMapping
    public List<User2> getById() {
//        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
//        Cache cache = sessionFactory.getCache();
//        Statistics stat = sessionFactory.getStatistics();;
//        QueryStatistics queryStatistics = stat.getQueryStatistics("SELECT u FROM User2 u");
//
//        EntityStatistics user2 = stat.getEntityStatistics(User2.class.getName());
//        return user2Repo.findAll();
        return user2Repo.customFindAll();
    }
}
