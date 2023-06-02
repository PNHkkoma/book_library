package manage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class List_BookOut {
	private BookOutDoc bookOutDoc;
	
	public List_BookOut() {
		bookOutDoc=new BookOutDoc();
	}

	public ArrayList<BookOut> getAllBookOut(){
		return bookOutDoc.getAllBookOut();
	}
	
	 public void deleteBookOut(String id,String username){
		 bookOutDoc.deleteBookOut(id,username);
	 }
	 
	 public void addBookOut(BookOut bookout){
		 bookOutDoc.addBookOut(bookout);
	 }
	
	public ArrayList<BookOut> search_book_ID(String str){
		str=str.toLowerCase();
		ArrayList<BookOut> list_book = new ArrayList<>();
		for(BookOut x:getAllBookOut()){
			if(x.getId().toLowerCase().toLowerCase().contains(str)){
				list_book.add(x);
			}
		}
		return list_book;
	}
	
	public ArrayList<BookOut> search_book_Author(String str){
		str=str.toLowerCase();
		ArrayList<BookOut> list_book = new ArrayList<>();
		for(BookOut x:getAllBookOut()){
			if(x.getAuthor().toLowerCase().toLowerCase().contains(str)){
				list_book.add(x);
			}
		}
		return list_book;
	}

	public ArrayList<BookOut> search_book_Name(String str){
		str=str.toLowerCase();
		ArrayList<BookOut> list_book = new ArrayList<>();
		for(BookOut x:getAllBookOut()){
			if(x.getName().toLowerCase().contains(str)){
				list_book.add(x);
			}
		}
		return list_book;
	}

	public ArrayList<BookOut> search_book_Publis(String str){
		str=str.toLowerCase();
		ArrayList<BookOut> list_book = new ArrayList<>();
		for(BookOut x:getAllBookOut()){
			if(x.getPublisher().toLowerCase().contains(str)){
				list_book.add(x);
			}
		}
		return list_book;
	}
	
	public ArrayList<BookOut> search_book_UserName(String str){
		str=str.toLowerCase();
		ArrayList<BookOut> list_book = new ArrayList<>();
		for(BookOut x:getAllBookOut()){
			if(x.getUserName().toLowerCase().contains(str)){
				list_book.add(x);
			}
		}
		return list_book;
	}
	
	//thuật toán sắp xếp theo các thuộc tính
		public ArrayList<BookOut> SortByName(ArrayList<BookOut> a) {
			Comparator<BookOut> name_compa=new Comparator<BookOut>() {
				
				@Override
				public int compare(BookOut o1, BookOut o2) {
					return o1.getName().compareTo(o2.getName());
				}
			};
			Collections.sort(a, name_compa);
			return a;
		}
		
		public ArrayList<BookOut> SortByAuthor(ArrayList<BookOut> a) {
			Comparator<BookOut> author_compa=new Comparator<BookOut>() {
				
				@Override
				public int compare(BookOut o1, BookOut o2) {
					return o1.getAuthor().compareTo(o2.getAuthor());
				}
			};
			Collections.sort(a, author_compa);
			return a;
		}
		
		public ArrayList<BookOut> SortByPublisher(ArrayList<BookOut> a) {
			Comparator<BookOut> publisher_compa=new Comparator<BookOut>() {
				
				@Override
				public int compare(BookOut o1, BookOut o2) {
					return o1.getPublisher().compareTo(o2.getPublisher());
				}
			};
			Collections.sort(a, publisher_compa);
			return a;
		}
		
		public ArrayList<BookOut> SortByUserName(ArrayList<BookOut> a) {
			Comparator<BookOut> username_compa=new Comparator<BookOut>() {
				
				@Override
				public int compare(BookOut o1, BookOut o2) {
					return o1.getUserName().compareTo(o2.getUserName());
				}
			};
			Collections.sort(a, username_compa);
			return a;
		}
		
		public ArrayList<BookOut> SortByID(ArrayList<BookOut> a) {
			Comparator<BookOut> id_compa=new Comparator<BookOut>() {
				
				@Override
				public int compare(BookOut o1, BookOut o2) {
					return o1.getId().compareTo(o2.getId());
				}
			};
			Collections.sort(a, id_compa);
			return a;
		}
	
	
}
