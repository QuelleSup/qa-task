package com.task.selenium.utils;

import com.task.selenium.pageobjects.SignUpPage;

import java.util.logging.Logger;

public class EmailUtil {

    private static final Logger LOG = Logger.getLogger(SignUpPage.class.getName());

    public static String prepareEmailAndLog(String emailFormat) {
        final String email = String.format(emailFormat, System.currentTimeMillis());
        LOG.info("Generated email:" + email);
        return email;
    }
}
