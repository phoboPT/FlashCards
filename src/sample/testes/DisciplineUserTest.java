package sample.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.Database.DisciplineUser;

public class DisciplineUserTest {
    @Test
    @DisplayName("Insert Discipline User with invalid User")
    public void wrongUser() {
        DisciplineUser du = new DisciplineUser();
        du.setUser(1111);
        du.setDiscipline(1);
        boolean teste = du.create();

        Assertions.assertFalse(teste);
    }

    @Test
    @DisplayName("Insert DisciplineUser with invalid Discipline")
    public void wrongDiscipline() {
        DisciplineUser du = new DisciplineUser();
        du.setUser(1);
        du.setDiscipline(1111);
        boolean teste = du.create();

        Assertions.assertFalse(teste);
    }

    @Test
    @DisplayName("Insert valid DisciplineUser")
    public void validData() {
        DisciplineUser du = new DisciplineUser();
        du.setUser(1);
        du.setDiscipline(1);
        boolean teste = du.create();

        Assertions.assertTrue(teste);
    }
}
