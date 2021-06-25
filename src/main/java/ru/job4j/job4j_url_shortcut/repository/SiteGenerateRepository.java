package ru.job4j.job4j_url_shortcut.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.job4j_url_shortcut.model.SiteGenerate;

import javax.transaction.Transactional;
import java.util.List;

public interface SiteGenerateRepository extends CrudRepository<SiteGenerate, Integer> {

    @Override
    List<SiteGenerate> findAll();

    SiteGenerate findByCode(String code);

    @Transactional
    @Modifying
    @Query("update SiteGenerate set total = total + 1 where code = ?1")
    void updateTotalByCode(String code);
}
