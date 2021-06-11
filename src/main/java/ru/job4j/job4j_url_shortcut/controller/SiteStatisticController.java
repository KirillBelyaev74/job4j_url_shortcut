package ru.job4j.job4j_url_shortcut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.job4j_url_shortcut.model.SiteGenerate;
import ru.job4j.job4j_url_shortcut.service.SiteGenerateService;

import java.util.List;

@RestController
@RequestMapping("/statistic")
public class SiteStatisticController {

    private final SiteGenerateService siteGenerateService;

    @Autowired
    public SiteStatisticController(SiteGenerateService siteGenerateService) {
        this.siteGenerateService = siteGenerateService;
    }

    @GetMapping("/")
    public List<SiteGenerate> getAllSiteGenerate() {
        return siteGenerateService.findAll();
    }
}
