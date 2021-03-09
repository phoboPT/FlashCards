package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Course {
    int key;
    String name;
    int grade;


    public Course() {
        this.key = 0;
        this.name = "";
        this.grade = 0;
    }


    public Course(int key, String name, int grade) {
        this.key = key;
        this.name = name;
        this.grade = grade;
    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"Post\" (name,grade)VALUES ( ?,?);";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            st.setString(1, this.name);
            st.setInt(2, this.grade);


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
