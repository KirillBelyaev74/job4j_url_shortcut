package ru.job4j.job4j_url_shortcut.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "site_login")
public class SiteLogin {

    @Id
    @Column(name = "id_site")
    @JsonIgnore
    private int id;

    @Transient
    private boolean registration;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    public SiteLogin() {
    }

    public SiteLogin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SiteLogin that = (SiteLogin) o;
        return registration == that.registration
                && Objects.equals(login, that.login)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registration, login, password);
    }

    @Override
    public String toString() {
        return "SiteLogin { "
                + "id = " + id
                + ", registration = " + registration
                + ", login = '" + login + '\''
                + ", password = '" + password + '\''
                + '}';
    }
}
