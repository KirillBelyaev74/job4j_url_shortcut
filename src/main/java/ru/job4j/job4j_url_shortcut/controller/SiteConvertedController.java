package ru.job4j.job4j_url_shortcut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.job4j_url_shortcut.generated.Generated;
import ru.job4j.job4j_url_shortcut.model.SiteGenerate;
import ru.job4j.job4j_url_shortcut.service.SiteGenerateService;
import ru.job4j.job4j_url_shortcut.service.SiteService;

@RestController
@RequestMapping("/converted")
public class SiteConvertedController {

    private final SiteService siteService;
    private final SiteGenerateService siteGenerateService;
    private final Generated generated;

    @Autowired
    public SiteConvertedController(
            SiteService siteService, SiteGenerateService siteGenerateService, Generated generated) {
        this.siteService = siteService;
        this.siteGenerateService = siteGenerateService;
        this.generated = generated;
    }

    @PostMapping("/")
    public ResponseEntity<SiteGenerate> getConverterForLink(@RequestBody SiteGenerate siteGenerate) {
        siteService.findAll().forEach(s -> {
            if (siteGenerate.getUrl().contains(s.getUrl())) {
                siteGenerate.setSite(s);
            }
        });
        if (siteGenerate.getSite() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String code;
        do {
            code = generated.getCodeForLink();
        } while (siteGenerateService.findByCode(code) != null);

        siteGenerate.setCode(code);
        return new ResponseEntity<>(
                siteGenerateService.saveOrUpdate(siteGenerate), HttpStatus.CREATED);
    }
}
