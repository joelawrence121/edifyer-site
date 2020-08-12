package edi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="companyLog")
@IdClass(CompanyLogId.class)
public class CompanyLog {

	@Id 
	@Column(name="company_id")
	private int company_id;
	
	@Id 
	@Column(name="date")
	private String date;
	
	public CompanyLog() {}
	
	public CompanyLog(int company_id, String date) {
		this.company_id = company_id;
		this.date = date;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
