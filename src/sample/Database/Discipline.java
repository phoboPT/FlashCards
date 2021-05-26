package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Discipline {
    int key;
    String name;
    int courseKey;
    String year;
    String course;

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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return this.course;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseKey() {
        return courseKey;
    }

    public void setCourseKey(int courseKey) {
        this.courseKey = courseKey;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            st.setString(1, this.name);
            st.setInt(2, this.courseKey);
            st.setString(3, this.year);


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

    public static Discipline getByKey(int key) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT * FROM \"Discipline\" WHERE key = ?;";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, key);

            ResultSet rs = st.executeQuery();
            Discipline discipline = new Discipline();
            if (rs.next()) {
                discipline.setKey(key);
                discipline.setName(rs.getString("name"));
                discipline.setCourseKey(rs.getInt("course"));
                discipline.setYear(rs.getString("year"));

                discipline.setCourse(Course.getByKey(discipline.getCourseKey()).getName());
            }

            return discipline;
        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
        }
        return null;

    }

    public boolean getByName(String name) {


        return false;
    }


}
