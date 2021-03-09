/*
 * Created by JFormDesigner on Tue Mar 09 22:30:03 GMT 2021
 */

package sample;

import sample.Database.User;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Hugo
 */
public class NewJFrame extends JFrame {
    public NewJFrame() {
        initComponents();
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        User user = new User("Jorge", "teste@teste.pt", "12345678", 1);
        System.out.println(user.create());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hugo
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jButton1 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //---- jButton1 ----
        jButton1.setText("Press Me");
        jButton1.addActionListener(e -> jButton1ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(440, 440, 440)
                                .addComponent(jButton1)
                                .addContainerGap(469, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(662, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)
                                .addComponent(jButton1)
                                .addContainerGap(328, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hugo
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JButton jButton1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
