package ru.job4j.job4j_url_shortcut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.job4j_url_shortcut.generated.Generated;
import ru.job4j.job4j_url_shortcut.model.Site;
import ru.job4j.job4j_url_shortcut.model.SiteLogin;
import ru.job4j.job4j_url_shortcut.service.SiteLoginService;
import ru.job4j.job4j_url_shortcut.service.SiteService;

@RestController
@RequestMapping("/registration")
public class SiteRegistrationController {

    private final SiteService siteService;
    private final SiteLoginService siteLoginService;
    private final Generated generated;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public SiteRegistrationController(
            SiteService siteService, SiteLoginService siteLoginService,
            BCryptPasswordEncoder encoder, Generated generated) {
        this.siteService = siteService;
        this.siteLoginService = siteLoginService;
        this.encoder = encoder;
        this.generated = generated;
    }

    @PostMapping("/")
    public ResponseEntity<SiteLogin> registrationSite(@RequestBody Site site) {
        if (site.getUrl().contains("https://")) {
            site.setUrl(site.getUrl().replace("https://", ""));
        } else if (site.getUrl().contains("http://")) {
            site.setUrl(site.getUrl().replace("http://", ""));
        }
        siteService.saveOrUpdate(site);
        String login;
        String password;
        do {
            login = generated.getLogin();
            password = generated.getPassword();
        } while (siteLoginService.findByLogin(login) != null);
        SiteLogin siteLogin = new SiteLogin(login, encoder.encode(password));
        siteLogin.setId(site.getId());
        siteLoginService.saveOrUpdate(siteLogin);
        siteLogin.setPassword(password);
        if (siteLogin.getId() != 0) {
            siteLogin.setRegistration(true);
        }

        return new ResponseEntity<>(siteLogin, HttpStatus.CREATED);
    }
}
