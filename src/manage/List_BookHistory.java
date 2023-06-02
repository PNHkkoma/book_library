package manage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class List_BookHistory {
	BookHistoryDoc bookHistoryDoc;
	
	public List_BookHistory() {
		bookHistoryDoc=new BookHistoryDoc();
	}
	
	public ArrayList<BookHistory> getAllBookHistory(){
		return bookHistoryDoc.getAllBookHistory();
	}
	
	 public void addBookHistory(BookHistory bookhistory){
		bookHistoryDoc.addBookHistory(bookhistory);
	}
	 
	 public ArrayList<BookHistory> search_book_ID(String str){
			str=str.toLowerCase();
			ArrayList<BookHistory> list_book = new ArrayList<>();
			for(BookHistory x:getAllBookHistory()){
				if(x.getId().toLowerCase().toLowerCase().contains(str)){
					list_book.add(x);
				}
			}
			return list_book;
		}
		
		public ArrayList<BookHistory> search_book_Author(String str){
			str=str.toLowerCase();
			ArrayList<BookHistory> list_book = new ArrayList<>();
			for(BookHistory x:getAllBookHistory()){
				if(x.getAuthor().toLowerCase().toLowerCase().contains(str)){
					list_book.add(x);
				}
			}
			return list_book;
		}

		public ArrayList<BookHistory> search_book_Name(String str){
			str=str.toLowerCase();
			ArrayList<BookHistory> list_book = new ArrayList<>();
			for(BookHistory x:getAllBookHistory()){
				if(x.getName().toLowerCase().contains(str)){
					list_book.add(x);
				}
			}
			return list_book;
		}

		public ArrayList<BookHistory> search_book_Publis(String str){
			str=str.toLowerCase();
			ArrayList<BookHistory> list_book = new ArrayList<>();
			for(BookHistory x:getAllBookHistory()){
				if(x.getPublisher().toLowerCase().contains(str)){
					list_book.add(x);
				}
			}
			return list_book;
		}
		
		public ArrayList<BookHistory> search_book_UserName(String str){
			str=str.toLowerCase();
			ArrayList<BookHistory> list_book = new ArrayList<>();
			for(BookHistory x:getAllBookHistory()){
				if(x.getUserName().toLowerCase().contains(str)){
					list_book.add(x);
				}
			}
			return list_book;
		}
		
		//thuật toán sắp xếp theo các thuộc tính
			public ArrayList<BookHistory> SortByName(ArrayList<BookHistory> a) {
				Comparator<BookHistory> name_compa=new Comparator<BookHistory>() {
					
					@Override
					public int compare(BookHistory o1, BookHistory o2) {
						return o1.getName().compareTo(o2.getName());
					}
				};
				Collections.sort(a, name_compa);
				return a;
			}
			
			public ArrayList<BookHistory> SortByAuthor(ArrayList<BookHistory> a) {
				Comparator<BookHistory> author_compa=new Comparator<BookHistory>() {
					
					@Override
					public int compare(BookHistory o1, BookHistory o2) {
						return o1.getAuthor().compareTo(o2.getAuthor());
					}
				};
				Collections.sort(a, author_compa);
				return a;
			}
			
			public ArrayList<BookHistory> SortByPublisher(ArrayList<BookHistory> a) {
				Comparator<BookHistory> publisher_compa=new Comparator<BookHistory>() {
					
					@Override
					public int compare(BookHistory o1, BookHistory o2) {
						return o1.getPublisher().compareTo(o2.getPublisher());
					}
				};
				Collections.sort(a, publisher_compa);
				return a;
			}
			
			public ArrayList<BookHistory> SortByUserName(ArrayList<BookHistory> a) {
				Comparator<BookHistory> username_compa=new Comparator<BookHistory>() {
					
					@Override
					public int compare(BookHistory o1, BookHistory o2) {
						return o1.getUserName().compareTo(o2.getUserName());
					}
				};
				Collections.sort(a, username_compa);
				return a;
			}
			
			public ArrayList<BookHistory> SortByID(ArrayList<BookHistory> a) {
				Comparator<BookHistory> id_compa=new Comparator<BookHistory>() {
					
					@Override
					public int compare(BookHistory o1, BookHistory o2) {
						return o1.getId().compareTo(o2.getId());
					}
				};
				Collections.sort(a, id_compa);
				return a;
			}
	
}
