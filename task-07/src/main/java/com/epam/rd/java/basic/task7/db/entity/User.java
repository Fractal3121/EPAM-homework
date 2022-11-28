package com.epam.rd.java.basic.task7.db.entity;

public class User {
	private int id;
	private String login;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public static User createUser(String login) {
		User user = new User();
		user.setId(0);
		user.setLogin(login);
		return user;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if (this == obj){
			return true;
		}
		if(!(obj instanceof User)){
				return false;
		}
		User other = (User) obj;
		if (login == null){
			return other.login == null;
		}
		else {
			return login.equals(other.login);
		}
	}

	@Override
	public String toString() {
		return login;
	}
}
