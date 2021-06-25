package ru.job4j.job4j_url_shortcut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_url_shortcut.model.SiteGenerate;
import ru.job4j.job4j_url_shortcut.repository.SiteGenerateRepository;

import java.util.List;

@Service
public class SiteGenerateService {

    private final SiteGenerateRepository repository;

    @Autowired
    public SiteGenerateService(SiteGenerateRepository repository) {
        this.repository = repository;
    }

    public SiteGenerate saveOrUpdate(SiteGenerate siteGenerate) {
        return repository.save(siteGenerate);
    }

    public List<SiteGenerate> findAll() {
        return repository.findAll();
    }

    public SiteGenerate findByCode(String code) {
        return repository.findByCode(code);
    }

    public void incrementTotalByCode(String code) {
        repository.updateTotalByCode(code);
    }
}
