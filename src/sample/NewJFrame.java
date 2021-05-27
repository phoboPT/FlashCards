/*
 * Created by JFormDesigner on Tue Mar 09 22:30:03 GMT 2021
 */

package sample;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import sample.Database.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author Hugo
 */

public class NewJFrame extends JFrame {

    boolean isDeckTypeUpdate = false;
    boolean isUserTypeUpdate = false;
    boolean isAnswerTypeUpdate = false;
    int deckTypeKey;
    int userTypeKey;
    int answerTypeKey;

    public NewJFrame() {
        initComponents();
    }


    private void PopulateTableAnswer() {
        List<AnswerType> allData = AnswerType.list();
        DefaultTableModel model_d = new DefaultTableModel(new Object[]{"ID", "Name"}, 0);
        //Adiciona os medicamentos na tablela
        try {
            for (AnswerType data : allData) {
                model_d.addRow(new Object[]{data.getKey(), data.getName()});
            }
            answerTable.setModel(model_d);
        } catch (
                IndexOutOfBoundsException error) {
            System.out.println("Sem dados..");
        }
    }

    private void PopulateTableDeck() {
        List<DeckType> allData = DeckType.list();

        DefaultTableModel model_d = new DefaultTableModel(new Object[]{"ID", "Name"}, 0);
        //Adiciona os medicamentos na tablela
        try {
            for (DeckType data : allData) {
                model_d.addRow(new Object[]{data.getKey(), data.getName()});
            }
            deckTable.setModel(model_d);

            isDeckTypeUpdate = false;
            deckTypeKey = 0;
            userDeleteBtn.setEnabled(false);
        } catch (
                IndexOutOfBoundsException error) {
            System.out.println("Sem dados..");
        }
    }

    private void PopulateTableUserType() {
        List<UserType> allData = UserType.list();
        DefaultTableModel model_d = new DefaultTableModel(new Object[]{"ID", "Name"}, 0);
        //Adiciona os medicamentos na tablela
        try {
            for (UserType data : allData) {
                model_d.addRow(new Object[]{data.getKey(), data.getName()});
            }
            userTable.setModel(model_d);
        } catch (
                IndexOutOfBoundsException error) {
            System.out.println("Sem dados..");
        }
    }

