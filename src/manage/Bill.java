package manage;

import java.util.ArrayList;
import java.util.Date;

public class Bill {
	private ArrayList<BookIn> lstBI;
	private ArrayList<BookOut> lstBO;
	private List_User a;
	private List_BookIn b;
	private List_BookOut c;
	private int indexUser;
	private Date date;
	
	public Bill(ArrayList<BookIn> lstBI,int indexUser) {
		a=new List_User();
		b=new List_BookIn();
		c=new List_BookOut();
		this.indexUser=indexUser;
		this.lstBI=lstBI;
		Date now=new Date();
		date=new Date(now.getYear(), now.getMonth(), now.getDate());
		lstBO=new ArrayList<BookOut>();
		for(BookIn bookin:lstBI) {
			BookOut bookout=new BookOut();
			bookout.setId(bookin.getId());
			bookout.setName(bookin.getName());
			bookout.setAuthor(bookin.getAuthor());
			bookout.setPublisher(bookin.getPublisher());
			bookout.setYear(bookin.getYear());
			bookout.setCategory(bookin.getCategory());
			bookout.setUserName(a.getAllUser().get(indexUser).getName());
			bookout.setDateOut(date);
			bookout.setCost(bookin.getCost());
			bookout.setNumber(1);
			lstBO.add(bookout);
		}
	}
	
	public void Delete(String id) {
		for(BookIn bookin:lstBI)
			if(bookin.getId().equals(id)) {
				lstBI.remove(bookin);
				break;
			}
		for(BookOut bookout:lstBO)
			if(bookout.getId().equals(id)) {
				lstBO.remove(bookout);
				break;
			}
	}
	
	public void Complete() {
		User user=a.getAllUser().get(indexUser);
		for(BookOut bookout:lstBO) {
			for(BookIn bookin :b.getAllBookIn()) {
				if(bookout.getId().equals(bookin.getId())){
					if(bookin.getNumber()==1)
						b.deleteBookIn(bookin.getId());
					else {
					bookin.setNumber(bookin.getNumber()-1);
					b.updateBookIn(bookin);
					}
				}
			}
			c.addBookOut(bookout);
			user.setCount(user.getCount()+1);
			a.updateUser(user);
		}
		
		
	}
	
	
	
	
	public ArrayList<BookIn> getLstBI() {
		return lstBI;
	}

	public void setLstBI(ArrayList<BookIn> lstBI) {
		this.lstBI = lstBI;
	}

	public ArrayList<BookOut> getLstBO() {
		return lstBO;
	}

	public void setLstBO(ArrayList<BookOut> lstBO) {
		this.lstBO = lstBO;
	}

	public int getIndexUser() {
		return indexUser;
	}

	public void setIndexUser(int indexUser) {
		this.indexUser = indexUser;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static void main(String[] args) {
		 List_BookIn b=new List_BookIn();
	       ArrayList<BookIn> lstBI=new ArrayList<BookIn>();
	       lstBI.add(b.getAllBookIn().get(2));
	       lstBI.add(b.getAllBookIn().get(3));
	       
	       
	      
	       
	}

}
