package com.example.inventoryfragment.data.db.repo;

import com.example.inventoryfragment.data.db.model.User;

import java.util.ArrayList;

/**
 * Created by usuario on 8/11/17.
 */

public class UserRepository {

    ArrayList<User> users;
    static UserRepository userRepository;

    static {
        userRepository = new UserRepository();
    }

    void inicializarUsers()
    {
        addUser(new User(1, "Usuario1", "Usuario1", "user1", "user1@gmail.com", true, true));
        addUser(new User(2, "user2", "usuario2", "user2", "user2@gmail.com", false, false));
        addUser(new User(2, "user3", "usuario3", "user3", "user3@gmail.com", false, true));
    }

    private UserRepository()
    {
        this.users = new ArrayList<>();
        inicializarUsers();
    }

    void addUser(User u)
    {
        users.add(u);
    }

    public static UserRepository getInstance()
    {
        return userRepository;
    }

    public ArrayList<User> getUsers()
    {
        return users;
    }

    private boolean existingUser(String user)
    {
        boolean encontrado = false;

        for (User u:
             users) {
            if (u.getUser().equals(user))
                encontrado = true;
        }

        return encontrado;
    }
    
    private boolean existingPassword(String passw)
    {
        boolean encontrado = false;

        for (User u:
                users) {
            if (u.getPassw().equals(passw))
                encontrado = true;
        }

        return encontrado;
    }
    
    // Metodo
    public boolean userExists(String checkingUser, String checkingPassword)
    {
        return existingPassword(checkingPassword) && existingUser(checkingUser);
    }
}
