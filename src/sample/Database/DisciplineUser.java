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

        String sqlCommand = "INSERT INTO public.\"DisciplineUser\"(disciplineKey, userKey)VALUES ( ?, ?) RETURNING *;";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            // Verifica se existe o utilizador e disciplina
            User user = new User().searchByKey(this.user);
            Discipline discipline = Discipline.getByKey(this.discipline);

            if (user.name == "" || discipline.name == "") {
                return false;
            }

            st.setInt(1, this.discipline);
            st.setInt(2, this.user);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                this.key = rs.getInt(1);
            }

            return this.key > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
        Connection conn = Util.criarConexao();

        String sqlCommand = "DELETE FROM public.\"DisciplineUser\" WHERE key = ? RETURNING *;";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, key);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                System.out.println("apaga");
                return true;
            }
            System.out.println("fora if");
            return false;
        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
            return false;
        }

    }

    public void setDiscipline(int discipline) {
        this.discipline = discipline;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
