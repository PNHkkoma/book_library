package manage;

import java.util.Date;

public class BookHistory extends BookOut{
	Date dateReturn;
	
	public BookHistory() {
		
	}


	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}
	
	// tính phí khi trả sách chậm. Do không lưu giờ gửi nên cách tính phí là hết 24h 15 ngày tính từ ngày mượn bắt đầu tính phí
	public int getFee() {
		long time=this.dateReturn.getTime()-getDateIn().getTime();
		if(time<=86400000)
			return 0;
		else
			return (int)(2000*(time)/86400000);
	}
	

	public static void main(String[] args) {
		BookHistory a=new BookHistory();
		Date dateOut=new Date(121, 2, 1);
		Date dateReturn=new Date(121, 2, 20	);
		a.setDateOut(dateOut);
		System.out.println(a.getDateOut());
		a.setDateReturn(dateReturn);
		

	}

}
