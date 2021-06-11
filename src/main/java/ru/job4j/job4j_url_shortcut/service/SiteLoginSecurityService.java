package ru.job4j.job4j_url_shortcut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_url_shortcut.model.SiteLogin;

import java.util.Collections;

@Service
public class SiteLoginSecurityService implements UserDetailsService {

    private final SiteLoginService siteLoginService;

    @Autowired
    public SiteLoginSecurityService(SiteLoginService siteLoginService) {
        this.siteLoginService = siteLoginService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        SiteLogin siteLogin = siteLoginService.findByLogin(login);
        if (siteLogin == null) {
            throw new UsernameNotFoundException(login);
        }
        return new User(siteLogin.getLogin(), siteLogin.getPassword(), Collections.emptyList());
    }
}
