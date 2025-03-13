package com.automation.utils;

import com.automation.core.utils.PasswordManager;
import com.automation.core.utils.PasswordManagerUtil;

public class ProjectUtils {
    static PasswordManager passwordManager = new PasswordManagerUtil();
    static String password = "MyPassword";

    public static void main(String[] args) throws Exception {
        System.out.println(passwordManager.encrypt(password));
    }
}