    private boolean showMessage(String message) {
        int reply = JOptionPane.showConfirmDialog(null, message, "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    private void userTypesBTN(ActionEvent e) {
        //User Button
        panel1.removeAll();
        panel1.add(panel5);
        panel1.repaint();
        panel1.revalidate();

        isUserTypeUpdate = false;
        userTextField.setText("");
        userTypeKey = 0;
        PopulateTableUserType();
    }


    private void userTypesDeleteBtn(ActionEvent e) {
        boolean confirmDelete = showMessage("Are you sure!");
        if (confirmDelete) {
            UserType.delete(userTypeKey);
            PopulateTableUserType();
        }
        isUserTypeUpdate = false;
        userTypeKey = 0;
        userDeleteBtn.setEnabled(false);
        userTextField.setText("");
    }


    private void deckDeleteBtn(ActionEvent e) {
        boolean confirmDelete = showMessage("Are you sure!");

        if (confirmDelete) {
            DeckType.delete(deckTypeKey);
            PopulateTableDeck();
        }
        isDeckTypeUpdate = false;
        deckTypeKey = 0;
        deckDeleteBtn.setEnabled(false);
        deckTextField.setText("");
    }


    private void deckSaveBtnActionPerformed(ActionEvent e) {
        if (deckTextField.getText().isEmpty()) {
            showMessage("Name field is empty.");
        }
        DeckType deckType = new DeckType();
        deckType.setName(deckTextField.getText());
        if (isDeckTypeUpdate) {
            DeckType.update(deckTypeKey, deckTextField.getText());

        } else {
            deckType.create();
        }
        isDeckTypeUpdate = false;
        deckTypeKey = 0;
        deckDeleteBtn.setEnabled(false);
        deckTextField.setText("");
        PopulateTableDeck();
    }

    private void deckTableClickMousePressed(MouseEvent e) {
        DeckType deckType = new DeckType((int) deckTable.getValueAt(deckTable.getSelectedRow(), 0), deckTable.getValueAt(deckTable.getSelectedRow(), 1).toString());

        deckDeleteBtn.setEnabled(true);
        this.isDeckTypeUpdate = true;
        this.deckTypeKey = deckType.getKey();
        deckTextField.setText(deckType.getName());
    }

    private void deckTypesBTNActionPerformed(ActionEvent e) {
        //Deck Button
        panel1.removeAll();
        panel1.add(panel3);
        panel1.repaint();
        panel1.revalidate();
        deckDeleteBtn.setEnabled(false);
        deckTextField.setText("");
        isDeckTypeUpdate = false;
        deckTypeKey = 0;
        PopulateTableDeck();
    }


    private void awnserTypesBTNActionPerformed(ActionEvent e) {
        //Answer Button
        panel1.removeAll();
        panel1.add(panel7);
        panel1.repaint();
        panel1.revalidate();

        answerTextField.setText("");
        isAnswerTypeUpdate = false;
        answerTypeKey = 0;
        PopulateTableAnswer();
    }


    private void userSaveBtnActionPerformed(ActionEvent e) {
        if (userTextField.getText().isEmpty()) {
            showMessage("Name field is empty.");
        }
        UserType userType = new UserType();
        userType.setName(userTextField.getText());
        if (isUserTypeUpdate) {
            UserType.update(userTypeKey, userTextField.getText());

        } else {
            userType.create();
        }
        isUserTypeUpdate = false;
        userTypeKey = 0;
        userDeleteBtn.setEnabled(false);
        userTextField.setText("");
        PopulateTableUserType();
    }


    private void answerSaveBtnActionPerformed(ActionEvent e) {
        if (answerTextField.getText().isEmpty()) {
            showMessage("Name field is empty.");
        }
        AnswerType answerType = new AnswerType();
        answerType.setName(answerTextField.getText());
        if (isAnswerTypeUpdate) {
            AnswerType.update(answerTypeKey, answerTextField.getText());

        } else {
            answerType.create();
        }
        isAnswerTypeUpdate = false;
        answerTypeKey = 0;
        answerDeleteBtn.setEnabled(false);
        answerTextField.setText("");
        PopulateTableAnswer();
    }

    private void answerTableClicked(MouseEvent e) {
        AnswerType userType = new AnswerType((int) answerTable.getValueAt(answerTable.getSelectedRow(), 0), answerTable.getValueAt(answerTable.getSelectedRow(), 1).toString());

        answerDeleteBtn.setEnabled(true);
        isAnswerTypeUpdate = true;
        answerTypeKey = userType.getKey();
        answerTextField.setText(userType.getName());
    }

    private void answerDeleteBtnActionPerformed(ActionEvent e) {
        boolean confirmDelete = showMessage("Are you sure!");

        if (confirmDelete) {
            AnswerType.delete(answerTypeKey);
            PopulateTableAnswer();
        }
        isAnswerTypeUpdate = false;
        answerTypeKey = 0;
        answerTextField.setText("");
        answerDeleteBtn.setEnabled(false);
    }


    private void userTableMouseClickled(MouseEvent e) {
        UserType userType = new UserType((int) userTable.getValueAt(userTable.getSelectedRow(), 0), userTable.getValueAt(userTable.getSelectedRow(), 1).toString());

        userDeleteBtn.setEnabled(true);
        isUserTypeUpdate = true;
        userTypeKey = userType.getKey();
        userTextField.setText(userType.getName());

    }

    private void loginBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        boolean isLogged = User.login(emailTextField.getText(), paswordTextField.getText());

        if (isLogged) {
            welcomeLbl.setVisible(true);
            loginBtn.setVisible(false);
            passwordLbl.setVisible(false);
            paswordTextField.setVisible(false);
            emailLbl.setVisible(false);
            emailTextField.setVisible(false);
            button5.setVisible(true);
            button6.setVisible(true);
            button7.setVisible(true);
            logoutBtn.setVisible(true);
        } else {

            JOptionPane.showMessageDialog(null, "Username or password is incorrect!","Incorrect Login", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void logoutBtnActionPerformed(ActionEvent e) {
        welcomeLbl.setVisible(false);
        loginBtn.setVisible(true);
        passwordLbl.setVisible(true);
        paswordTextField.setVisible(true);
        emailLbl.setVisible(true);
        emailTextField.setVisible(true);
        button5.setVisible(false);
        button6.setVisible(false);
        button7.setVisible(false);
        logoutBtn.setVisible(false);

        panel1.removeAll();
        panel1.add(panel2);
        panel1.repaint();
        panel1.revalidate();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        panel1 = new JPanel();
        panel2 = new JPanel();
        emailTextField = new JTextField();
        paswordTextField = new JTextField();
        emailLbl = new JLabel();
        passwordLbl = new JLabel();
        loginBtn = new JButton();
        welcomeLbl = new JLabel();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        deckTable = new JTable();
        panel4 = new JPanel();
        deckSaveBtn = new JButton();
        deckTextField = new JTextField();
        label4 = new JLabel();
        deckDeleteBtn = new JButton();
        label5 = new JLabel();
        panel5 = new JPanel();
        scrollPane2 = new JScrollPane();
        userTable = new JTable();
        panel6 = new JPanel();
        label6 = new JLabel();
        userTextField = new JTextField();
        userSave = new JButton();
        userDeleteBtn = new JButton();
        label3 = new JLabel();
        panel7 = new JPanel();
        scrollPane3 = new JScrollPane();
        answerTable = new JTable();
        panel8 = new JPanel();
        label2 = new JLabel();
        answerTextField = new JTextField();
        answerSaveBtn = new JButton();
        answerDeleteBtn = new JButton();
        label1 = new JLabel();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        separator1 = compFactory.createSeparator("");
        logoutBtn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );
            panel1.setLayout(new CardLayout());

            //======== panel2 ========
            {

                //---- emailLbl ----
                emailLbl.setText("Email");

                //---- passwordLbl ----
                passwordLbl.setText("Password");

                //---- loginBtn ----
                loginBtn.setText("Login");
                loginBtn.addActionListener(e -> loginBtnActionPerformed(e));

                //---- welcomeLbl ----
                welcomeLbl.setText("Welcome");
                welcomeLbl.setFont(welcomeLbl.getFont().deriveFont(welcomeLbl.getFont().getSize() + 7f));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(310, 310, 310)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(passwordLbl)
                                        .addComponent(emailLbl)
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                            .addComponent(paswordTextField, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(436, 436, 436)
                                    .addComponent(loginBtn))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(408, 408, 408)
                                    .addComponent(welcomeLbl)))
                            .addContainerGap(358, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(welcomeLbl)
                            .addGap(76, 76, 76)
                            .addComponent(emailLbl)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(passwordLbl)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(paswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68)
                            .addComponent(loginBtn)
                            .addContainerGap(198, Short.MAX_VALUE))
                );
            }
            panel1.add(panel2, "card1");

