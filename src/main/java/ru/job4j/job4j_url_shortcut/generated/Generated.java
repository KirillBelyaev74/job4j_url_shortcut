package ru.job4j.job4j_url_shortcut.generated;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Generated {

    public String getLogin() {
        return generated(5);
    }

    public String getPassword() {
        return generated(10);
    }

    public String getCodeForLink() {
        return generated(7);
    }

    private String generated(int length) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i != length; i++) {
            builder.append(letters.charAt(new Random().nextInt(letters.length())));
        }
        return builder.toString();
    }
}
