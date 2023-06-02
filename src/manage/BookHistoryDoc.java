package manage;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookHistoryDoc {
	
		public ArrayList<BookHistory> getAllBookHistory(){
	        ArrayList<BookHistory> bookhistories=new ArrayList<BookHistory>();
	        Connection connection= ConnectionSQL.getConnection();
	        String sql="SELECT * FROM bookhistory";
	        
	        try {
	            PreparedStatement preparedStatement=connection.prepareCall(sql);
	            ResultSet rs=preparedStatement.executeQuery();
	            
	            while (rs.next()) {
	            	BookHistory bookhistory=new BookHistory();               
	            	bookhistory.setId(rs.getString("id"));             
	            	bookhistory.setName(rs.getString("name"));               
	            	bookhistory.setAuthor(rs.getString("author"));        
	            	bookhistory.setPublisher(rs.getString("publisher"));
	            	bookhistory.setYear((java.util.Date)rs.getDate("year"));
	            	bookhistory.setCategory(rs.getString("category"));
	            	bookhistory.setUserName(rs.getString("username"));
	            	bookhistory.setNumber(1);
	            	bookhistory.setDateOut((java.util.Date)rs.getDate("dateout"));
	            	bookhistory.setDateReturn((java.util.Date)rs.getDate("datereturn"));
	            	bookhistory.setCost(rs.getInt("cost"));
	            	bookhistories.add(bookhistory);                    
	            }
	        } catch (Exception e) {
	        }
	        return bookhistories;
	    }
	    
	    public void addBookHistory(BookHistory bookhistory){
	        Connection connection= ConnectionSQL.getConnection();
	        java.util.Date year=bookhistory.getYear();
	        Date a=new Date(0); 
	        a.setTime(year.getTime());
	        
	        java.util.Date dateout=bookhistory.getDateOut();
	        Date b=new Date(0); 
	        b.setTime(dateout.getTime());
	        
	        java.util.Date datereturn=bookhistory.getDateReturn();
	        Date c=new Date(0); 
	        c.setTime(datereturn.getTime());
	        
	       
	        String sql="INSERT INTO bookhistory VALUES (?,?,?,?,?,?,?,?,?,?)";
	        try {
	            PreparedStatement preparedStatement=connection.prepareStatement(sql);
	            preparedStatement.setString(1,bookhistory.getId() );
	            preparedStatement.setString(2,bookhistory.getName() );
	            preparedStatement.setString(3,bookhistory.getAuthor() );
	            preparedStatement.setString(4,bookhistory.getCategory() );
	            preparedStatement.setDate(5, a);
	            preparedStatement.setString(6,bookhistory.getCategory() );  
	            preparedStatement.setString(7, bookhistory.getUserName());
	            preparedStatement.setDate(8, b);
	            preparedStatement.setDate(9, c);
	            preparedStatement.setInt(10,bookhistory.getCost() );
	            
	            int rs=preparedStatement.executeUpdate();
	            
	            
	            System.out.println("da add");
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	    }
	    
	    public void updateBookHistory(BookHistory bookhistory){
	    	Connection connection= ConnectionSQL.getConnection();
	        java.util.Date year=bookhistory.getYear();
	        Date a=new Date(0); 
	        a.setTime(year.getTime());
	        
	        java.util.Date dateout=bookhistory.getDateOut();
	        Date b=new Date(0); 
	        b.setTime(dateout.getTime());
	        
	        java.util.Date datereturn=bookhistory.getDateReturn();
	        Date c=new Date(0); 
	        c.setTime(datereturn.getTime());
	        
	         String sql="UPDATE bookhistory SET " + 
	         		"name=?,author=?,publisher=?,year=?,category=?,	username=?,dateout=?,datereturn=?,cost=? where id=?";
	         try {
	        	 PreparedStatement preparedStatement=connection.prepareStatement(sql);
	             preparedStatement.setString(1,bookhistory.getName() );
	             preparedStatement.setString(2,bookhistory.getAuthor() );
	             preparedStatement.setString(3,bookhistory.getPublisher() );
	             preparedStatement.setDate(4, a);
	             preparedStatement.setString(5, bookhistory.getCategory());
	             preparedStatement.setString(6, bookhistory.getUserName());
	             preparedStatement.setDate(7, b);
	             preparedStatement.setDate(8, c);
	             preparedStatement.setInt(9, bookhistory.getCost());
	             preparedStatement.setString(10, bookhistory.getId());
	             
	             int rs=preparedStatement.executeUpdate();
	             
	             
	             System.out.println("da up");
	         } catch (Exception e) {
	        	 e.printStackTrace();
	         }
		}
	    
		


}
