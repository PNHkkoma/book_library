/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFrame;

import manage.*;

public class AdminFrame extends javax.swing.JFrame {
	List_User a;
	List_BookIn b;
	List_BookOut c;
	List_BookHistory d;
//	Regulations regulations;
	int indexUser;
	DefaultTableModel bi_TableModel;
	DefaultTableModel bo_TableModel;
	DefaultTableModel bh_TableModel;
    
	//hàm dựng
    public AdminFrame(int indexUser) {
    	a=new List_User();
    	b=new List_BookIn();
    	c=new List_BookOut();
    	d=new List_BookHistory();
//    	regulations=new Regulations();
    	this.indexUser=indexUser;
        initComponents();
        SetPopUp();
        SetTable();
        SetInfor();
        
    }
    //thêm popup vào bảng
    public void SetPopUp() {
    	bookInTable.setComponentPopupMenu(popUp);
        
	}
    //truyền dữ liệu vào bảng
    public void SetTable() {
    	//tạo model mới và vô hiệu hóa edit
		bi_TableModel=new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		//áp model vừa tạo vào bảng sách trong thư viện
		bookInTable.setModel(bi_TableModel);
		
		//thêm cột tương ứng
		bi_TableModel.addColumn("ID");
		bi_TableModel.addColumn("Tên");
		bi_TableModel.addColumn("Tác Giả");
		bi_TableModel.addColumn("NXB");
		bi_TableModel.addColumn("Năm phát hành");
		bi_TableModel.addColumn("Thể Loại");
		bi_TableModel.addColumn("Số Lượng");
		bi_TableModel.addColumn("Giá");
		
		//lấy dữ liệu từ database và truyền vào 1 lstBI 
		ArrayList<BookIn> lstBI=b.getAllBookIn();
		
		//truyền dữ liệu vào bảng qua hàm setdata
		SetDataBI(lstBI);
		
		//tương tự cho sách ngoài thư viện
		bo_TableModel=new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		bookOutTable.setModel(bo_TableModel);
		
		bo_TableModel.addColumn("ID");
		bo_TableModel.addColumn("Tên");
		bo_TableModel.addColumn("Tác Giả");
		bo_TableModel.addColumn("NXB");
		bo_TableModel.addColumn("Năm phát hành");
		bo_TableModel.addColumn("Người mượn");
		bo_TableModel.addColumn("Ngày mượn");
		bo_TableModel.addColumn("Ngày phải trả");
		
		ArrayList<BookOut> lstBO=c.getAllBookOut();
		
		SetDataBO(lstBO);
		
		//tương tự cho lịch sử mượn sách
		bh_TableModel=new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		bookHistoryTable.setModel(bh_TableModel);
		
		bh_TableModel.addColumn("ID");
		bh_TableModel.addColumn("Tên");
		bh_TableModel.addColumn("Tác Giả");
		bh_TableModel.addColumn("NXB");
		bh_TableModel.addColumn("Năm phát hành");
		bh_TableModel.addColumn("Người mượn");
		bh_TableModel.addColumn("Ngày mượn");
		bh_TableModel.addColumn("Ngày trả");
		bh_TableModel.addColumn("Phí");
		
		ArrayList<BookHistory> lstBH=d.getAllBookHistory();
		
		SetDataBH(lstBH);
	}
    //Hiện thông tin cơ bản người dùng: tên ID và quy định
    public void SetInfor() {
		ArrayList<User> lstUser=a.getAllUser();
		nameUserLabel.setText(lstUser.get(indexUser).getName());
		idUserLabel.setText(lstUser.get(indexUser).getId());
//		feeButton.setText("Phí: "+String.valueOf(regulations.getFee()));
//		countButton.setText("Số sách được mượn: "+String.valueOf(regulations.getCount()));
	}
    //lấy dữ liệu từ 1 arrlist truyền vào bảng sách trong thư viện
    public void SetDataBI(ArrayList<BookIn> lstBI) {
    	for(BookIn bookin:lstBI) {
			bi_TableModel.addRow(new Object[] {bookin.getId(),bookin.getName(),bookin.getAuthor(),bookin.getPublisher()
					,bookin.getYear(),bookin.getCategory(),bookin.getNumber(),bookin.getCost()});
    	}
	}
    //lấy dữ liệu từ 1 arrlist truyền vào bảng sách ngoài thư viện
    public void SetDataBO(ArrayList<BookOut> lstBO) {
    	for(BookOut bookout :lstBO) {
			Date datein=new Date(bookout.getDateIn().getTime());
			bo_TableModel.addRow(new Object[] {bookout.getId(),bookout.getName(),bookout.getAuthor(),bookout.getPublisher(),
					bookout.getYear(),bookout.getUserName(),bookout.getDateOut(),datein});
		}
	}
    public void SetDataBH(ArrayList<BookHistory> lstBH) {
    	for(BookHistory bookhistory:lstBH) {
			bh_TableModel.addRow(new Object[] {bookhistory.getId(),bookhistory.getName(),bookhistory.getAuthor(),bookhistory.getPublisher(),
					bookhistory.getYear(),bookhistory.getUserName(),bookhistory.getDateOut(),bookhistory.getDateReturn(),bookhistory.getFee()});
    	}
	}

