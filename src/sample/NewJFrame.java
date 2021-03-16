/*
 * Created by JFormDesigner on Tue Mar 09 22:30:03 GMT 2021
 */

package sample;

import sample.Database.User;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author Hugo
 */
public class NewJFrame extends JFrame {
    public NewJFrame() {
        initComponents();
    }


    private void list(MouseEvent e) {
        // TODO add your code here
        List<User> allUsers = User.list();
        for (User user : allUsers) {

            System.out.println(user.getKey() + " " + user.getName());
        }
    }

    private void create(MouseEvent e) {
        User user = new User();
        user.setName(jTextField1.getText());
        user.setEmail(jTextField2.getText());
        user.setPassword(jTextField3.getText());
        user.setType(1);
        user.create();
    }


    private void delete(MouseEvent e) {
        // TODO add your code here
        System.out.println("delete");
        User.delete(Integer.parseInt(textField1.getText()));
    }

    private void menuItem2MouseClicked(MouseEvent e) {
        // TODO add your code here

    }

    // teste 123
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hugo
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        jTextField3 = new JTextField();
        label3 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("text");

                //---- menuItem1 ----
                menuItem1.setText("text");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("text");
                menuItem2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menuItem2MouseClicked(e);
                    }
                });
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Gerir");

                //---- menuItem3 ----
                menuItem3.setText("AnswerTypes");
                menu2.add(menuItem3);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //---- jButton1 ----
        jButton1.setText("List  All");
        jButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                list(e);
            }
        });

        //---- button1 ----
        button1.setText("Create");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                create(e);
            }
        });

        //---- button2 ----
        button2.setText("Delete");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delete(e);
            }
        });

        //---- button3 ----
        button3.setText("Update");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delete(e);
            }
        });

        //---- label1 ----
        label1.setText("Nome");

        //---- label2 ----
        label2.setText("Email");

        //---- label3 ----
        label3.setText("Password");

        //---- label4 ----
        label4.setText("ID");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(290, 290, 290)
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(275, 275, 275)
                            .addComponent(button1)
                            .addGap(0, 0, 0)
                            .addComponent(jButton1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button3)))
                    .addGap(499, 499, 499))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addComponent(label2)
                        .addComponent(label1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextField3, GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField2)
                        .addComponent(jTextField1))
                    .addGap(523, 523, 523))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(label3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(jButton1)
                        .addComponent(button2)
                        .addComponent(button3))
                    .addContainerGap(276, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hugo
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JButton jButton1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label1;
    private JLabel label2;
    private JTextField jTextField3;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
