package sample.Database;

import sample.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CardAnswer {
    int key;
    int cardKey;
    int userKey;
    int type;
    String date;


    public CardAnswer() {
        this.key = 0;
        this.cardKey = 0;
        this.userKey = 0;
        this.type = 0;
        this.date = "";
    }


    public CardAnswer(int key, int cardKey, int userKey, int type, String date) {
        this.key = key;
        this.cardKey = cardKey;
        this.userKey = userKey;
        this.type = type;
        this.date = date;

    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"Post\" (cardKey,userKey,type,date )VALUES ( ?,?,?,?);";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            st.setInt(1, this.cardKey);
            st.setInt(2, this.userKey);
            st.setInt(3, this.type);
            st.setString(4, this.date);


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
