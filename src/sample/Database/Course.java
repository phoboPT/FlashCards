package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public static Course getByKey(int key) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT * FROM \"Course\" WHERE key = ?;";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, key);

            ResultSet rs = st.executeQuery();
            Course course = new Course();

            if (rs.next()) {
                course.setKey(key);

                course.setName(rs.getString("name"));
                course.setGrade(rs.getInt("grade"));

            }

            return course;
        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
        }

        return null;
    }

    public boolean getByName(String name) {


        return false;
    }

}
