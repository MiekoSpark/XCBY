package com.Mieko.promgrammer.javaBean;

public class User {
    private static String name;
    private String password;
    public User(){}
    public User(String name,String password){
        this.name=name;
        this.password=password;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
