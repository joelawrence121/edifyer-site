package edi.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rating")
public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rating_id")	
	private int id;
	
	@Column(name="sd_rate")	
	private double sdrate;
	
	@Column(name="uncertainty")	
	private double uncertainty;
	
	@Column(name="date")	
	private Date date;
	
	@Column(name="source_link")
	private String sourceLink;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="company_id")
	private Company company;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="source_id")
	private Source source;
	
	public Rating() {}

	public Rating(double sdrate, double uncertainty, Date date, String sourceLink) {
		this.sdrate = sdrate;
		this.uncertainty = uncertainty;
		this.date = date;
		this.sourceLink = sourceLink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSdrate() {
		return sdrate;
	}

	public void setSdrate(double sdrate) {
		this.sdrate = sdrate;
	}

	public double getUncertainty() {
		return uncertainty;
	}

	public void setUncertainty(double uncertainty) {
		this.uncertainty = uncertainty;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSourceLink() {
		return sourceLink;
	}

	public void setSourceLink(String sourceLink) {
		this.sourceLink = sourceLink;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", sdrate=" + sdrate + ", uncertainty=" + uncertainty + ", date=" + date
				+ ", sourceLink=" + sourceLink + "]";
	}


	
}