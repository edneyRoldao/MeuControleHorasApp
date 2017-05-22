package com.ednTISolutions.controleHoras.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by edneyroldao on 21/05/17.
 */
@Entity
@Table(name = "TB_TOKEN")
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serial;

    @Column(length = 500)
    private String token;

    public Token() {}

    public Token(String serial, String token) {
        this.serial = serial;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
