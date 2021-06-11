package ru.job4j.job4j_url_shortcut.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.job4j_url_shortcut.model.SiteGenerate;

import java.util.List;

public interface SiteGenerateRepository extends CrudRepository<SiteGenerate, Integer> {

    @Override
    List<SiteGenerate> findAll();

    SiteGenerate findByCode(String code);
}
