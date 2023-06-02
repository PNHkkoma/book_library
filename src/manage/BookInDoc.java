package manage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookInDoc {
	public ArrayList<BookIn> getAllBookIn(){
        ArrayList<BookIn> bookins=new ArrayList<BookIn>();
        Connection connection= ConnectionSQL.getConnection();
        String sql="SELECT * FROM bookin";
        
        try {
            PreparedStatement preparedStatement=connection.prepareCall(sql);
            ResultSet rs=preparedStatement.executeQuery();
            
            while (rs.next()) {
                BookIn bookin=new BookIn();               
                bookin.setId(rs.getString("id"));             
                bookin.setName(rs.getString("name"));               
                bookin.setAuthor(rs.getString("author"));        
                bookin.setPublisher(rs.getString("publisher"));
                bookin.setYear((java.util.Date)rs.getDate("year"));
                bookin.setCategory(rs.getString("category"));
                bookin.setNumber(rs.getInt("number"));
                bookin.setCost(rs.getInt("cost"));
                bookins.add(bookin);                    
            }
        } catch (Exception e) {
        }
        return bookins;
    }
    
    public void addBookIn(BookIn bookin){
        Connection connection= ConnectionSQL.getConnection();
        java.util.Date year=bookin.getYear();
        Date a=new Date(0);
        
        a.setTime(year.getTime());
       
        String sql="INSERT INTO BookIn VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,bookin.getId() );
            preparedStatement.setString(2,bookin.getName() );
            preparedStatement.setString(3,bookin.getAuthor() );
            preparedStatement.setString(4,bookin.getPublisher() );
            preparedStatement.setDate(5, a);
            preparedStatement.setString(6,bookin.getCategory() );  
            preparedStatement.setInt(7, bookin.getNumber());
            preparedStatement.setInt(8,bookin.getCost() );
            
            int rs=preparedStatement.executeUpdate();
            
            
            System.out.println("da add");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void updateBookIn(BookIn bookin) {
    	 Connection connection= ConnectionSQL.getConnection();
         java.util.Date year=bookin.getYear();
         Date a=new Date(0);
         
         a.setTime(year.getTime());
        
         String sql="UPDATE BookIn SET " + 
         		"name=?,author=?,publisher=?,year=?,category=?,number=?,cost=? where id=?";
         try {
        	 PreparedStatement preparedStatement=connection.prepareStatement(sql);
             preparedStatement.setString(1,bookin.getName() );
             preparedStatement.setString(2,bookin.getAuthor() );
             preparedStatement.setString(3,bookin.getPublisher() );
             preparedStatement.setDate(4, a);
             preparedStatement.setString(5, bookin.getCategory());
             preparedStatement.setInt(6,bookin.getNumber() );
             preparedStatement.setInt(7, bookin.getCost());
             preparedStatement.setString(8, bookin.getId());
             
             int rs=preparedStatement.executeUpdate();
             
             
             System.out.println("da up");
         } catch (Exception e) {
        	 e.printStackTrace();
         }
	}
    
    public void deleteBookIn(String id) {
    	Connection connection= ConnectionSQL.getConnection();   
         String sql="DELETE FROM bookin WHERE id=?";
         try {
             PreparedStatement preparedStatement=connection.prepareStatement(sql);
             preparedStatement.setString(1,id );
             
             int rs=preparedStatement.executeUpdate();
             
             
             System.out.println("da xoa");
         } catch (Exception e) {
        	 e.printStackTrace();
         }
	}
	

}
