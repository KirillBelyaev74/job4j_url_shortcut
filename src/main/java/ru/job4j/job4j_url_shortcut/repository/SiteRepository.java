package ru.job4j.job4j_url_shortcut.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.job4j_url_shortcut.model.Site;

import java.util.List;

@Repository
public interface SiteRepository extends CrudRepository<Site, Integer> {

    @Override
    List<Site> findAll();

    Site findByUrlLike(String url);
}
