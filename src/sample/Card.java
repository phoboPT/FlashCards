package sample;
import sample.Util.Util;

import java.sql.*;


public class Card {
    int ID;
    String title;
    String content;

    public void create(){
        Connection conn= Util.criarConexao();

        String sqlCommand="INSERT INTO public.\"Post\" (title, content)VALUES ( ?, ?);";

        try{
            PreparedStatement st=conn.prepareStatement(sqlCommand);


            st.setString(1,this.title);
            st.setString(2,this.content);


            st.execute();

        }catch (SQLException ex){
            System.out.println("erro" + ex.getMessage());
        }
    }
    public Card() {
        this.ID = 0;
        this.title = "";
        this.content = "";
    }


    public Card(int ID, String title, String content) {
        this.ID = ID;
        this.title = title;
        this.content = content;
    }
}
