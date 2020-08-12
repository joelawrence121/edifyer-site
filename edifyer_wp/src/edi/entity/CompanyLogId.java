package edi.entity;

import java.io.Serializable;

public class CompanyLogId implements Serializable{
	
	private int company_id;
	private String date;
	
	public CompanyLogId() {}

	public CompanyLogId(int company_id, String date) {
		super();
		this.company_id = company_id;
		this.date = date;
	}
	

}
