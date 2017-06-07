package com.ednTISolutions.controleHoras.models;

import com.ednTISolutions.controleHoras.enums.RoleType;

import javax.persistence.*;

@Entity
@Table(name = "TB_ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROLE", length = 50)
    @Enumerated(EnumType.STRING)
    private RoleType name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }

}