package sample.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.Database.Discipline;
import sample.Database.User;


public class Teste {
    @Test
    @DisplayName("Login with valid credentials")
    public void testLogin() {
        boolean user = User.login("admin", "admin");
        Assertions.assertTrue(user);


    }

    @Test
    @DisplayName("Login with invalid credentials")
    public void testLoginFalse() {
        boolean user = User.login("admindsfsdf", "admindsds");
        Assertions.assertFalse(user);
    }

    @Test
    @DisplayName("Test decks")
    public void testDecks() {
        Discipline discipline = Discipline.getByKey(5);
        Assertions.assertEquals("M", discipline.getCourse());
    }
}
