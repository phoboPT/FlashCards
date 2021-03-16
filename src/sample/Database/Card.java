package sample.Database;

import sample.Util.Util;

import java.sql.*;


public class Card {
    int key;
    int deckKey;
    String question;
    String questionImage;
    String answer;
    String answerImage;
    String commentary;


    public Card() {
        this.key = 0;
        this.question = "";
        this.questionImage = "";
        this.answer = "";
        this.answerImage = "";
        this.commentary = "";
    }


    public Card(int key, String question, String questionImage, String answer, String answerImage, String commentary) {
        this.key = key;
        this.question = question;
        this.questionImage = questionImage;
        this.answer = answer;
        this.answerImage = answerImage;
        this.commentary = commentary;
    }

    public boolean create() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO public.\"Post\" (deckKey, question,questionImage,answer,answerImage,comentary)VALUES ( ?, ?,?,?,?,?);";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            st.setInt(1, this.deckKey);
            st.setString(2, this.question);
            st.setString(3, this.questionImage);
            st.setString(4, this.answer);
            st.setString(5, this.answerImage);
            st.setString(6, this.commentary);


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
}
