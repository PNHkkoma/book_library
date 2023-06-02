package manage;
import java.util.Date;

public class BookOut extends BookIn {
	private String userName;
	private Date dateOut;
	private Date dateIn;
	public BookOut() {
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDateOut() {
		return dateOut;
	}
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
		
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
		Date b=new Date(dateOut.getTime()+1296000000);
		setDateIn(b);
	}
	public static void main(String[] as) {
		BookOut a=new BookOut();
		Date b=new Date(101,0,1);
		a.setDateOut(b);
		System.out.println(1296000000/15);
	}
	
}
