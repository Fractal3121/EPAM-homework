package com.epam.rd.java.basic.task7.db.entity;

public class Team {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Team createTeam(String name) {
		Team team = new Team();
		team.setName(name);
		team.setId(0);
		return team;
	}

	@Override
	public String toString() {
		return name;
	}
/*
	@Override
	public boolean equals(Object obj) {
		if (obj == null){
			return false;
		}
		if(this == obj){
			return true;
		}
		if (!(obj instanceof Team)){
			return false;
		}
		Team group = (Team) obj;
		if (name == null){
			return group.name == null;
		}
		else{
			return name.equals(group.name);
		}
	}*/

}
