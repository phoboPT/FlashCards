package sample.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.Database.User;
import sample.Database.UserType;

public class UserTypeTest {
    @Test
    @DisplayName("Delete UserType - Wrong Data")
    public void cantDeleteUserType() {
        UserType userType = new UserType();
        boolean deleted = userType.delete(1);
        Assertions.assertFalse(deleted);
    }

    @Test
    @DisplayName("Delete UserType")
    public void validDeleteUserType() {
        UserType userType = new UserType();
        userType.setName("teste");
        userType.create();
        boolean deleted = userType.delete(userType.getKey());
        Assertions.assertTrue(deleted);
    }
}
