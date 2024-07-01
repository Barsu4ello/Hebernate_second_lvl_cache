package com.gorbunov.second_cashe.firstEntity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

@Entity
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Users") //Users это алиас из конфига
@NaturalIdCache(region = "naturalId")
public class User1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String email;
    private String name;
}
