package com.gorbunov.second_cashe.firstEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.QueryHint;
import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface User1Repo extends JpaRepository<User1, Long> {

    @QueryHints(
            {@QueryHint(name = HibernateHints.HINT_CACHEABLE, value = "true"),
                    @QueryHint(name = HibernateHints.HINT_CACHE_REGION, value = "Queries")})
    @Query("SELECT u FROM User1 u")
    List<User1> customFindAll();


}
