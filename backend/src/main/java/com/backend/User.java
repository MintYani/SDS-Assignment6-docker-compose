package com.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;
    private String name;

    public User(){}
    
    public User(String id, String name){
            this.id = id;
            this.name = name;
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}


