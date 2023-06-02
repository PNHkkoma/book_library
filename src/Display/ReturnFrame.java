package Display;

import java.util.ArrayList;
import java.util.Date;


import manage.BookHistory;
import manage.BookIn;
import manage.BookOut;
import manage.List_BookHistory;
import manage.List_BookIn;
import manage.List_BookOut;
import manage.List_User;
import manage.User;

public class ReturnFrame extends javax.swing.JFrame {
	List_User a;
	List_BookIn b;
	List_BookOut c;
	List_BookHistory d;
	
	BookOut bookout;
	BookHistory bookhistory;
	int indexUser;
	
    public ReturnFrame(BookOut bookout,int indexUser) {
    	a=new List_User();
    	b=new List_BookIn();
    	c=new List_BookOut();
    	d=new List_BookHistory();
    	this.indexUser=indexUser;
    	this.bookout=bookout;
    	bookhistory=new BookHistory();
    	
        initComponents();
        SetData();
       
    }
    
    public void SetData() {
		
		//tạo ra 1 bookout	
    	bookhistory.setId(bookout.getId());
    	bookhistory.setName(bookout.getName());
    	bookhistory.setAuthor(bookout.getAuthor());
    	bookhistory.setPublisher(bookout.getPublisher());
    	bookhistory.setYear(bookout.getYear());
    	bookhistory.setCategory(bookout.getCategory());
    	bookhistory.setUserName(bookout.getUserName());
    	bookhistory.setNumber(1);
    	bookhistory.setCost(bookout.getCost());
    	bookhistory.setDateOut(bookout.getDateOut());
		Date now=new Date();
		Date datereturn=new Date(now.getYear(), now.getMonth(), now.getDate());
		bookhistory.setDateReturn(datereturn);
		//đặt các giá trị hiển thị ra màn hình
		_idUserLabel.setText(a.getAllUser().get(indexUser).getId());
		_nameUserLabel.setText(a.getAllUser().get(indexUser).getName());
		_idBookLabel.setText(bookout.getId());
		_nameBookLabel.setText(bookout.getName());
		_dateoutLabel.setText(String.valueOf(bookout.getDateOut().getDate())+"/"+String.valueOf(bookout.getDateOut().getMonth()+1)
										+"/"+String.valueOf(bookout.getDateOut().getYear()+1900));
		
		String date=String.valueOf(now.getDate())+"/"+String.valueOf(now.getMonth()+1)+"/"+String.valueOf(now.getYear()+1900);
		_datereturnLabel.setText(date);
		feeLable.setText(String.valueOf(bookhistory.getFee()));
		
	}
    
                   
    private void initComponents() {

    	jPanel1 = new javax.swing.JPanel();
        _idUserLabel = new javax.swing.JLabel();
        _nameUserLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        _datereturnLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        dateoutLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        feeLable = new javax.swing.JLabel();
        datereturnLabel = new javax.swing.JLabel();
        _dateoutLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        _nameBookLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        _idBookLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 530));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        _idUserLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        _nameUserLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        idLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idLabel.setText("Mã ID:");

        _datereturnLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        confirmButton.setText("Xác nhận");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        dateoutLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dateoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateoutLabel.setText("Ngày trả:");

        nameLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Khách hàng:");

        titleLabel.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Phiếu trả");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Phí:");

        feeLable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        datereturnLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        datereturnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datereturnLabel.setText("Ngày mượn:");

        _dateoutLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tên sách");

        _nameBookLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Mã ID sách");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        _idBookLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        backButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        backButton.setText("Quay lại");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(_nameUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(feeLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dateoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(_datereturnLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(datereturnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(_dateoutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(idLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(_idUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(_nameBookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(_idBookLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(_nameUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_idUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(_nameBookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(_idBookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datereturnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_dateoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_datereturnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(feeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        pack();
    }                       

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
       c.deleteBookOut(bookout.getId(), bookout.getUserName());
       User user=a.getAllUser().get(indexUser);
       user.setCount(user.getCount()-1);
       a.updateUser(user);
       //kiểm tra trong danh sách bookin có cuốn sách đó không
       boolean check=false;
       for(BookIn bookIn:b.getAllBookIn())
    	   if(bookout.getId().equals(bookIn.getId())) {
    		   check=true;
    		   bookIn.setNumber(bookIn.getNumber()+1);
    		   b.updateBookIn(bookIn);
    		   break;
    	   }
       //nếu trong kho không có tạo ra 1 quyển sách mới
    	if(!check) {
    		// tạo ra 1 biến bookin
    		BookIn bookin=new BookIn();
        	bookin.setId(bookout.getId());
        	bookin.setName(bookout.getName());
        	bookin.setAuthor(bookout.getAuthor());
        	bookin.setPublisher(bookout.getPublisher());
        	bookin.setYear(bookout.getYear());
        	bookin.setCategory(bookout.getCategory());
        	bookin.setNumber(1);
        	bookin.setCost(bookout.getCost());
        	b.addBookIn(bookin);
    	}
    	d.addBookHistory(bookhistory);
    	this.dispose();
    }                                             
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }      
    
   

    private javax.swing.JLabel _dateoutLabel;
    private javax.swing.JLabel _datereturnLabel;
    private javax.swing.JLabel _idBookLabel;
    private javax.swing.JLabel _idUserLabel;
    private javax.swing.JLabel _nameBookLabel;
    private javax.swing.JLabel _nameUserLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel dateoutLabel;
    private javax.swing.JLabel datereturnLabel;
    private javax.swing.JLabel feeLable;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel titleLabel; 
}
