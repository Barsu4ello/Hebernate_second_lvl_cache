package com.gorbunov.second_cashe.firstEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Session;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public class User1Repo2 {

    @PersistenceContext
    EntityManager entityManager;

    public User1 findByNaturalId(String email){
        Session session = entityManager.unwrap(Session.class);
        User1 user = session.byNaturalId(User1.class)
                .using("email", email)
                .load();

        return user;
    }
}
