/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.event.WindowAdapter;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import manage.BookIn;
import manage.BookOut;
import manage.List_BookIn;
import manage.List_BookOut;
import manage.List_User;

import manage.User;

public class UserFrame extends javax.swing.JFrame {
    int indexUser = -1;
    List_User a;
    List_BookIn b;
    List_BookOut c;
    DefaultTableModel bi_TableModel;
    DefaultTableModel bo_TableModel;
    ArrayList<BookIn> basketBI;

    public UserFrame(int indexUser) {
        a = new List_User();
        b = new List_BookIn();
        c = new List_BookOut();

        this.indexUser = indexUser;
        this.basketBI = new ArrayList<BookIn>();

        initComponents();
        SetPopUp();
        SetTable();
        SetInfor();

    }

    // hàm dựng đặt lại giá trị cho giỏ đựng sách để mượn
    public UserFrame(int indexUser, ArrayList<BookIn> basketBI) {
        a = new List_User();
        b = new List_BookIn();
        c = new List_BookOut();
        this.indexUser = indexUser;
        this.basketBI = basketBI;
        initComponents();
        SetPopUp();
        SetTable();
        SetInfor();
    }

    public void SetPopUp() {
        bookInTable.setComponentPopupMenu(bookInpopup);
        bookOutTable.setComponentPopupMenu(bookOutpopup);

    }

    // Hiện thông tin cơ bản người dùng: tên ID
    public void SetInfor() {
        ArrayList<User> lstUser = a.getAllUser();
        nameUserLabel.setText(lstUser.get(indexUser).getName());
        idUserLabel.setText(lstUser.get(indexUser).getId());
        idRadioBT.setSelected(true);
    }

