package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        String sqlCommand = "INSERT INTO public.\"AnswerType\" (name)VALUES ( ?);";

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

    public void setName(String name) {
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public static List<AnswerType> list() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT * FROM \"AnswerType\";";
        List<AnswerType> data = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AnswerType answer = new AnswerType(rs.getInt("key"), rs.getString("name"));

                data.add(answer);
            }


        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
        }


        return data;


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
