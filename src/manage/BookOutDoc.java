package manage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookOutDoc {
	public ArrayList<BookOut> getAllBookOut(){
        ArrayList<BookOut> bookouts=new ArrayList<BookOut>();
        Connection connection= ConnectionSQL.getConnection();
        String sql="SELECT * FROM bookout";
        
        try {
            PreparedStatement preparedStatement=connection.prepareCall(sql);
            ResultSet rs=preparedStatement.executeQuery();
            
            while (rs.next()) {
            	BookOut bookout=new BookOut();               
            	bookout.setId(rs.getString("id"));             
            	bookout.setName(rs.getString("name"));               
            	bookout.setAuthor(rs.getString("author"));        
            	bookout.setPublisher(rs.getString("publisher"));
            	bookout.setYear((java.util.Date)rs.getDate("year"));
            	bookout.setCategory(rs.getString("category"));
            	bookout.setUserName(rs.getString("username"));
            	bookout.setNumber(1);
            	bookout.setDateOut((java.util.Date)rs.getDate("dateout"));
            	bookout.setCost(rs.getInt("cost"));
            	bookouts.add(bookout);                    
            }
        } catch (Exception e) {
        }
        return bookouts;
    }
    
    public void addBookOut(BookOut bookout){
        Connection connection= ConnectionSQL.getConnection();
        java.util.Date year=bookout.getYear();
        Date a=new Date(0); 
        a.setTime(year.getTime());
        
        java.util.Date dateout=bookout.getDateOut();
        Date b=new Date(0); 
        b.setTime(dateout.getTime());
        
       
        String sql="INSERT INTO BookOut VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,bookout.getId() );
            preparedStatement.setString(2,bookout.getName() );
            preparedStatement.setString(3,bookout.getAuthor() );
            preparedStatement.setString(4,bookout.getCategory() );
            preparedStatement.setDate(5, a);
            preparedStatement.setString(6,bookout.getCategory() );  
            preparedStatement.setString(7, bookout.getUserName());
            preparedStatement.setDate(8, b);
            preparedStatement.setInt(9,bookout.getCost() );
            
            int rs=preparedStatement.executeUpdate();
            
            
            System.out.println("da add");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void updateBookOut(BookOut bookout){
        Connection connection= ConnectionSQL.getConnection();
        java.util.Date year=bookout.getYear();
        Date a=new Date(0); 
        a.setTime(year.getTime());
        
        java.util.Date dateout=bookout.getDateOut();
        Date b=new Date(0); 
        b.setTime(dateout.getTime());
        
         String sql="UPDATE bookout SET " + 
         		"name=?,author=?,publisher=?,year=?,category=?,	username=?,dateout=?,cost=? where id=?";
         try {
        	 PreparedStatement preparedStatement=connection.prepareStatement(sql);
             preparedStatement.setString(1,bookout.getName() );
             preparedStatement.setString(2,bookout.getAuthor() );
             preparedStatement.setString(3,bookout.getPublisher() );
             preparedStatement.setDate(4, a);
             preparedStatement.setString(5, bookout.getCategory());
             preparedStatement.setString(6, bookout.getUserName());
             preparedStatement.setDate(7, b);
             preparedStatement.setInt(8, bookout.getCost());
             preparedStatement.setString(9, bookout.getId());
             
             int rs=preparedStatement.executeUpdate();
             
             
             System.out.println("da up");
         } catch (Exception e) {
        	 e.printStackTrace();
         }
	}
    
    public void deleteBookOut(String id,String username){
    	Connection connection= ConnectionSQL.getConnection();  
       
         String sql="DELETE FROM bookout WHERE id=? AND username=?";
         try {
             PreparedStatement preparedStatement=connection.prepareStatement(sql);
             preparedStatement.setString(1,id );
             preparedStatement.setString(2, username);
             
             int rs=preparedStatement.executeUpdate();
             
             
             System.out.println("da xoa");
         } catch (Exception e) {
        	 e.printStackTrace();
         }
	}
	

}
