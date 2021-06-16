package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Degree {
    int key;
    String name;
    int grade;


    public Degree() {
        this.key = 0;
        this.name = "";
        this.grade = 0;
    }


    public Degree(int key, String name, int grade) {
        this.key = key;
        this.name = name;
        this.grade = grade;
    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"Degree\" (name,grade)VALUES ( ?,?);";

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

    public static List<Degree> list() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT * FROM \"Degree\" ORDER BY key ASC ;";
        List<Degree> data = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Degree degree = new Degree(rs.getInt("key"), rs.getString("name"), rs.getInt("grade"));
                data.add(degree);
            }

        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
        }
        return data;
    }

    public static boolean update(int key, String name, int grade) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "UPDATE public.\"Degree\" SET  name= '" + name + "', " + "grade='" + grade+"' WHERE key=" + key + ";";
        System.out.println(sqlCommand);
        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Error! " + ex.getMessage());
        }
        return false;
    }


    public static boolean delete(int key) {

        Connection conn = Util.criarConexao();

        String sqlCommand = "DELETE FROM public.\"Degree\"  WHERE key=" + key + ";";
        System.out.println(sqlCommand);
        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Error! " + ex.getMessage());
        }
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

    public static Degree getByKey(int key) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT * FROM \"Degree\" WHERE key = ?;";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, key);

            ResultSet rs = st.executeQuery();
            Degree course = new Degree();

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