     // tạo giao diện set các thông số vị trí, kích cỡ, liên kết, add action, thay phông chữ,...     
    private void initComponents() {
    	   buttonGroup1 = new javax.swing.ButtonGroup();
           popUp = new javax.swing.JPopupMenu();
           editMenu = new javax.swing.JMenuItem();
           deleteMenu = new javax.swing.JMenuItem();
           jPanel1 = new javax.swing.JPanel();
           jTabbedPane1 = new javax.swing.JTabbedPane();
           jScrollPane2 = new javax.swing.JScrollPane();
           bookInTable = new javax.swing.JTable();
           jScrollPane4 = new javax.swing.JScrollPane();
           bookOutTable = new javax.swing.JTable();
           jScrollPane5 = new javax.swing.JScrollPane();
           bookHistoryTable = new javax.swing.JTable();
           idRadioBT = new javax.swing.JRadioButton();
           nameRadioBT = new javax.swing.JRadioButton();
           authorRadioBT = new javax.swing.JRadioButton();
           publisherRadioBT = new javax.swing.JRadioButton();
           categoryRadioBT = new javax.swing.JRadioButton();
           searchTextfield = new javax.swing.JTextField();
           searchButton = new javax.swing.JButton();
           addButton = new javax.swing.JButton();
           backButton = new javax.swing.JButton();
           refreshButton = new javax.swing.JButton();
           jLabel1 = new javax.swing.JLabel();
           jLabel2 = new javax.swing.JLabel();
           in4Button = new javax.swing.JButton();
           nameUserLabel = new javax.swing.JLabel();
           idUserLabel = new javax.swing.JLabel();
           jLabel5 = new javax.swing.JLabel();
           analysisButton = new javax.swing.JButton();

           editMenu.setText("sửa");
           editMenu.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   editMenuActionPerformed(evt);
               }
           });
           popUp.add(editMenu);

           deleteMenu.setText("xóa");
           deleteMenu.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   deleteMenuActionPerformed(evt);
               }
           });
           popUp.add(deleteMenu);

           setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
           setTitle("Admin ");
           setBackground(new java.awt.Color(255, 255, 255));
           setIconImage(getIconImage());
           setSize(new java.awt.Dimension(1300, 700));

           jPanel1.setBackground(new java.awt.Color(204, 255, 255));

           jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
           jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
               public void stateChanged(javax.swing.event.ChangeEvent evt) {
                   jTabbedPane1StateChanged(evt);
               }
           });

           bookInTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
           bookInTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           bookInTable.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                   {},
                   {},
                   {},
                   {}
               },
               new String [] {

               }
           ));
           bookInTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
           bookInTable.setGridColor(new java.awt.Color(255, 51, 51));
           bookInTable.setRowHeight(25);
           bookInTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
           bookInTable.setShowGrid(true);
           jScrollPane2.setViewportView(bookInTable);

           jTabbedPane1.addTab("Sách trong thư viện", jScrollPane2);

           bookOutTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 102)));
           bookOutTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           bookOutTable.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {}
               },
               new String [] {

               }
           ));
           bookOutTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
           bookOutTable.setGridColor(new java.awt.Color(255, 0, 102));
           bookOutTable.setRowHeight(25);
           bookOutTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
           bookOutTable.setShowGrid(true);
           jScrollPane4.setViewportView(bookOutTable);

           jTabbedPane1.addTab("Sách cho mượn", jScrollPane4);

           bookHistoryTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 102)));
           bookHistoryTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           bookHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {},
                   {}
               },
               new String [] {

               }
           ));
           bookHistoryTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
           bookHistoryTable.setGridColor(new java.awt.Color(255, 0, 102));
           bookHistoryTable.setRowHeight(25);
           bookHistoryTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
           bookHistoryTable.setShowGrid(true);
           jScrollPane5.setViewportView(bookHistoryTable);

           jTabbedPane1.addTab("Sách cho mượn", jScrollPane5);

           buttonGroup1.add(idRadioBT);
           idRadioBT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           idRadioBT.setSelected(true);
           idRadioBT.setText("ID");
           idRadioBT.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   idRadioBTActionPerformed(evt);
               }
           });

           buttonGroup1.add(nameRadioBT);
           nameRadioBT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           nameRadioBT.setText("Tên");
           nameRadioBT.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   nameRadioBTActionPerformed(evt);
               }
           });

           buttonGroup1.add(authorRadioBT);
           authorRadioBT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           authorRadioBT.setText("Tác giả");
           authorRadioBT.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   authorRadioBTActionPerformed(evt);
               }
           });

           buttonGroup1.add(publisherRadioBT);
           publisherRadioBT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           publisherRadioBT.setText("Nhà xuất bản");
           publisherRadioBT.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   publisherRadioBTActionPerformed(evt);
               }
           });

           buttonGroup1.add(categoryRadioBT);
           categoryRadioBT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           categoryRadioBT.setText("Thể loại");
           categoryRadioBT.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   categoryRadioBTActionPerformed(evt);
               }
           });

           searchTextfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           searchTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyReleased(java.awt.event.KeyEvent evt) {
                   searchTextfieldKeyReleased(evt);
               }
           });

           searchButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           searchButton.setText("Tìm kiếm");

           addButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           addButton.setText("Thêm mới");
           addButton.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   addButtonActionPerformed(evt);
               }
           });

           backButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           backButton.setText("Đăng xuất");
           backButton.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   backButtonActionPerformed(evt);
               }
           });

           refreshButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           refreshButton.setText("Làm mới");
           refreshButton.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   refreshButtonActionPerformed(evt);
               }
           });

           jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
           jLabel1.setText("Tên");

           jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
           jLabel2.setText("ID");

           in4Button.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           in4Button.setText("Thông tin");
           in4Button.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   in4ButtonActionPerformed(evt);
               }
           });

           nameUserLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

           idUserLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

           jLabel5.setFont(new java.awt.Font("SVN-The Voice", 0, 72)); // NOI18N
           jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
           jLabel5.setText("Admin");

           analysisButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
           analysisButton.setText("Thống kê");
           analysisButton.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   analysisButtonActionPerformed(evt);
               }
           });

           javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
           jPanel1.setLayout(jPanel1Layout);
           jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jTabbedPane1)
               .addGroup(jPanel1Layout.createSequentialGroup()
                   .addGap(18, 18, 18)
                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(jPanel1Layout.createSequentialGroup()
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                               .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                               .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addGroup(jPanel1Layout.createSequentialGroup()
                                   .addGap(18, 18, 18)
                                   .addComponent(nameUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                   .addGap(18, 18, 18)
                                   .addComponent(idUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                       .addGroup(jPanel1Layout.createSequentialGroup()
                           .addGap(52, 52, 52)
                           .addComponent(in4Button)
                           .addGap(38, 38, 38)
                           .addComponent(analysisButton)))
                   .addGap(34, 34, 34)
                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(jPanel1Layout.createSequentialGroup()
                           .addGap(144, 144, 144)
                           .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                       .addGroup(jPanel1Layout.createSequentialGroup()
                           .addGap(63, 63, 63)
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addComponent(searchTextfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addGroup(jPanel1Layout.createSequentialGroup()
                                   .addComponent(idRadioBT)
                                   .addGap(18, 18, 18)
                                   .addComponent(nameRadioBT)
                                   .addGap(18, 18, 18)
                                   .addComponent(authorRadioBT)
                                   .addGap(18, 18, 18)
                                   .addComponent(publisherRadioBT)
                                   .addGap(18, 18, 18)
                                   .addComponent(categoryRadioBT)))
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                               .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                               .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGap(18, 18, 18)
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGap(137, 137, 137))))
           );
           jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                       .addGroup(jPanel1Layout.createSequentialGroup()
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addGroup(jPanel1Layout.createSequentialGroup()
                                   .addGap(58, 58, 58)
                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                       .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                       .addComponent(nameUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                       .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                       .addComponent(idUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                   .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addComponent(searchTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addGroup(jPanel1Layout.createSequentialGroup()
                                   .addGap(17, 17, 17)
                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                       .addComponent(idRadioBT)
                                       .addComponent(nameRadioBT)
                                       .addComponent(authorRadioBT)
                                       .addComponent(publisherRadioBT)
                                       .addComponent(categoryRadioBT)))
                               .addGroup(jPanel1Layout.createSequentialGroup()
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                       .addComponent(in4Button, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                       .addComponent(analysisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                       .addGroup(jPanel1Layout.createSequentialGroup()
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                               .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGap(8, 8, 8)
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                               .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGap(1, 1, 1)))
                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                   .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addGap(15, 15, 15))
           );

           javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
           getContentPane().setLayout(layout);
           layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
           );
           layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
           );

           pack();
    }                   
    
    //thay đổi thuộc tính xắp xếp và tìm kiếm cho các bảng
    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {                                          
        if(jTabbedPane1.getSelectedIndex()==0)
        	categoryRadioBT.setText("Thể loại");
        else 
        	categoryRadioBT.setText("Người mượn");
        
    }                                         
    
    //thêm mới sách	
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        JFrame frame=new AddBookFrame(indexUser);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.dispose();
    }                                          
    //tìm kiếm sách theo id,tên,NXB,thể loại,tác giả và sắp xếp 
    private void searchTextfieldKeyReleased(java.awt.event.KeyEvent evt) {                                            
    	if(idRadioBT.isSelected()) {
    		ArrayList<BookIn> lstBI=b.search_book_ID(searchTextfield.getText());
	        b.SortByID(lstBI);
	        bi_TableModel.setRowCount(0);
	        SetDataBI(lstBI);
	        
	        ArrayList<BookOut> lstBO=c.search_book_ID(searchTextfield.getText());
	        c.SortByID(lstBO);
	        bo_TableModel.setRowCount(0);
	        SetDataBO(lstBO);
	        
	        ArrayList<BookHistory> lstBH=d.search_book_ID(searchTextfield.getText());
	        d.SortByID(lstBH);
	        bh_TableModel.setRowCount(0);
	        SetDataBH(lstBH);
    	}else if(nameRadioBT.isSelected()) {
    		ArrayList<BookIn> lstBI=b.search_book_Name(searchTextfield.getText());
            b.SortByName(lstBI);
            bi_TableModel.setRowCount(0);
            SetDataBI(lstBI);
            
            ArrayList<BookOut> lstBO=c.search_book_Name(searchTextfield.getText());
            c.SortByName(lstBO);
            bo_TableModel.setRowCount(0);
            SetDataBO(c.getAllBookOut());
            
            ArrayList<BookHistory> lstBH=d.search_book_Name(searchTextfield.getText());
	        d.SortByName(lstBH);
	        bh_TableModel.setRowCount(0);
	        SetDataBH(lstBH);
    	}else if(authorRadioBT.isSelected()) {
    		ArrayList<BookIn> lstBI=b.search_book_Author(searchTextfield.getText());
            b.SortByAuthor(lstBI);
            bi_TableModel.setRowCount(0);
            SetDataBI(lstBI);
            
            ArrayList<BookOut> lstBO=c.search_book_Author(searchTextfield.getText());
            c.SortByAuthor(lstBO);
            bo_TableModel.setRowCount(0);
            SetDataBO(c.getAllBookOut());
            
            ArrayList<BookHistory> lstBH=d.search_book_Author(searchTextfield.getText());
	        d.SortByAuthor(lstBH);
	        bh_TableModel.setRowCount(0);
	        SetDataBH(lstBH);
    	}else if(publisherRadioBT.isSelected()) {
    		ArrayList<BookIn> lstBI=b.search_book_Publis(searchTextfield.getText());
            b.SortByPublisher(lstBI);
            bi_TableModel.setRowCount(0);
            SetDataBI(lstBI);
            
            ArrayList<BookOut> lstBO=c.search_book_Publis(searchTextfield.getText());
            c.SortByPublisher(lstBO);
            bo_TableModel.setRowCount(0);
            SetDataBO(c.getAllBookOut());
            
            ArrayList<BookHistory> lstBH=d.search_book_Publis(searchTextfield.getText());
	        d.SortByPublisher(lstBH);
	        bh_TableModel.setRowCount(0);
	        SetDataBH(lstBH);
    	}else {
    		ArrayList<BookIn> lstBI=b.search_book_Category(searchTextfield.getText());
            b.SortByCategory(lstBI);
            bi_TableModel.setRowCount(0);
            SetDataBI(lstBI);
            
            ArrayList<BookOut> lstBO=c.search_book_UserName(searchTextfield.getText());
            c.SortByUserName(lstBO);
            bo_TableModel.setRowCount(0);
            SetDataBO(c.getAllBookOut());
            
            ArrayList<BookHistory> lstBH=d.search_book_UserName(searchTextfield.getText());
	        d.SortByUserName(lstBH);
	        bh_TableModel.setRowCount(0);
	        SetDataBH(lstBH);
   	}
    	
    }                              
    //sắp xếp theo id
    private void idRadioBTActionPerformed(java.awt.event.ActionEvent evt) {
    	
        ArrayList<BookIn> lstBI=b.search_book_ID(searchTextfield.getText());
        b.SortByID(lstBI);
        bi_TableModel.setRowCount(0);
        SetDataBI(lstBI);
        
        ArrayList<BookOut> lstBO=c.search_book_ID(searchTextfield.getText());
        c.SortByID(lstBO);
        bo_TableModel.setRowCount(0);
        SetDataBO(lstBO);
        
        ArrayList<BookHistory> lstBH=d.search_book_ID(searchTextfield.getText());
        d.SortByID(lstBH);
        bh_TableModel.setRowCount(0);
        SetDataBH(lstBH);
    }                                         
    //sắp xếp theo tên
    private void nameRadioBTActionPerformed(java.awt.event.ActionEvent evt) { 
    	
    	ArrayList<BookIn> lstBI=b.search_book_Name(searchTextfield.getText());
        b.SortByName(lstBI);
        bi_TableModel.setRowCount(0);
        SetDataBI(lstBI);
        
        ArrayList<BookOut> lstBO=c.search_book_Name(searchTextfield.getText());
        c.SortByName(lstBO);
        bo_TableModel.setRowCount(0);
        SetDataBO(lstBO);
        
        ArrayList<BookHistory> lstBH=d.search_book_Name(searchTextfield.getText());
        d.SortByName(lstBH);
        bh_TableModel.setRowCount(0);
        SetDataBH(lstBH);
    }                                           
    //sắp xếp theo thể loại với sách trong thư viện và người mượn với sách ngoài thư viện
    private void categoryRadioBTActionPerformed(java.awt.event.ActionEvent evt) { 
    	                                             
    	ArrayList<BookIn> lstBI=b.search_book_Category(searchTextfield.getText());
        b.SortByCategory(lstBI);
        bi_TableModel.setRowCount(0);
        SetDataBI(lstBI);
        
        ArrayList<BookOut> lstBO=c.search_book_UserName(searchTextfield.getText());
        c.SortByUserName(lstBO);
        bo_TableModel.setRowCount(0);
        SetDataBO(lstBO);
        
        ArrayList<BookHistory> lstBH=d.search_book_UserName(searchTextfield.getText());
        d.SortByUserName(lstBH);
        bh_TableModel.setRowCount(0);
        SetDataBH(lstBH);
    } 
    //sắp xếp theo tác giả
    private void authorRadioBTActionPerformed(java.awt.event.ActionEvent evt) { 
    	
    	ArrayList<BookIn> lstBI=b.search_book_Author(searchTextfield.getText());
        b.SortByAuthor(lstBI);
        bi_TableModel.setRowCount(0);
        SetDataBI(lstBI);
        
        ArrayList<BookOut> lstBO=c.search_book_Author(searchTextfield.getText());
        c.SortByAuthor(lstBO);
        bo_TableModel.setRowCount(0);
        SetDataBO(lstBO);
        
        ArrayList<BookHistory> lstBH=d.search_book_Author(searchTextfield.getText());
        d.SortByAuthor(lstBH);
        bh_TableModel.setRowCount(0);
        SetDataBH(lstBH);
    }                                             
    //sắp xếp theo nhà xuất bản
    private void publisherRadioBTActionPerformed(java.awt.event.ActionEvent evt) {   
    	
    	ArrayList<BookIn> lstBI=b.search_book_Publis(searchTextfield.getText());
        b.SortByPublisher(lstBI);
        bi_TableModel.setRowCount(0);
        SetDataBI(lstBI);
        
        ArrayList<BookOut> lstBO=c.search_book_Publis(searchTextfield.getText());
        c.SortByPublisher(lstBO);
        bo_TableModel.setRowCount(0);
        SetDataBO(lstBO);
        
        ArrayList<BookHistory> lstBH=d.search_book_Publis(searchTextfield.getText());
        d.SortByPublisher(lstBH);
        bh_TableModel.setRowCount(0);
        SetDataBH(lstBH);
    }                            
    //xóa sách
    private void deleteMenuActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	int row=bookInTable.getSelectedRow();
    	if(row==-1)
    		JOptionPane.showMessageDialog(this,"Vui lòng chọn sách trước"
					, "cảnh báo", JOptionPane.ERROR_MESSAGE);
    	else {
    		int confirm=JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn xóa\nTên: "+String.valueOf(bookInTable.getValueAt(row, 1))
    		+"\nTác giả: "+String.valueOf(bookInTable.getValueAt(row, 2)));
			if(confirm==JOptionPane.YES_OPTION) {
	    		String id=String.valueOf(bookInTable.getValueAt(row, 0));
		        b.deleteBookIn(id);
			}
    	}
    }                                          
    //đăng xuất
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
           JFrame frame=new Login();
           frame.setVisible(true);
           frame.setLocationRelativeTo(null);
           this.dispose();
    }                                          
    //làm mới dữ liệu
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {  
    	searchTextfield.setText("");
    	idRadioBT.setSelected(true);
    	
        bi_TableModel.setRowCount(0);
        SetDataBI(b.getAllBookIn());
        
        bo_TableModel.setRowCount(0);
        SetDataBO(c.getAllBookOut());
    } 
    //xem thông tin người dùng và chỉnh sửa nếu muuốn
    private void in4ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	JFrame frame=new InforFrame(indexUser);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.dispose();
    }                                         

    //xem thống kê dữ liệu
    private void analysisButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	JFrame frame=new Chart();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
       
    }                                              
     
    //sửa sách
    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {     
    	int row=bookInTable.getSelectedRow();
    	if(row==-1)
    		JOptionPane.showMessageDialog(this,"Vui lòng chọn sách trước"
					, "cảnh báo", JOptionPane.ERROR_MESSAGE);
    	else {
    		String id=String.valueOf(bookInTable.getValueAt(row, 0));
	        JFrame frame=new EdittFrame(indexUser, id);
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
	        this.dispose();
    	}
    }  
   
    
                    
    private javax.swing.JButton addButton;
    private javax.swing.JButton analysisButton;
    private javax.swing.JRadioButton authorRadioBT;
    private javax.swing.JButton backButton;
    private javax.swing.JTable bookHistoryTable;
    private javax.swing.JTable bookInTable;
    private javax.swing.JTable bookOutTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton categoryRadioBT;
    
    private javax.swing.JMenuItem deleteMenu;
    private javax.swing.JMenuItem editMenu;
    
    private javax.swing.JRadioButton idRadioBT;
    private javax.swing.JLabel idUserLabel;
    private javax.swing.JButton in4Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton nameRadioBT;
    private javax.swing.JLabel nameUserLabel;
    private javax.swing.JPopupMenu popUp;
    private javax.swing.JRadioButton publisherRadioBT;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextfield;
}
