package com.gorbunov.second_cashe.secondEntity;

import jakarta.persistence.QueryHint;
import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface User2Repo extends JpaRepository<User2, Long> {


    @QueryHints(
            {@QueryHint(name = HibernateHints.HINT_CACHEABLE, value = "true"),
                    @QueryHint(name = HibernateHints.HINT_CACHE_REGION, value = "Queries")})
    @Query("SELECT u FROM User2 u")
    List<User2> customFindAll();
}
