package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JobSeekerDTO implements Serializable{
	private String jsName;
	private  int age;
	private String addrs;
	private  String skill;
	private  String location;
	private int experience;
	private  int expSalary;
	
	
}
