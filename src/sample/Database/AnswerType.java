package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnswerType {
    int key;
    String name;

    public AnswerType() {
        this.key = 0;
        this.name = "";
    }

    public AnswerType(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"Post\" (name)VALUES ( ?);";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            st.setString(1, this.name);


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
