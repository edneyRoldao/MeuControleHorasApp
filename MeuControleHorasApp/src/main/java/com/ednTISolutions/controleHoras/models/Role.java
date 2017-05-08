package com.ednTISolutions.controleHoras.models;

import com.ednTISolutions.controleHoras.enums.RoleType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by edneyroldao on 28/04/17.
 */
@Entity
@Table(name = "TB_ROLE")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TP_ROLE")
    @Enumerated(EnumType.STRING)
    private RoleType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }
}