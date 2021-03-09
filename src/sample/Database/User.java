package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    int key;
    String name;
    String email;
    String password;
    int type;


    public User() {
        this.key = 0;
        this.name = "";
        this.email = "";
        this.password = "";
        this.type = 0;

    }


    public User(String name, String email, String password, int type) {
        this.key = 0;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;

    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"User\"(name, email, password, type)VALUES ( ?, ?, ?, ?);";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, this.name);
            st.setString(2, this.email);
            st.setString(3, this.password);
            st.setInt(4, this.type);
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
