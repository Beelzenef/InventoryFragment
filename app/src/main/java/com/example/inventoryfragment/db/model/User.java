package com.example.inventoryfragment.db.model;

import java.security.Permission;
import java.util.ArrayList;

/**
 * Created by usuario on 8/11/17.
 */

public class User {

    private int ID;
    private String user;
    private String passw;
    private String username;
    private String email;
    private boolean isRoot;
    private boolean isManager;

    ArrayList<Permission> permissions;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public User(int ID, String user, String passw, String username, String email, boolean isRoot, boolean isManager) {
        this.ID = ID;
        this.user = user;
        this.passw = passw;
        this.username = username;
        this.email = email;
        this.isRoot = isRoot;
        this.isManager = isManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user1 = (User) o;

        if (user != null ? !user.equals(user1.user) : user1.user != null) return false;
        return username != null ? username.equals(user1.username) : user1.username == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