    // truyền dữ liệu vào bảng
    public void SetTable() {
        // tạo model mới và vô hiệu hóa edit
        bi_TableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        // áp model vừa tạo vào bảng sách trong thư viện
        bookInTable.setModel(bi_TableModel);

        // thêm cột tương ứng
        bi_TableModel.addColumn("ID");
        bi_TableModel.addColumn("Tên");
        bi_TableModel.addColumn("Tác Giả");
        bi_TableModel.addColumn("NXB");
        bi_TableModel.addColumn("Năm phát hành");
        bi_TableModel.addColumn("Thể Loại");
        bi_TableModel.addColumn("Số Lượng");
        bi_TableModel.addColumn("Giá");

        // lấy dữ liệu từ database và truyền vào 1 lstBI
        ArrayList<BookIn> lstBI = b.getAllBookIn();

        // truyền dữ liệu vào bảng qua hàm setdata
        SetDataBI(lstBI);

        // tương tự cho sách ngoài thư viện
        bo_TableModel = new DefaultTableModel() {
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

        System.out.println("=================" + a.getAllUser());
        ArrayList<BookOut> lstBO = c.search_book_UserName(a.getAllUser().get(indexUser).getName());

        SetDataBO(lstBO);
    }

    // lấy dữ liệu từ 1 arrlist truyền vào bảng sách trong thư viện
    public void SetDataBI(ArrayList<BookIn> lstBI) {
        for (BookIn bookin : lstBI) {
            bi_TableModel
                    .addRow(new Object[] { bookin.getId(), bookin.getName(), bookin.getAuthor(), bookin.getPublisher(),
                            bookin.getYear(), bookin.getCategory(), bookin.getNumber(), bookin.getCost() });
        }
    }

    // lấy dữ liệu từ 1 arrlist truyền vào bảng sách ngoài thư viện
    public void SetDataBO(ArrayList<BookOut> lstBO) {
        for (BookOut bookout : lstBO) {
            Date datein = new Date(bookout.getDateIn().getTime());
            bo_TableModel.addRow(
                    new Object[] { bookout.getId(), bookout.getName(), bookout.getAuthor(), bookout.getPublisher(),
                            bookout.getYear(), bookout.getUserName(), bookout.getDateOut(), datein });
        }
    }

    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bookInpopup = new javax.swing.JPopupMenu();
        borrowItem = new javax.swing.JMenuItem();
        bookOutpopup = new javax.swing.JPopupMenu();
        returnItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookInTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        bookOutTable = new javax.swing.JTable();
        idRadioBT = new javax.swing.JRadioButton();
        nameRadioBT = new javax.swing.JRadioButton();
        authorRadioBT = new javax.swing.JRadioButton();
        publisherRadioBT = new javax.swing.JRadioButton();
        categoryRadioBT = new javax.swing.JRadioButton();
        searchTextfield = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        idUserLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameUserLabel = new javax.swing.JLabel();
        in4Button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        payButton = new javax.swing.JButton();

        borrowItem.setText("thêm vào giỏ");
        borrowItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowItemActionPerformed(evt);
            }
        });
        bookInpopup.add(borrowItem);

        returnItem.setText("trả sách");
        returnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnItemActionPerformed(evt);
            }
        });
        bookOutpopup.add(returnItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User");
        setPreferredSize(new java.awt.Dimension(1300, 700));
        setSize(new java.awt.Dimension(1300, 700));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        bookInTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        bookInTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bookInTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        {},
                        {},
                        {},
                        {}
                },
                new String[] {

                }));
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
                new Object[][] {
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
                new String[] {

                }));
        bookOutTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        bookOutTable.setGridColor(new java.awt.Color(255, 0, 102));
        bookOutTable.setRowHeight(25);
        bookOutTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bookOutTable.setShowGrid(true);
        jScrollPane4.setViewportView(bookOutTable);

        jTabbedPane1.addTab("Sách cho mượn", jScrollPane4);

        buttonGroup1.add(idRadioBT);
        idRadioBT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
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

        idUserLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("ID");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Tên");

        nameUserLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        in4Button.setBackground(new java.awt.Color(255, 255, 255));
        in4Button.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        in4Button.setText("Thông tin");
        in4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in4ButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SVN-The Voice", 0, 72)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("User");

        payButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        payButton.setText("Thanh toán");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(27, 27, 27)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(nameUserLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(idUserLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(in4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(idRadioBT,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(nameRadioBT)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(authorRadioBT)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(publisherRadioBT)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(categoryRadioBT))
                                                        .addComponent(searchTextfield,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 529,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(83, 83, 83)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(refreshButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(searchButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 98,
                                                                Short.MAX_VALUE))
                                                .addGap(76, 76, 76)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(payButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 322,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(76, Short.MAX_VALUE))
                        .addComponent(jTabbedPane1));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(searchTextfield)
                                                        .addComponent(payButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(searchButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 40,
                                                                Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(refreshButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(backButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(idRadioBT)
                                                                        .addComponent(nameRadioBT)
                                                                        .addComponent(authorRadioBT)
                                                                        .addComponent(publisherRadioBT)
                                                                        .addComponent(categoryRadioBT))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameUserLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(idUserLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(in4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510,
                                        Short.MAX_VALUE)));

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

    }

    // nút refresh
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchTextfield.setText("");
        idRadioBT.setSelected(true);
        basketBI = new ArrayList<BookIn>();
        bi_TableModel.setRowCount(0);
        SetDataBI(b.getAllBookIn());

        bo_TableModel.setRowCount(0);
        SetDataBO(c.search_book_UserName(a.getAllUser().get(indexUser).getName()));
    }

    private void publisherRadioBTActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<BookIn> lstBI = b.search_book_Publis(searchTextfield.getText());
        b.SortByPublisher(lstBI);
        bi_TableModel.setRowCount(0);
        SetDataBI(lstBI);
    }

    private void categoryRadioBTActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<BookIn> lstBI = b.search_book_Category(searchTextfield.getText());
        b.SortByCategory(lstBI);
        bi_TableModel.setRowCount(0);
        SetDataBI(lstBI);
    }

    private void idRadioBTActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<BookIn> lstBI = b.search_book_ID(searchTextfield.getText());
        b.SortByID(lstBI);
        bi_TableModel.setRowCount(0);
        SetDataBI(lstBI);
    }

    private void nameRadioBTActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<BookIn> lstBI = b.search_book_Name(searchTextfield.getText());
        b.SortByName(lstBI);
        bi_TableModel.setRowCount(0);
        SetDataBI(lstBI);
    }

    private void authorRadioBTActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<BookIn> lstBI = b.search_book_Author(searchTextfield.getText());
        b.SortByAuthor(lstBI);
        bi_TableModel.setRowCount(0);
        SetDataBI(lstBI);
    }

    private void in4ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new InforFrame(indexUser);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.dispose();
    }

    private void searchTextfieldKeyReleased(java.awt.event.KeyEvent evt) {
        if (idRadioBT.isSelected()) {
            ArrayList<BookIn> lstBI = b.search_book_ID(searchTextfield.getText());
            b.SortByID(lstBI);
            bi_TableModel.setRowCount(0);
            SetDataBI(lstBI);

        } else if (nameRadioBT.isSelected()) {
            ArrayList<BookIn> lstBI = b.search_book_Name(searchTextfield.getText());
            b.SortByName(lstBI);
            bi_TableModel.setRowCount(0);
            SetDataBI(lstBI);

        } else if (authorRadioBT.isSelected()) {
            ArrayList<BookIn> lstBI = b.search_book_Author(searchTextfield.getText());
            b.SortByAuthor(lstBI);
            bi_TableModel.setRowCount(0);
            SetDataBI(lstBI);

        } else if (publisherRadioBT.isSelected()) {
            ArrayList<BookIn> lstBI = b.search_book_Publis(searchTextfield.getText());
            b.SortByPublisher(lstBI);
            bi_TableModel.setRowCount(0);
            SetDataBI(lstBI);

        } else {
            ArrayList<BookIn> lstBI = b.search_book_Category(searchTextfield.getText());
            b.SortByCategory(lstBI);
            bi_TableModel.setRowCount(0);
            SetDataBI(lstBI);

        }
    }

    // thêm vào giỏ hàng
    private void borrowItemActionPerformed(java.awt.event.ActionEvent evt) {
        int row = bookInTable.getSelectedRow();
        // nếu chưa chọn sách
        if (row == -1)
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách trước", "cảnh báo", JOptionPane.ERROR_MESSAGE);
        // nếu mượn quá số quyển tối đa
        else if (a.getAllUser().get(indexUser).getCount() + basketBI.size() >= 7)
            JOptionPane.showMessageDialog(this, "Số sách bạn mượn đã tối đa", "cảnh báo", JOptionPane.ERROR_MESSAGE);
        else {
            String id = String.valueOf(bookInTable.getValueAt(row, 0));
            ArrayList<BookOut> lstBO = c.getAllBookOut();
            lstBO = c.search_book_UserName(a.getAllUser().get(indexUser).getName());
            boolean check = true;
            // nếu đã mượn quyển sách đó rồi
            for (BookOut bookOut : lstBO) {
                if (bookOut.getId().equals(id)) {
                    JOptionPane.showMessageDialog(this, "bạn đã mượn quyển sách này", "cảnh báo",
                            JOptionPane.ERROR_MESSAGE);
                    check = false;
                }
            }
            for (BookIn bookIn : basketBI) {
                if (bookIn.getId().equals(id)) {
                    JOptionPane.showMessageDialog(this, "Sách đã có trong giỏ", "cảnh báo", JOptionPane.ERROR_MESSAGE);
                    check = false;
                }
            }
            // nếu thỏa mãn các yêu cầu thì thêm vào giỏ
            if (check) {
                for (BookIn bookin : b.getAllBookIn())
                    if (bookin.getId().equals(id)) {
                        basketBI.add(bookin);
                        break;
                    }
            }
        }
    }

    // trả sách
    private void returnItemActionPerformed(java.awt.event.ActionEvent evt) {
        int row = bookOutTable.getSelectedRow();

        // nếu chưa chọn sách
        if (row == -1)
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách trước", "cảnh báo", JOptionPane.ERROR_MESSAGE);
        else {
            BookOut bookOut = c.search_book_UserName(a.getAllUser().get(indexUser).getName()).get(row);
            JFrame frame = new ReturnFrame(bookOut, indexUser);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }

    }

    // đăng xuất
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new Login();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.dispose();
    }

    // nhận phiếu mượn
    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (basketBI.size() != 0) {
            JFrame frame = new BillFrame(basketBI, indexUser);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            this.dispose();
        }
    }

    private javax.swing.JRadioButton authorRadioBT;
    private javax.swing.JButton backButton;
    private javax.swing.JTable bookInTable;
    private javax.swing.JPopupMenu bookInpopup;
    private javax.swing.JTable bookOutTable;
    private javax.swing.JPopupMenu bookOutpopup;
    private javax.swing.JMenuItem borrowItem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton categoryRadioBT;
    private javax.swing.JRadioButton idRadioBT;
    private javax.swing.JLabel idUserLabel;
    private javax.swing.JButton in4Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton nameRadioBT;
    private javax.swing.JLabel nameUserLabel;
    private javax.swing.JButton payButton;
    private javax.swing.JRadioButton publisherRadioBT;
    private javax.swing.JButton refreshButton;
    private javax.swing.JMenuItem returnItem;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextfield;
}
