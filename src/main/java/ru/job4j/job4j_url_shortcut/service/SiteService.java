package ru.job4j.job4j_url_shortcut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_url_shortcut.model.Site;
import ru.job4j.job4j_url_shortcut.repository.SiteRepository;

import java.util.List;

@Service
public class SiteService {

    private final SiteRepository repository;

    @Autowired
    public SiteService(SiteRepository repository) {
        this.repository = repository;
    }

    public Site saveOrUpdate(Site site) {
        return repository.save(site);
    }

    public List<Site> findAll() {
        return repository.findAll();
    }

    public Site findByUrlLike(String url) {
        return repository.findByUrlLike(url);
    }
}
