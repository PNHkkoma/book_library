package manage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class List_BookIn {
	private BookInDoc bookindoc;
	
	public List_BookIn() {
		bookindoc=new BookInDoc();
	}

	public ArrayList<BookIn> getAllBookIn(){
		return bookindoc.getAllBookIn();
	}
	
	public void addBookIn(BookIn bookin){
		bookindoc.addBookIn(bookin);
	}
	
	public void updateBookIn(BookIn bookin) {
		bookindoc.updateBookIn(bookin);
	}
	
	public void deleteBookIn(String id) {
		bookindoc.deleteBookIn(id);
	}
	
	//kiểm tra id đã tồn tại chưa
	public boolean isExsis(String id) {
		for(BookIn x:getAllBookIn()){
			if(x.getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	
	//thuật toán tìm kiếm theo các thuộc tính
	public ArrayList<BookIn> search_book_ID(String str){
		str=str.toLowerCase();
		ArrayList<BookIn> list_book = new ArrayList<>();
		for(BookIn x:getAllBookIn()){
			if(x.getId().toLowerCase().contains(str)){
				list_book.add(x);
			}
		}
		return list_book;
	}

	public ArrayList<BookIn> search_book_Author(String str){
		str=str.toLowerCase();
		ArrayList<BookIn> list_book = new ArrayList<>();
		for(BookIn x:getAllBookIn()){
			if(x.getAuthor().toLowerCase().toLowerCase().contains(str)){
				list_book.add(x);
			}
		}
		return list_book;
	}

	public ArrayList<BookIn> search_book_Name(String str){
		str=str.toLowerCase();
		ArrayList<BookIn> list_book = new ArrayList<>();
		for(BookIn x:getAllBookIn()){
			if(x.getName().toLowerCase().contains(str)){
				list_book.add(x);
			}
		}
		return list_book;
	}

	public ArrayList<BookIn> search_book_Publis(String str){
		str=str.toLowerCase();
		ArrayList<BookIn> list_book = new ArrayList<>();
		for(BookIn x:getAllBookIn()){
			if(x.getPublisher().toLowerCase().contains(str)){
				list_book.add(x);
			}
		}
		return list_book;
	}
	
	public ArrayList<BookIn> search_book_Category(String str){
		str=str.toLowerCase();
		ArrayList<BookIn> list_book = new ArrayList<>();
		for(BookIn x:getAllBookIn()){
			if(x.getCategory().toLowerCase().contains(str)){
				list_book.add(x);
			}
		}
		return list_book;
	}
	
	//thuật toán sắp xếp theo các thuộc tính
	public ArrayList<BookIn> SortByName(ArrayList<BookIn> a) {
		Comparator<BookIn> name_compa=new Comparator<BookIn>() {
			
			@Override
			public int compare(BookIn o1, BookIn o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(a, name_compa);
		return a;
	}
	
	public ArrayList<BookIn> SortByAuthor(ArrayList<BookIn> a) {
		Comparator<BookIn> author_compa=new Comparator<BookIn>() {
			
			@Override
			public int compare(BookIn o1, BookIn o2) {
				return o1.getAuthor().compareTo(o2.getAuthor());
			}
		};
		Collections.sort(a, author_compa);
		return a;
	}
	
	public ArrayList<BookIn> SortByPublisher(ArrayList<BookIn> a) {
		Comparator<BookIn> publisher_compa=new Comparator<BookIn>() {
			
			@Override
			public int compare(BookIn o1, BookIn o2) {
				return o1.getPublisher().compareTo(o2.getPublisher());
			}
		};
		Collections.sort(a, publisher_compa);
		return a;
	}
	
	public ArrayList<BookIn> SortByCategory(ArrayList<BookIn> a) {
		Comparator<BookIn> category_compa=new Comparator<BookIn>() {
			
			@Override
			public int compare(BookIn o1, BookIn o2) {
				return o1.getCategory().compareTo(o2.getCategory());
			}
		};
		Collections.sort(a, category_compa);
		return a;
	}
	
	public ArrayList<BookIn> SortByID(ArrayList<BookIn> a) {
		Comparator<BookIn> id_compa=new Comparator<BookIn>() {
			
			@Override
			public int compare(BookIn o1, BookIn o2) {
				return o1.getId().compareTo(o2.getId());
			}
		};
		Collections.sort(a, id_compa);
		return a;
	}
	
	
}
