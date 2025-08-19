package com.ashu.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Column(name = "first_name")
    private String fname;
    
    @Column(name = "last_name")
    private String lname;
    
    @Column(name = "branch")
    private String branch;
    
//    getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
    
   
}
