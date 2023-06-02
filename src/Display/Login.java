package Display;

import java.util.ArrayList;

import javax.swing.*;
import manage.*;

public class Login extends javax.swing.JFrame {
        int indexUser = 0;
        List_User a;

        public Login() {
                a = new List_User();
                initComponents();
                setLocationRelativeTo(null);

        }

        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                nameloginTextField = new javax.swing.JTextField();
                loginButton = new javax.swing.JButton();
                jSeparator1 = new javax.swing.JSeparator();
                passLoginPassField = new javax.swing.JPasswordField();
                signupButton = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("BookManger");

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));

                jLabel1.setFont(new java.awt.Font("SVN-Amethyst", 0, 110)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 102, 153));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("Book Manager");

                jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setText("Tên đăng nhập");

                jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel3.setText("Mật khẩu");

                nameloginTextField.setBackground(new java.awt.Color(255, 153, 153));
                nameloginTextField.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

                loginButton.setBackground(new java.awt.Color(255, 102, 102));
                loginButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
                loginButton.setText("Đăng nhập");
                loginButton.setBorderPainted(false);
                loginButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                loginButtonActionPerformed(evt);
                        }
                });

                jSeparator1.setForeground(new java.awt.Color(0, 51, 204));

                passLoginPassField.setBackground(new java.awt.Color(255, 153, 153));

                signupButton.setBackground(new java.awt.Color(255, 255, 255));
                signupButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
                signupButton.setForeground(new java.awt.Color(51, 102, 255));
                signupButton.setText("Tạo tài khoản?");
                signupButton.setBorder(null);
                signupButton.setBorderPainted(false);
                signupButton.setOpaque(false);
                signupButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                signupButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(232, 232, 232)
                                                                .addComponent(jSeparator1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                173,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                170,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(loginButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                126,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(199, 199, 199))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(275, 275, 275)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                94,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                94,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(37, 37, 37)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(nameloginTextField,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                221,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(passLoginPassField))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                618,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(134, 134, 134))
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(236, 236, 236)
                                                                                .addComponent(signupButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                169,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(495,
                                                                                                Short.MAX_VALUE))));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(36, 36, 36)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                175,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                39,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(nameloginTextField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(12, 12, 12)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                39,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(passLoginPassField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(loginButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(28, 28, 28)
                                                                                                .addComponent(jSeparator1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                10,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(237, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                .addContainerGap(327,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(signupButton)
                                                                                                .addGap(256, 256,
                                                                                                                256))));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }// </editor-fold>

        private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {

                if (nameloginTextField.getText().equals("") || passLoginPassField.getText().equals("")) {

                        JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu sai"
                                        + "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
                } else {

                        indexUser = a.indexUser(nameloginTextField.getText(), passLoginPassField.getText());
                        if (indexUser == -1)
                                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu sai"
                                                + "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
                        else {
                                ArrayList<User> users = a.getAllUser();
                                JFrame frame = new JFrame();
                                if (users.get(indexUser).getLevel().equals("admin")) {
                                        frame = new AdminFrame(indexUser);

                                } else
                                        frame = new UserFrame(indexUser);
                                frame.setVisible(true);
                                frame.setLocationRelativeTo(null);
                                this.dispose();
                        }
                }
        }

        private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {

                JFrame frame = new SignUpFrame();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                this.dispose();
        }

        private javax.swing.JButton signupButton;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JTextField nameloginTextField;
        private javax.swing.JPasswordField passLoginPassField;
        private javax.swing.JButton loginButton;

}
