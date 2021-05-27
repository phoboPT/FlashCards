package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisciplineUser {
    int key;
    int discipline;
    int user;


    public DisciplineUser() {
        this.key = 0;
        this.discipline = 0;
        this.user = 0;
    }


    public DisciplineUser(int key, int discipline, int user) {
        this.key = key;

        this.discipline = discipline;
        this.user = user;

    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"DisciplineUser\"(disciplineKey, userKey)VALUES ( ?, ?);";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            // Verifica se existe o utilizador e disciplina
            User user = new User().searchByKey(this.user);
            Discipline discipline = Discipline.getByKey(this.discipline);
            System.out.println("teste" + discipline.name + user.name);

            if (user.name == "" || discipline.name == "") {
                System.out.println("entra 1");
                return false;
            }

            st.setInt(1, this.discipline);
            st.setInt(2, this.user);
            st.execute();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                System.out.println("entra 2");
                this.key = rs.getInt(1);
            }

            if (this.key > 0) {
                System.out.println("entra 3");
                return true;
            }
            return false;

        } catch (SQLException ex) {
            System.out.println("Error! " + ex.getMessage());
        }
        return false;
    }

    public boolean list() {
        return false;
    }

    public boolean update(int key) {
        return false;
    }


    public boolean delete(int key) {
        return false;
    }

    public boolean getByKey(int key) {
        return false;
    }

    public boolean getByName(String name) {
        return false;
    }


    public void setDiscipline(int discipline) {
        this.discipline = discipline;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
