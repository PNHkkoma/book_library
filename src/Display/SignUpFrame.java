/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import manage.*;

public class SignUpFrame extends javax.swing.JFrame {
	List_User a;
	
    public SignUpFrame() {
    	a=new List_User();
        initComponents();
        addBirthDay();
    }
    
    //set giá trị combobox
    public void addBirthDay(){
        for(int i=1900;i<2022;i++)
            yearComboBox.addItem(String.valueOf(i));
        for(int i=1;i<13;i++)
            monthComboBox.addItem(String.valueOf(i));
        
    }
    
    //chỉnh giao diện                       
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        confirmButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameTextfield = new javax.swing.JTextField();
        nameLoginTextfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        backButton1 = new javax.swing.JButton();
        emailTextfield = new javax.swing.JTextField();
        monthComboBox = new javax.swing.JComboBox<>();
        yearComboBox = new javax.swing.JComboBox<>();
        passLoginPassfield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dayComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        phonenumberTextfield = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng kí");
        setPreferredSize(new java.awt.Dimension(600, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        confirmButton.setBackground(new java.awt.Color(255, 153, 153));
        confirmButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        confirmButton.setText("Xác nhận");
        confirmButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmButton.setFocusPainted(false);
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Tên đăng nhập");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Tên");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");

        nameTextfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        nameLoginTextfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu");

        backButton1.setBackground(new java.awt.Color(255, 153, 153));
        backButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        backButton1.setText("Trở về");
        backButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        backButton1.setFocusPainted(false);
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        emailTextfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        monthComboBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        yearComboBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        passLoginPassfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Ngày sinh");

        dayComboBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Email");

        phonenumberTextfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passLoginPassfield)
                                    .addComponent(nameLoginTextfield)
                                    .addComponent(nameTextfield)
                                    .addComponent(emailTextfield)
                                    .addComponent(phonenumberTextfield)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 118, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLoginTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLoginPassfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phonenumberTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emailTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        
    //thay đổi tháng thay đổi giới hạn ngày trong tháng
    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                              
        switch(String.valueOf(monthComboBox.getSelectedItem())){
            case "1":
            case "3":
            case "5":    
            case "7":    
            case "8":    
            case "10":    
            case "12": {
                dayComboBox.removeAllItems();
                for(int i=1;i<32;i++)
                    dayComboBox.addItem(String.valueOf(i));
                break;
            }
            case "4":
            case "6":
            case "9":
            case "11":{
                dayComboBox.removeAllItems();
                for(int i=1;i<31;i++)
                    dayComboBox.addItem(String.valueOf(i));
                break;
            }
            case "2":{
                dayComboBox.removeAllItems();
                for(int i=1;i<29;i++)
                    dayComboBox.addItem(String.valueOf(i));
                break;
            }
            
        }
            
    }                                             
                                          
    //action khi ấn nút quay về
    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        JFrame frame=new Login();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.dispose();
    }                                           
    // action khi ấn nút xác nhận
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {  
    	// kiểm tra thông tin bị bỏ trống
    	if(nameLoginTextfield.getText().equals("")||nameLoginTextfield.getText().equals("")||
    			passLoginPassfield.getText().equals("")||phonenumberTextfield.getText().equals("")||emailTextfield.getText().equals("")) {
    		JOptionPane.showMessageDialog(this,"Không được bỏ trống thông tin"
					+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
    	}else if(a.isExistNameLogin(nameLoginTextfield.getText())) {
    		JOptionPane.showMessageDialog(this,"Tên đăng nhập đã tồn tại"
					+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
    	}else if(!a.isNumeric(phonenumberTextfield.getText()))
    		JOptionPane.showMessageDialog(this,"Số điện thoại không đúng định dạng"
					+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
    	else  if(a.isExistPhoneNumber(phonenumberTextfield.getText()))
    			JOptionPane.showMessageDialog(this,"Số điện thoại đã được đăng kí"
    					+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
    	else {
    		Date birthday=new Date();
    		birthday.setDate(Integer.parseInt(String.valueOf(dayComboBox.getSelectedItem())));
    		birthday.setMonth(Integer.parseInt(String.valueOf(monthComboBox.getSelectedItem()))-1);
    		birthday.setYear(Integer.parseInt(String.valueOf(yearComboBox.getSelectedItem()))-1900);
    		
    		ArrayList<User> lstUser=a.getAllUser();
    		
    		String id="0"+String.valueOf(lstUser.size()+1);
    		
    		User user=new User(id, nameLoginTextfield.getText(), passLoginPassfield.getText(), nameTextfield.getText(),
    				phonenumberTextfield.getText(), emailTextfield.getText(), "nomal", birthday, 0);
	        a.addUser(user);
    		JFrame frame=new Login();
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
	        this.dispose();
    	}
    }                                             

                     
    private javax.swing.JButton backButton1;
    private javax.swing.JButton confirmButton;
    private javax.swing.JComboBox<String> dayComboBox;
    private javax.swing.JTextField emailTextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JTextField nameLoginTextfield;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JTextField passLoginPassfield;
    private javax.swing.JTextField phonenumberTextfield;
    private javax.swing.JComboBox<String> yearComboBox;
}
