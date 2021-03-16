package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deck {

    int key;
    String name;
    String description;
    int type;
    int userKey;


    public Deck() {
        this.key = 0;
        this.name = "";
        this.description = "";
        this.type = 0;
        this.userKey = 0;
    }


    public Deck(int key, String name,String description,int type,int userKey) {
        this.key = key;
        this.name=name ;
        this.description=description;
        this.type=type;
        this.userKey=userKey;

    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"Post\" (name,description,type ,userKey)VALUES ( ?,?,?,?);";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            st.setString(1, this.name);
            st.setString(2, this.description);
            st.setInt(3, this.type);
            st.setInt(4, this.userKey);



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
