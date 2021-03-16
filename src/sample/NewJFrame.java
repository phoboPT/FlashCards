/*
 * Created by JFormDesigner on Tue Mar 09 22:30:03 GMT 2021
 */

package sample;

import sample.Database.AnswerType;
import sample.Database.DeckType;
import sample.Database.User;

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


    private void delete(MouseEvent e) {
        // TODO add your code here
        System.out.println("delete");

    }

    private void menuItem2MouseClicked(MouseEvent e) {
        // TODO add your code here

        panel1.removeAll();
        panel1.add(panel3);
        panel1.repaint();
        panel1.revalidate();

    }

    private void menuItem3MouseClicked(MouseEvent e) {
        // TODO add your code here
        panel2.setVisible(false);
        panel3.setVisible(true);
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here

    }

    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        panel1.removeAll();
        panel1.add(panel3);
        panel1.repaint();
        panel1.revalidate();

        PopulateTableAnswer();


    }

    private void PopulateTableAnswer() {
        List<AnswerType> allData = AnswerType.list();


        DefaultTableModel model_d = new DefaultTableModel(new Object[]{"ID", "Name"}, 0);
        //Adiciona os medicamentos na tablela
        try {

            for (AnswerType data : allData) {
                model_d.addRow(new Object[]{data.getKey(), data.getName()});
            }

            table1.setModel(model_d);
        } catch (
                IndexOutOfBoundsException error) {
            System.out.println("Sem medicamentos..");
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

            table2.setModel(model_d);
        } catch (
                IndexOutOfBoundsException error) {
            System.out.println("Sem medicamentos..");
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println("entrou");
        AnswerType answerType = new AnswerType();
        answerType.setName(textField3.getText());


        answerType.create();

        PopulateTableAnswer();
    }


    private void menuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        panel1.removeAll();
        panel1.add(panel5);
        panel1.repaint();
        panel1.revalidate();

        PopulateTableDeck();
    }

    private void menuItem4MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here

        DeckType deckType = new DeckType();
        deckType.setName(textField3.getText());


        deckType.create();

        PopulateTableDeck();
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
        menuItem4 = new JMenuItem();
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel4 = new JPanel();
        label4 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();
        panel5 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        panel6 = new JPanel();
        label6 = new JLabel();
        textField5 = new JTextField();
        button2 = new JButton();

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
                menuItem3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menuItem3MouseClicked(e);
                        menuItem3MouseClicked(e);
                    }
                });
                menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
                menu2.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("DeckType");
                menuItem4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menuItem4MouseClicked(e);
                        menuItem4MouseClicked(e);
                    }
                });
                menuItem4.addActionListener(e -> menuItem4ActionPerformed(e));
                menu2.add(menuItem4);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
                    swing.border.EmptyBorder(0, 0, 0, 0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax.swing.border
                    .TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dia\u006cog"
                    , java.awt.Font.BOLD, 12), java.awt.Color.red), panel1.getBorder
                    ()));
            panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override
                public void propertyChange(java
                                                   .beans.PropertyChangeEvent e) {
                    if ("\u0062ord\u0065r".equals(e.getPropertyName())) throw new RuntimeException
                            ();
                }
            });
            panel1.setLayout(new CardLayout());

            //======== panel2 ========
            {

                //---- label1 ----
                label1.setText("text");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(852, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(475, Short.MAX_VALUE))
                );
            }
            panel1.add(panel2, "card1");

            //======== panel3 ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("Create"));

                    //---- label4 ----
                    label4.setText("Name");

                    //---- button1 ----
                    button1.setText("Save");
                    button1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            button1MouseClicked(e);
                            button1MouseClicked(e);
                        }
                    });
                    button1.addActionListener(e -> button1ActionPerformed(e));

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                            panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(label4)
                                            .addGap(24, 24, 24)
                                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(40, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                            .addContainerGap(218, Short.MAX_VALUE)
                                            .addComponent(button1)
                                            .addGap(201, 201, 201))
                    );
                    panel4Layout.setVerticalGroup(
                            panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(label4)
                                                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(45, 45, 45)
                                            .addComponent(button1)
                                            .addContainerGap(45, Short.MAX_VALUE))
                    );
                }

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
                panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(25, Short.MAX_VALUE))
                );
            }
            panel1.add(panel3, "card2");

            //======== panel5 ========
            {

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(table2);
                }

                //======== panel6 ========
                {
                    panel6.setBorder(new TitledBorder("Create"));

                    //---- label6 ----
                    label6.setText("Name");

                    //---- button2 ----
                    button2.setText("Save");
                    button2.addActionListener(e -> button2ActionPerformed(e));

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                            panel6Layout.createParallelGroup()
                                    .addGroup(panel6Layout.createSequentialGroup()
                                            .addContainerGap(12, Short.MAX_VALUE)
                                            .addGroup(panel6Layout.createParallelGroup()
                                                    .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                                            .addComponent(label6)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(23, 23, 23))
                                                    .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                                            .addComponent(button2)
                                                            .addGap(192, 192, 192))))
                    );
                    panel6Layout.setVerticalGroup(
                            panel6Layout.createParallelGroup()
                                    .addGroup(panel6Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(label6)
                                                    .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                            .addComponent(button2)
                                            .addGap(30, 30, 30))
                    );
                }

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                                .addGroup(panel5Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(14, Short.MAX_VALUE))
                );
                panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                                .addGroup(panel5Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(66, Short.MAX_VALUE))
                );
            }
            panel1.add(panel5, "card3");
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
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
    private JMenuItem menuItem4;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel4;
    private JLabel label4;
    private JTextField textField3;
    private JButton button1;
    private JPanel panel5;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JPanel panel6;
    private JLabel label6;
    private JTextField textField5;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
