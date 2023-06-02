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
import javax.swing.table.DefaultTableModel;


import manage.*;

/**
 *
 * @author admin
 */
public class BillFrame extends javax.swing.JFrame {
	List_User a;
	Bill d;
	int indexUser;
	DefaultTableModel bill_TableModel;
	
    public BillFrame(ArrayList<BookIn> lstBI,int indexUser) {
    	this.indexUser=indexUser;
    	a=new List_User();
        d=new Bill(lstBI, indexUser);
        initComponents();
        SetTable();
        SetInfo();
        SetPopUp();
    }
    // tạo các cột table rồi thêm dữ liệu vào
    public void SetTable() {
    	bill_TableModel=new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		billTable.setModel(bill_TableModel);
		bill_TableModel.addColumn("ID");
		bill_TableModel.addColumn("Tên");
		bill_TableModel.addColumn("Tác Giả");
		bill_TableModel.addColumn("NXB");
		
		ArrayList<BookOut> lstBO=d.getLstBO();
		
		SetData(lstBO);
	}

    public void SetData(ArrayList<BookOut> lstBO) {
    	for(BookOut bookout :lstBO) {
			bill_TableModel.addRow(new Object[] {bookout.getId(),bookout.getName(),bookout.getAuthor(),
					bookout.getPublisher()});
		}
	}
    // điền thông tin người dùng
    public void SetInfo() {
		_idLabel.setText(a.getAllUser().get(indexUser).getId());
		_nameLabel.setText(a.getAllUser().get(indexUser).getName());
		Date now=new Date();
		String date=String.valueOf(now.getDate())+"/"+String.valueOf(now.getMonth()+1)+"/"+String.valueOf(now.getYear()+1900);
		_dateLabel.setText(date);
	}
    // thêm popup
    public void SetPopUp() {
		billTable.setComponentPopupMenu(jPopupMenu1);
	}

    //giao diện                      
    private void initComponents() {

    	jPopupMenu1 = new javax.swing.JPopupMenu();
        deleteItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        _idLabel = new javax.swing.JLabel();
        _nameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        idLabel = new javax.swing.JLabel();
        _dateLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        deleteItem.setText("xóa");
        deleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(deleteItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 300));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        _idLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        _nameLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        billTable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        billTable.setGridColor(new java.awt.Color(255, 51, 102));
        billTable.setOpaque(false);
        billTable.setSelectionBackground(new java.awt.Color(51, 153, 255));
        billTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        billTable.setShowGrid(true);
        jScrollPane1.setViewportView(billTable);

        idLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idLabel.setText("Mã ID:");

        _dateLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        confirmButton.setText("Xác nhận");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        dateLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Ngày mượn:");

        nameLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Khách hàng:");

        titleLabel.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Phiếu mượn");

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(_dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(_dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
    //action ấn nút xác nhận
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
       d.Complete();
       JFrame frame=new UserFrame(indexUser);	
       frame.setVisible(true);
       frame.setLocationRelativeTo(null);
       this.dispose(); 
       
    }    
    //action của popup xóa
    private void deleteItemActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	int row=billTable.getSelectedRow();
    	if(row==-1)
    		JOptionPane.showMessageDialog(this,"Vui lòng chọn sách trước"
					, "cảnh báo", JOptionPane.ERROR_MESSAGE);
    	else {
    		int confirm=JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn xóa\nTên: "+String.valueOf(billTable.getValueAt(row, 1))
    		+"\nTác giả: "+String.valueOf(billTable.getValueAt(row, 2)));
			if(confirm==JOptionPane.YES_OPTION) {
	    		String id=String.valueOf(billTable.getValueAt(row, 0));
		        d.Delete(id);
		        bill_TableModel.setRowCount(0);
		        SetData(d.getLstBO());
			}
    	}
        
    }    
    //action nút back
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	 JFrame frame=new UserFrame(indexUser,d.getLstBI());	
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
         this.dispose(); 
    }     

    
  
    
    private javax.swing.JLabel _dateLabel;
    private javax.swing.JLabel _idLabel;
    private javax.swing.JLabel _nameLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JTable billTable;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JLabel idLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel titleLabel; 
}
