package ru.job4j.job4j_url_shortcut.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.job4j_url_shortcut.model.SiteLogin;

@Repository
public interface SiteLoginRepository extends CrudRepository<SiteLogin, Integer> {

    SiteLogin findByLogin(String login);
}
