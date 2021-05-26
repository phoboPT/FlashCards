package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DisciplineUser {
    int key;
    int disciplineKey;
    int userKey;


    public DisciplineUser() {
        this.key = 0;
        this.disciplineKey = 0;
        this.userKey = 0;
    }


    public DisciplineUser(int key, int disciplineKey, int userKey) {
        this.key = key;

        this.disciplineKey = disciplineKey;
        this.userKey = userKey;

    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"Post\" (disciplineKey ,userKey)VALUES (?,?);";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            st.setInt(1, this.disciplineKey);
            st.setInt(2, this.userKey);


            st.execute();
            return true;

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
}
