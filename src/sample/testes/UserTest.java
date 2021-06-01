package sample.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.Database.Discipline;
import sample.Database.User;


public class UserTest {

    /**
     * LOGIN
     */
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

    /**
     * DELETE
     */
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

    /**
     * CREATE
     */
    @Test
    @DisplayName("Valid user create")
    public void validCreate() {
        User user = new User();
        user.setEmail("teste@t.pt");
        user.setName("UserTeste");
        user.setPassword("pw");
        user.setType(2);
        boolean created = user.create();
        Assertions.assertTrue(created);
    }

    @Test
    @DisplayName("Invalid user type - create")
    public void invalidTypeCreate() {
        User user = new User();
        user.setEmail("teste@t.pt");
        user.setName("UserTeste");
        user.setPassword("pw");
        user.setType(200);
        boolean created = user.create();
        Assertions.assertFalse(created);
    }

    @Test
    @DisplayName("Invalid Email - create")
    public void invalidEmailCreate() {
        User user = new User();
        user.setEmail("");
        user.setName("dsadsa");
        user.setPassword("pw");
        user.setType(1);
        boolean created = user.create();
        Assertions.assertFalse(created);
    }

    /**
     * UPDATE
     */

    @Test
    @DisplayName("Update User")
    public void validUpdateUser() {
        User user = new User();
        user.setEmail("banana");
        user.setName("dsadsa");
        user.setPassword("pw");
        user.setType(1);
        user.create();

        user.setName("nome2");
        user.setEmail("email2");
        user.setPassword("pass2");
        user.setType(2);

        boolean updated = user.update(user.getKey());

        boolean didUpate = true;
        if (updated) {
            User updatedUser = new User().searchByKey(user.getKey());
            if (!updatedUser.getName().equals(user.getName())) {
                didUpate = false;
            }
            if (!updatedUser.getEmail().equals(user.getEmail())) {
                didUpate = false;
            }

            if (!updatedUser.getPassword().equals(user.getPassword())) {
                System.out.println(updatedUser.getPassword() + " - " + user.getPassword());
                didUpate = false;
            }
            if (updatedUser.getType() != user.getType()) {
                didUpate = false;
            }
        }
        Assertions.assertTrue(didUpate);
    }


}
