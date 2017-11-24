package com.example.inventoryfragment;

import com.example.inventoryfragment.db.model.User;
import com.example.inventoryfragment.db.repo.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    ArrayList<User> users;

    @Mock
    UserRepository userRepository;

    @Before
    public void inicializarUsers()
    {
        userRepository = mock(UserRepository.class);

        users = new ArrayList<>();

        addUser(new User(1, "user1", "usuario", "user1", "user1@gmail.com", true, true));
        addUser(new User(2, "user2", "usuario2", "user2", "user2@gmail.com", false, false));
        addUser(new User(2, "user3", "usuario3", "user3", "user3@gmail.com", false, true));
    }

    void addUser(User u)
    {
        users.add(u);
    }



    // 3. username existe en BD (Repository)
    // Comparar dos usuarios existentes
    @Test
    public void user_isCorrect() throws Exception
    {
        // Cuando se llame al método userExists, devuelva un valor predeterminado
        //when(userRepository.userExists(users.get(0))).thenReturn(true);

        assertEquals("usuario", userRepository.getUsers().get(0).getUser());
    }

    @Test
    public void getUsers_isCorrect() throws Exception {
        when (userRepository.getUsers()).thenReturn(users);
        assertEquals(users.get(0), userRepository.getUsers().get(0));
    }

    // 4. Passwd es correcta (Repository)
    @Test
    public void password_isCorrect() throws Exception {
        //when(userRepository.userExists(users.get(0))).thenReturn(true);

        assertEquals("user1", userRepository.getUsers().get(0).getPassw());
    }


    @Test
    public void login_isCorrect() throws Exception {

    }

    // !3. Usuario NO existe en BD (Repository)
    @Test
    public void user_notExists() throws Exception
    {
        // Cuando se llame al método userExists, devuelva un valor predeterminado
        when(userRepository.userExists(users.get(0))).thenReturn(false);

        assertEquals(users.get(0).getUser(), userRepository.getUsers().get(0).getUser());
    }

    // 6. email no existe en BD (Repository)
    @Test
    public void email_notExists() throws Exception
    {
        // Cuando se llame al método userExists, devuelva un valor predeterminado
        //when(userRepository.userExists(users.get(0))).thenReturn(false);

        assertEquals(users.get(0).getEmail(), userRepository.getUsers().get(0).getEmail());
    }


    @Test
    public void register_isCorrect() throws Exception {

    }


    @Test
    public void testAssertions()
    {
        User userComparado = new User(1, "user1", "usuario", "user1", "user1@gmail.com", true, true);
        User userNull = null;
        User user3 = userComparado;

        // Dos objs son iguales
        assertEquals(userComparado, users.get(0));
        // Obj es null
        assertNull(userNull);
        // Obj no es null
        assertNotNull(userComparado);
        // Dos objs apuntan a la misma referencia
        assertSame(userComparado, user3);
    }
}