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
    @DisplayName("Delete User - Wrong Data")
    public void wrongDelete() {
        User user = new User();
        boolean deleted = user.delete(999);
        Assertions.assertFalse(deleted);
    }

    @Test
    @DisplayName("Delete User")
    public void validDelete() {
        User user = new User();
        user.setEmail("testUser");
        user.setName("testUser");
        user.setPassword("testUser");
        user.setType(1);
        user.create();

        boolean deleted = user.delete(user.getKey());
        Assertions.assertTrue(deleted);
    }

//    @Test
//    @DisplayName("Test decks")
//    public void testDecks() {
//        Discipline discipline = Discipline.getByKey(5);
//        Assertions.assertEquals("M", discipline.getCourse());
//    }


}
