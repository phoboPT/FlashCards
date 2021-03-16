package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Discipline {
    int key;
    String name;
    int courseKey;
    String year;


    public Discipline() {
        this.key = 0;
        this.name = "";
        this.courseKey = 0;
        this.year = "";
    }


    public Discipline(int key, String name, int courseKey, String year) {
        this.key = key;
        this.name = name;
        this.courseKey = courseKey;
        this.year = year;

    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"Post\" (name,courseKey,year)VALUES ( ?,?,?);";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            st.setString(1, this.name);
            st.setInt(2, this.courseKey);
            st.setString(3, this.year);


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