            //======== panel3 ========
            {

                //======== scrollPane1 ========
                {

                    //---- deckTable ----
                    deckTable.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            deckTableClickMousePressed(e);
                        }
                    });
                    scrollPane1.setViewportView(deckTable);
                }

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("Create"));

                    //---- deckSaveBtn ----
                    deckSaveBtn.setText("Save");
                    deckSaveBtn.addActionListener(e -> deckSaveBtnActionPerformed(e));

                    //---- label4 ----
                    label4.setText("Name");

                    //---- deckDeleteBtn ----
                    deckDeleteBtn.setText("Delete");
                    deckDeleteBtn.setEnabled(false);
                    deckDeleteBtn.addActionListener(e -> deckDeleteBtn(e));

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(deckSaveBtn)
                                        .addGap(117, 117, 117)
                                        .addComponent(deckDeleteBtn))
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addGap(24, 24, 24)
                                        .addComponent(deckTextField, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(64, Short.MAX_VALUE))
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label4)
                                    .addComponent(deckTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(deckSaveBtn)
                                    .addComponent(deckDeleteBtn))
                                .addContainerGap(80, Short.MAX_VALUE))
                    );
                }

                //---- label5 ----
                label5.setText("Deck Types");
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(label5))
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(label5)
                            .addGap(11, 11, 11)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30))
                );
            }
            panel1.add(panel3, "card2");

            //======== panel5 ========
            {

                //======== scrollPane2 ========
                {

                    //---- userTable ----
                    userTable.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            userTableMouseClickled(e);
                        }
                    });
                    scrollPane2.setViewportView(userTable);
                }

                //======== panel6 ========
                {
                    panel6.setBorder(new TitledBorder("Create"));

                    //---- label6 ----
                    label6.setText("Name");

                    //---- userSave ----
                    userSave.setText("Save");
                    userSave.addActionListener(e -> userSaveBtnActionPerformed(e));

                    //---- userDeleteBtn ----
                    userDeleteBtn.setText("Delete");
                    userDeleteBtn.setEnabled(false);
                    userDeleteBtn.addActionListener(e -> userTypesDeleteBtn(e));

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addContainerGap(67, Short.MAX_VALUE)
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userTextField, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(userSave)
                                .addGap(108, 108, 108)
                                .addComponent(userDeleteBtn)
                                .addContainerGap(120, Short.MAX_VALUE))
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6)
                                    .addComponent(userTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(userSave)
                                    .addComponent(userDeleteBtn))
                                .addContainerGap(17, Short.MAX_VALUE))
                    );
                }

                //---- label3 ----
                label3.setText("User Types");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(panel5Layout.createParallelGroup()
                                .addComponent(label3)
                                .addGroup(panel5Layout.createSequentialGroup()
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(10, 10, 10))
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel5Layout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(57, Short.MAX_VALUE))
                );
            }
            panel1.add(panel5, "card3");

            //======== panel7 ========
            {

                //======== scrollPane3 ========
                {

                    //---- answerTable ----
                    answerTable.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            answerTableClicked(e);
                        }
                    });
                    scrollPane3.setViewportView(answerTable);
                }

                //======== panel8 ========
                {
                    panel8.setBorder(new TitledBorder("Create"));

                    //---- label2 ----
                    label2.setText("Name");

                    //---- answerSaveBtn ----
                    answerSaveBtn.setText("Save");
                    answerSaveBtn.addActionListener(e -> answerSaveBtnActionPerformed(e));

                    //---- answerDeleteBtn ----
                    answerDeleteBtn.setText("Delete");
                    answerDeleteBtn.setEnabled(false);
                    answerDeleteBtn.addActionListener(e -> answerDeleteBtnActionPerformed(e));

                    GroupLayout panel8Layout = new GroupLayout(panel8);
                    panel8.setLayout(panel8Layout);
                    panel8Layout.setHorizontalGroup(
                        panel8Layout.createParallelGroup()
                            .addGroup(panel8Layout.createSequentialGroup()
                                .addGroup(panel8Layout.createParallelGroup()
                                    .addGroup(panel8Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(answerTextField, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel8Layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addComponent(answerSaveBtn)
                                        .addGap(129, 129, 129)
                                        .addComponent(answerDeleteBtn)))
                                .addContainerGap(99, Short.MAX_VALUE))
                    );
                    panel8Layout.setVerticalGroup(
                        panel8Layout.createParallelGroup()
                            .addGroup(panel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(answerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(answerSaveBtn)
                                    .addComponent(answerDeleteBtn))
                                .addContainerGap(45, Short.MAX_VALUE))
                    );
                }

                //---- label1 ----
                label1.setText("Answer Types");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 4f));

                GroupLayout panel7Layout = new GroupLayout(panel7);
                panel7.setLayout(panel7Layout);
                panel7Layout.setHorizontalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(panel7Layout.createParallelGroup()
                                .addComponent(label1)
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(21, Short.MAX_VALUE))
                );
                panel7Layout.setVerticalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            panel1.add(panel7, "card4");
        }

        //---- button5 ----
        button5.setText("DeckTypes");
        button5.setVisible(false);
        button5.addActionListener(e -> deckTypesBTNActionPerformed(e));

        //---- button6 ----
        button6.setText("User Types");
        button6.setVisible(false);
        button6.addActionListener(e -> userTypesBTN(e));

        //---- button7 ----
        button7.setText("Anwser Types");
        button7.setVisible(false);
        button7.addActionListener(e -> awnserTypesBTNActionPerformed(e));

        //---- logoutBtn ----
        logoutBtn.setText("Logout");
        logoutBtn.setVisible(false);
        logoutBtn.addActionListener(e -> logoutBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(separator1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button6, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(button7, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel1;
    private JPanel panel2;
    private JTextField emailTextField;
    private JTextField paswordTextField;
    private JLabel emailLbl;
    private JLabel passwordLbl;
    private JButton loginBtn;
    private JLabel welcomeLbl;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTable deckTable;
    private JPanel panel4;
    private JButton deckSaveBtn;
    private JTextField deckTextField;
    private JLabel label4;
    private JButton deckDeleteBtn;
    private JLabel label5;
    private JPanel panel5;
    private JScrollPane scrollPane2;
    private JTable userTable;
    private JPanel panel6;
    private JLabel label6;
    private JTextField userTextField;
    private JButton userSave;
    private JButton userDeleteBtn;
    private JLabel label3;
    private JPanel panel7;
    private JScrollPane scrollPane3;
    private JTable answerTable;
    private JPanel panel8;
    private JLabel label2;
    private JTextField answerTextField;
    private JButton answerSaveBtn;
    private JButton answerDeleteBtn;
    private JLabel label1;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JComponent separator1;
    private JButton logoutBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
