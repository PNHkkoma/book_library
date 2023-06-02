/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import manage.*;

public class AddBookFrame extends javax.swing.JFrame {
	int indexUser;
	List_BookIn b;
    
   public AddBookFrame(int indexUser) {
	   b=new List_BookIn();
	   this.indexUser=indexUser;
        initComponents();
        addYear();
    }
    //thêm dữ liệu vào combobox
     public void addYear(){
        for(int i=1900;i<2022;i++)
            yearComboBox.addItem(String.valueOf(i));
        for(int i=1;i<13;i++)
            monthComboBox.addItem(String.valueOf(i));
        
    }                                                    
    //giao diện                  
    private void initComponents() {

    	buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lichsuRadioButton = new javax.swing.JRadioButton();
        authorTextField = new javax.swing.JTextField();
        thieunhiRadioButton = new javax.swing.JRadioButton();
        tamliRadioButton = new javax.swing.JRadioButton();
        nameTextField = new javax.swing.JTextField();
        backButton1 = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();
        giaotrinhRadioButton = new javax.swing.JRadioButton();
        vanhocRadioButton = new javax.swing.JRadioButton();
        kinhteRadioButton = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        numberSpinner = new javax.swing.JSpinner();
        ngontinhRadioButton = new javax.swing.JRadioButton();
        dayComboBox = new javax.swing.JComboBox<>();
        phapluatRadioButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        monthComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        publisherTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        costSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 600));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID");

        lichsuRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(lichsuRadioButton);
        lichsuRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lichsuRadioButton.setText("Lịch sử");

        authorTextField.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        thieunhiRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(thieunhiRadioButton);
        thieunhiRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        thieunhiRadioButton.setText("Thiếu nhi");

        tamliRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(tamliRadioButton);
        tamliRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tamliRadioButton.setText("Tâm lí");

        nameTextField.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

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

        confirmButton.setBackground(new java.awt.Color(255, 153, 153));
        confirmButton.setText("Xác nhận");
        confirmButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmButton.setFocusPainted(false);
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        giaotrinhRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(giaotrinhRadioButton);
        giaotrinhRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        giaotrinhRadioButton.setText("Giáo trình");

        vanhocRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(vanhocRadioButton);
        vanhocRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        vanhocRadioButton.setText("Văn học");

        kinhteRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(kinhteRadioButton);
        kinhteRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kinhteRadioButton.setText("Kinh tế");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Năm xuất bản");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tên");

        yearComboBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tác giả");

        numberSpinner.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        numberSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        numberSpinner.setRequestFocusEnabled(false);

        ngontinhRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ngontinhRadioButton);
        ngontinhRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ngontinhRadioButton.setSelected(true);
        ngontinhRadioButton.setText("Ngôn tình");

        dayComboBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        phapluatRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(phapluatRadioButton);
        phapluatRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        phapluatRadioButton.setText("Pháp luật");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Thể loại");

        idTextField.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        monthComboBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Số lượng");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("NXB");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Trị giá");

        costSpinner.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        costSpinner.setModel(new javax.swing.SpinnerNumberModel(1000, 1000, null, 1000));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(kinhteRadioButton)
                                            .addComponent(vanhocRadioButton)
                                            .addComponent(lichsuRadioButton)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(giaotrinhRadioButton)
                                    .addComponent(ngontinhRadioButton)
                                    .addComponent(phapluatRadioButton)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(monthComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)))))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tamliRadioButton)
                                            .addComponent(thieunhiRadioButton))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(costSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(authorTextField)
                            .addComponent(publisherTextField)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idTextField)
                            .addComponent(nameTextField))))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(authorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publisherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phapluatRadioButton)
                            .addComponent(lichsuRadioButton)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tamliRadioButton))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vanhocRadioButton)
                            .addComponent(ngontinhRadioButton)
                            .addComponent(thieunhiRadioButton))
                        .addGap(11, 11, 11)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kinhteRadioButton)
                            .addComponent(giaotrinhRadioButton)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(costSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                                          
    //set ngày theo tháng
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
    //action nút back
    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        JFrame frame=new AdminFrame(indexUser);	
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.dispose();       
    }                                           
    //action nút xác nhận
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {    
    	//kiểm tra có hàng nào rỗng không
    	if(idTextField.getText().equals("")||nameTextField.getText().equals("")||
    			authorTextField.getText().equals("")||publisherTextField.getText().equals(""))
    		JOptionPane.showMessageDialog(this,"Không được bỏ trống thông tin"
					+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
    	//kiểm tra id
    	else if(b.isExsis(idTextField.getText()))
    		JOptionPane.showMessageDialog(this,"ID đã tồn tại"
					+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
    	//nếu không có thì nhập dữ liệu từ các hàng rồi thêm sách vừa tạo vào database
    	else {
    		Date year=new Date();
    		year.setDate(Integer.parseInt(String.valueOf(dayComboBox.getSelectedItem())));
    		year.setMonth(Integer.parseInt(String.valueOf(monthComboBox.getSelectedItem()))-1);
    		year.setYear(Integer.parseInt(String.valueOf(yearComboBox.getSelectedItem()))-1900);
    		
    		String category;
    		if(lichsuRadioButton.isSelected())
    			category="lịch sử";
    		else if(phapluatRadioButton.isSelected())
    			category="pháp luật";
    		else if(tamliRadioButton.isSelected())
    			category="tâm lí";
    		else if(vanhocRadioButton.isSelected())
    			category="văn học";
    		else if(ngontinhRadioButton.isSelected())
    			category="ngôn tình";
    		else if(thieunhiRadioButton.isSelected())
    			category="thiếu nhi";
    		else if(kinhteRadioButton.isSelected())
    			category="kinh tế";
    		else 
    			category="giáo trình";
    		
   		
    		BookIn bookin =new BookIn();
    		bookin.setId(idTextField.getText());
    		bookin.setName(nameTextField.getText());
    		bookin.setAuthor(authorTextField.getText());
    		bookin.setPublisher(publisherTextField.getText());
    		bookin.setYear(year);
    		bookin.setCategory(category);
    		bookin.setNumber((int)numberSpinner.getValue());
    		bookin.setCost((int)costSpinner.getValue());
   	        b.addBookIn(bookin);
    		JFrame frame=new AdminFrame(indexUser);
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
	        this.dispose();
    	}
    }                                             

 
    private javax.swing.JTextField authorTextField;
    private javax.swing.JButton backButton1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton confirmButton;
    private javax.swing.JSpinner costSpinner;
    private javax.swing.JComboBox<String> dayComboBox;
    private javax.swing.JRadioButton giaotrinhRadioButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton kinhteRadioButton;
    private javax.swing.JRadioButton lichsuRadioButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JRadioButton ngontinhRadioButton;
    private javax.swing.JSpinner numberSpinner;
    private javax.swing.JRadioButton phapluatRadioButton;
    private javax.swing.JTextField publisherTextField;
    private javax.swing.JRadioButton tamliRadioButton;
    private javax.swing.JRadioButton thieunhiRadioButton;
    private javax.swing.JRadioButton vanhocRadioButton;
    private javax.swing.JComboBox<String> yearComboBox;
}