package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserClasse {
    int key;
    int classKey;
    int userKey;


    public UserClasse() {
        this.key = 0;

        this.classKey = 0;
        this.userKey = 0;
    }


    public UserClasse(int key, int classKey, int userKey) {
        this.key = key;

        this.classKey = classKey;
        this.userKey = userKey;

    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"Post\" (classKey ,userKey)VALUES (?,?);";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            st.setInt(1, this.classKey);
            st.setInt(2, this.userKey);


            st.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
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
