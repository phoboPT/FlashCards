package sample.Database;

import sample.Util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


    public User(int key, String name, String email, String password, int type) {
        this.key = key;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;

    }

    public boolean create() {
        if (this.email == "" || this.password == "" || this.name == "") {
            return false;
        }
        Connection conn = Util.criarConexao();
        String sqlCommand = "INSERT INTO public.\"User\"(name, email, password, type)VALUES ( ?, ?, ?, ?)RETURNING *;";

        UserType ut = new UserType().getByKey(this.type);
        if (ut.name.equals("")) {
            return false;
        }
        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, this.name);
            st.setString(2, this.email);
            st.setString(3, this.password);
            st.setInt(4, this.type);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                this.key = rs.getInt(2);
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("Error! " + ex.getMessage());
        }
        return false;
    }

    public static List<User> list() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT * FROM \"User\";";
        List<User> allUsers = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("key"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("type")
                );
                allUsers.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return allUsers;
    }

    public boolean update(int key) {
        Connection conn = Util.criarConexao();
        String sqlCommand = "UPDATE public.\"User\" SET email='" + email + "', name='" + name + "', password='" + password + "', " +
                "type='"+type+"' WHERE key ='"+key+"';";
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


    public boolean delete(int key) {
        Connection conn = Util.criarConexao();
        String sqlCommand = "DELETE FROM \"User\" WHERE key = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, key);
            int resultado = st.executeUpdate();

            //verifica se for eliminado com sucesso
            return resultado == 1;
        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
            return false;
        }
    }

    public User searchByKey(int key) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT * FROM \"User\" WHERE key = ?;";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, key);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                this.key = key;
                this.name = rs.getString("name");
                this.email = rs.getString("email");
                this.type = rs.getInt("type");
                this.password = rs.getString("password");
            }

            return this;
        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
        }


        return null;
    }

    public static boolean login(String email, String password) {
        Connection conn = Util.criarConexao();
        String sqlCommand = "SELECT * FROM \"User\" WHERE type = 3 and email = ? and password = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, email);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
        }
        return false;
    }

    public boolean searchByName(String name) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT * FROM \"User\" WHERE name LIKE ?;";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                this.key = rs.getInt("key");
                this.name = rs.getString("name");
                this.email = rs.getString("email");
                this.type = rs.getInt("type");
            }

            return true;

        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
        }


        return false;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
    }


}
