package sample.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.Database.Discipline;
import sample.Database.User;


public class UserTest {
    @Test
    @DisplayName("Login with valid credentials")
    public void validLogin() {
        boolean user = User.login("admin", "admin");
        Assertions.assertTrue(user);
    }

    @Test
    @DisplayName("Login with invalid credentials")
    public void wrongLogin() {
        boolean user = User.login("", "");
        Assertions.assertFalse(user);
    }

    @Test
    @DisplayName("Delete user account")
    public void deleteAccount() {
        boolean user = User.delete(4);
        Assertions.assertTrue(user);
    }

    @Test
    @DisplayName("Test decks")
    public void testDecks() {
        Discipline discipline = Discipline.getByKey(5);
        Assertions.assertEquals("M", discipline.getCourse());
    }


    @Test
    @DisplayName("Test decks")
    public void testUser() {
        User user = new User();
        boolean deleted = user.delete(10);
        System.out.println(user);
        Assertions.assertTrue(deleted);
    }
}
