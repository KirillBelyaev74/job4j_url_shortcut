package ru.job4j.job4j_url_shortcut.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "site_generate")
public class SiteGenerate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private int id;

    @Column(name = "url", unique = true, nullable = false)
    private String url;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "total")
    private int total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_site")
    @JsonIgnore
    private Site site;

    public SiteGenerate() {
    }

    public SiteGenerate(String url, String code) {
        this.url = url;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteGenerate that = (SiteGenerate) o;
        return id == that.id
                && Objects.equals(url, that.url)
                && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, code);
    }

    @Override
    public String toString() {
        return "SiteGenerate { "
                + "id = " + id
                + ", url = '" + url + '\''
                + ", code = '" + code + '\''
                + '}';
    }
}
