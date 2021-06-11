package ru.job4j.job4j_url_shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4j.job4j_url_shortcut.model.SiteLogin;
import ru.job4j.job4j_url_shortcut.repository.SiteLoginRepository;

@Service
public class SiteLoginService {

    private final SiteLoginRepository repository;

    public SiteLoginService(SiteLoginRepository repository) {
        this.repository = repository;
    }

    public SiteLogin saveOrUpdate(SiteLogin siteLogin) {
        return repository.save(siteLogin);
    }

    public SiteLogin findByLogin(String login) {
        return repository.findByLogin(login);
    }
}
