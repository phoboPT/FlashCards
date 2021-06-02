package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserType {
    int key;
    String name;

    public UserType() {
        this.key = 0;
        this.name = "";
    }

    public UserType(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"UserType\" (name)VALUES ( ?) RETURNING *;";

        if (this.name=="") {
            return false;
        }

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, this.name);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                this.key = rs.getInt(1);
                return true;
            }

            return true;

        } catch (SQLException ex) {
            System.out.println("Error! " + ex.getMessage());
        }
        return false;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<UserType> list() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT * FROM \"UserType\" ORDER BY key ASC ;";
        List<UserType> data = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UserType userType = new UserType(rs.getInt("key"), rs.getString("name"));
                data.add(userType);
            }

        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
        }
        return data;
    }


    public static boolean update(int key, String name) {
        if (name=="") {
            System.out.println("vazio");
            return false;
        }
        Connection conn = Util.criarConexao();

        String sqlCommand = "UPDATE public.\"UserType\" SET  name= '" + name + "' WHERE key=" + key + ";";
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

        //VER OS UTILIZADORES que tem user type
        String sqlCommand2 = "SELECT COUNT(key) contador FROM public.\"User\" WHERE type=" + key + " ;";

        String sqlCommand = "DELETE FROM public.\"UserType\"  WHERE key=" + key + ";";
        System.out.println(sqlCommand);
        try {
            PreparedStatement ps = conn.prepareStatement(sqlCommand2);
            ResultSet rs = ps.executeQuery();

            rs.next();

            //teste ao contador
            if (rs.getInt("contador") > 0) {
                return false;
            }

            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Error! " + ex.getMessage());
        }
        return false;
    }

    public UserType getByKey(int key) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT * FROM \"UserType\" WHERE key = ?;";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, key);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                this.key = rs.getInt("key");
                this.name = rs.getString("name");
            }

            return this;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return key + " - " + name;
    }
}
