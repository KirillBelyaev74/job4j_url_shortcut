package ru.job4j.job4j_url_shortcut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.job4j_url_shortcut.model.SiteGenerate;
import ru.job4j.job4j_url_shortcut.service.SiteGenerateService;

@RestController
@RequestMapping("/redirect")
public class SiteRedirectController {

    private final SiteGenerateService siteGenerateService;

    @Autowired
    public SiteRedirectController(SiteGenerateService siteGenerateService) {
        this.siteGenerateService = siteGenerateService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> redirectByCode(@PathVariable String code) {
        SiteGenerate result = siteGenerateService.findByCode(code);
        result.setTotal(result.getTotal() + 1);
        siteGenerateService.saveOrUpdate(result);
        return result != null
                ? new ResponseEntity<>(result.getUrl(), HttpStatus.resolve(302))
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
