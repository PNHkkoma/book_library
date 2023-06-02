package manage;

import java.util.*;

public class User {
	private String id;
	private String nameLogin;
	private String passLogin;
	private String name;
	private String phonenumber;
	private String email;
	private String level;
	private Date birthday;
    private int count;
        public User(){
            
        }
	public User(String id,String nameLogin, String passLogin, String name, String phonenumber, String email, String level,Date birthday, int count) {
		this.id=id;
		this.nameLogin = nameLogin;
		this.passLogin = passLogin;
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.level = level;
                this.birthday=birthday;
                this.count=count;
	}

	public String getNameLogin() {
		return nameLogin;
	}

	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
	}

	public String getPassLogin() {
		return passLogin;
	}

	public void setPassLogin(String passLogin) {
		this.passLogin = passLogin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public Date getBirthday() {
            return birthday;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
	
}
