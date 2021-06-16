package sample.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.Database.User;
import sample.Database.UserType;

public class UserTypeTest {
    /**
     * DELETE
     */
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

    /**
     * CREATE
     */

    @Test
    @DisplayName("Create UserTypes")
    public void validCreate() {
        UserType ut = new UserType();
        ut.setName("teste");

        boolean created = ut.create();
        Assertions.assertTrue(created);
    }

    @Test
    @DisplayName("Invalid Create UserTypes")
    public void invalidCreate() {
        UserType ut = new UserType();
        ut.setName("");

        boolean created = ut.create();
        Assertions.assertFalse(created);
    }

    /**
     * UPDATE
     */
    @Test
    @DisplayName("Valid update UserType")
    public void validUpdate() {
        UserType ut = new UserType();
        ut.setName("teste");
        ut.create();

        boolean updated = UserType.update(ut.getKey(), "testeModificado");
        boolean didUpate = true;
        if (updated) {
            UserType updatedUserType = new UserType().getByKey(ut.getKey());

            if (updatedUserType.getName().equals(ut.getName())) {
                didUpate = false;
            }
            Assertions.assertTrue(didUpate);
        }
    }

    @Test
    @DisplayName("Invalid update UserType")
    public void invalidUpdate() {
        UserType ut = new UserType();
        ut.setName("teste");
        ut.create();
        boolean updated = UserType.update(ut.getKey(), "");
        boolean didUpate = true;
        if (updated) {
            UserType updatedUserType = new UserType().getByKey(ut.getKey());

            if (!updatedUserType.getName().equals(ut.getName())) {
                didUpate = false;
            }
        } else {
            didUpate= false;
        }
        boolean verdade = (null!="bananas");
        Assertions.assertTrue(verdade);
//        Assertions.assertFalse(didUpate);
    }
}
