package Display;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import manage.BookHistory;
import manage.BookHistoryDoc;
import manage.List_BookHistory;


public class Chart extends javax.swing.JFrame {
	List_BookHistory d;
    
    public Chart() {
    	d=new List_BookHistory();
        initComponents();
        
    }


    //set barchart
    public void SetBarChart(int year) {
       	DefaultCategoryDataset dcd=new DefaultCategoryDataset();
       	//biến sô lượng lần mượn sách theo thể loại
       	int countNgonTinh=0;
       	int countLichSu=0;
       	int countTamLi=0;
       	int countThieuNhi=0;
       	int countPhapLuat=0;
       	int countGiaoTrinh=0;
       	int countVanHoc=0;
       	int countKinhTe=0;
       	for(BookHistory bookHistory:d.getAllBookHistory()) {
       		if(bookHistory.getDateOut().getYear()+1900==year)
	       		switch (bookHistory.getCategory()) {
				case "ngôn tình":
					countNgonTinh++;
					break;
				case "lịch sử":
					countLichSu++;
					break;
				case "tâm lí":
					countTamLi++;
					break;
				case "thiếu nhi":
					countThieuNhi++;
					break;
				case "pháp luật":
					countPhapLuat++;
					break;
				case "giáo trình":
					countGiaoTrinh++;
					break;
				case "văn học":
					countVanHoc++;
					break;
				case "kinh tế":
					countKinhTe++;
					break;
	       		}
       	}
       	//set giá trị
   		dcd.setValue(countNgonTinh, "Số lượng", "Ngôn tình");
   		dcd.setValue(countLichSu, "Số lượng", "Lịch sử");
   		dcd.setValue(countTamLi, "Số lượng", "Tâm lí");
   		dcd.setValue(countThieuNhi, "Số lượng", "Thiếu nhi");
   		dcd.setValue(countPhapLuat, "Số lượng", "Pháp luật");
   		dcd.setValue(countGiaoTrinh, "Số lượng", "Giáo trình");
   		dcd.setValue(countVanHoc, "Số lượng", "Văn học");
   		dcd.setValue(countKinhTe, "Số lượng", "Kinh tế");
   		
   		
   		//tạo biểu đồ
   		JFreeChart chart=ChartFactory.createBarChart("Thống kê","Thể loại","Số lần mượn",dcd,PlotOrientation.VERTICAL,true,true,true);
   		CategoryPlot plot=chart.getCategoryPlot();
   		plot.setRangeGridlinePaint(Color.BLACK);
   		plot.setBackgroundPaint(Color.WHITE);
   		
   		//xóa biểu đồ cũ thêm biểu đồ mới
   		chartPanel.removeAll();
   		ChartPanel barchart=new ChartPanel(chart);
   		chartPanel.add(barchart);
   		chartPanel.updateUI();
   		
   	}      
    //set piechart
    public void SetPieChart(int year) {
    	//số ngày quá hạn
    	double outDate=0;
    	//số ngày đúng hạn
    	double onDate=0;
    	for(BookHistory bookHistory:d.getAllBookHistory()) {
    		if(bookHistory.getDateOut().getYear()+1900==year) {
	    		if(bookHistory.getDateIn().getTime()>=bookHistory.getDateReturn().getTime())
	    			onDate++;
	    		else
	    			outDate++;
    		}
    	}
    	//set dữ dữ vào dataset
    	DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Trả sách đúng hạn", onDate);
        dataset.setValue("Trả sách quá hạn", outDate);
        //vẽ biểu đồ
        JFreeChart chart = ChartFactory.createPieChart(
                "Tỉ lệ trả sách đúng hạn và quá hạn", dataset, true, true, true);
        
        chart.getPlot().setBackgroundPaint(Color.white);
      //xóa biểu đồ cũ thêm biểu đồ mới
        chartPanel.removeAll();
        ChartPanel piechart=new ChartPanel(chart);
   		chartPanel.add(piechart);
   		chartPanel.updateUI();
	}
    //setLinechart
    public void SetLineChart(int year) {
    	int countQuy1=0;
    	int countQuy2=0;
    	int countQuy3=0;
    	int countQuy4=0;
    	for(BookHistory bookHistory:d.getAllBookHistory()) {
    		if(bookHistory.getDateOut().getYear()+1900==year&&bookHistory.getDateOut().getMonth()+1<=3)
    			countQuy1++;
    		else if(bookHistory.getDateOut().getYear()+1900==year&&bookHistory.getDateOut().getMonth()+1>=10)
    			countQuy4++;
    		else if(bookHistory.getDateOut().getYear()+1900==year&&bookHistory.getDateOut().getMonth()+1>=4&&bookHistory.getDateOut().getMonth()+1<=6)
    			countQuy2++;
    		else if(bookHistory.getDateOut().getYear()+1900==year&&bookHistory.getDateOut().getMonth()+1>=7&&bookHistory.getDateOut().getMonth()+1<=9)
    			countQuy3++;
    	}
    	//set dữ liệu vào dataset
    	DefaultCategoryDataset dcd=new DefaultCategoryDataset();
    	dcd.setValue(countQuy1,"Số lượng","Quý 1" );
    	dcd.setValue(countQuy2,"Số lượng","Quý 2" );
    	dcd.setValue(countQuy3,"Số lượng","Quý 3" );
    	dcd.setValue(countQuy4,"Số lượng","Quý 4" );
    	
        //vẽ biểu đồ
        JFreeChart chart=ChartFactory.createLineChart("Tổng số sách được mượn theo thời gian","Thời gian","Số lượng", dcd,PlotOrientation.VERTICAL,true,true,false);
   		CategoryPlot plot=chart.getCategoryPlot();
   		plot.setRangeGridlinePaint(Color.BLACK);
   		plot.setBackgroundPaint(Color.WHITE);
   		
   		//xóa biểu đồ cũ thêm biểu đồ mới
   		chartPanel.removeAll();
   		ChartPanel barchart=new ChartPanel(chart);
   		chartPanel.add(barchart);
   		chartPanel.updateUI();
	}
    //giao diện
    private void initComponents() {

    	jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dateReturnButton = new javax.swing.JButton();
        categoryButton = new javax.swing.JButton();
        sumBookOutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox<>();
        chartPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Năm");

        dateReturnButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        dateReturnButton.setText("Trả sách");
        dateReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateReturnButtonActionPerformed(evt);
            }
        });

        categoryButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        categoryButton.setText("Thể loại");
        categoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryButtonActionPerformed(evt);
            }
        });

        sumBookOutButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        sumBookOutButton.setText("Biến Đổi");
        sumBookOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumBookOutButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SVN-Vanilla Daisy Pro", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chart");

        yearComboBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", " " }));

        chartPanel.setBackground(new java.awt.Color(255, 255, 255));
        chartPanel.setLayout(new javax.swing.BoxLayout(chartPanel, javax.swing.BoxLayout.LINE_AXIS));

        backButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        backButton.setText("Quay lại");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(417, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dateReturnButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(categoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sumBookOutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(categoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(dateReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(sumBookOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                      
    
    //thống kê theo tổng số sách mượn các quý
    private void sumBookOutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        int year=Integer.parseInt(String.valueOf(yearComboBox.getSelectedItem()));
        SetLineChart(year);
    }                                                
    //thống kê sách trả đúng hạn hay ko
    private void dateReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    	int year=Integer.parseInt(String.valueOf(yearComboBox.getSelectedItem()));
    	SetPieChart(year);
    }                                                
    //thống kê số lần mượn theo thể loại
    private void categoryButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	int year=Integer.parseInt(String.valueOf(yearComboBox.getSelectedItem()));
    	SetBarChart(year);
    } 
    //action nút back
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }  

    
   

    private javax.swing.JButton backButton;
    private javax.swing.JButton categoryButton;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JButton dateReturnButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton sumBookOutButton;
    private javax.swing.JComboBox<String> yearComboBox;            
}
