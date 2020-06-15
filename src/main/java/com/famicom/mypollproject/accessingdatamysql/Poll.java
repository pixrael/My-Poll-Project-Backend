package com.famicom.mypollproject.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Poll {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	private Integer id_poll_entry1;
	private Integer id_poll_entry2;
	private Integer id_poll_entry3;
	private Integer id_poll_entry4;
	private Integer id_poll_entry5;
	private Integer id_poll_entry6;
	private Integer id_poll_entry7;
	private Integer id_poll_entry8;
	private Integer id_poll_entry9;
	private Integer id_poll_entry10;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId_poll_entry1() {
		return id_poll_entry1;
	}

	public void setId_poll_entry1(Integer id_poll_entry1) {
		this.id_poll_entry1 = id_poll_entry1;
	}

	public Integer getId_poll_entry2() {
		return id_poll_entry2;
	}

	public void setId_poll_entry2(Integer id_poll_entry2) {
		this.id_poll_entry2 = id_poll_entry2;
	}

	public Integer getId_poll_entry3() {
		return id_poll_entry3;
	}

	public void setId_poll_entry3(Integer id_poll_entry3) {
		this.id_poll_entry3 = id_poll_entry3;
	}

	public Integer getId_poll_entry4() {
		return id_poll_entry4;
	}

	public void setId_poll_entry4(Integer id_poll_entry4) {
		this.id_poll_entry4 = id_poll_entry4;
	}

	public Integer getId_poll_entry5() {
		return id_poll_entry5;
	}

	public void setId_poll_entry5(Integer id_poll_entry5) {
		this.id_poll_entry5 = id_poll_entry5;
	}

	public Integer getId_poll_entry6() {
		return id_poll_entry6;
	}

	public void setId_poll_entry6(Integer id_poll_entry6) {
		this.id_poll_entry6 = id_poll_entry6;
	}

	public Integer getId_poll_entry7() {
		return id_poll_entry7;
	}

	public void setId_poll_entry7(Integer id_poll_entry7) {
		this.id_poll_entry7 = id_poll_entry7;
	}

	public Integer getId_poll_entry8() {
		return id_poll_entry8;
	}

	public void setId_poll_entry8(Integer id_poll_entry8) {
		this.id_poll_entry8 = id_poll_entry8;
	}

	public Integer getId_poll_entry9() {
		return id_poll_entry9;
	}

	public void setId_poll_entry9(Integer id_poll_entry9) {
		this.id_poll_entry9 = id_poll_entry9;
	}

	public Integer getId_poll_entry10() {
		return id_poll_entry10;
	}

	public void setId_poll_entry10(Integer id_poll_entry10) {
		this.id_poll_entry10 = id_poll_entry10;
	}

	

}
