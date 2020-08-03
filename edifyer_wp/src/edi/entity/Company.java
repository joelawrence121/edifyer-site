package edi.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="name")
	private String name;
	
	@Column(name="category")
	private String category;
	
	// eager loading so we can display a companies ratings from the company object
	@OneToMany(fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="company_id")
	private List<Rating> ratings;

	public Company() {
		
	}

	public Company(String name, String category) {
		this.name = name;
		this.category = category;
	}

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public List<Rating> getRatings() {
		return ratings;
	}
	
	// convenience method for adding ratings 
	
	public void addRating(Rating tempRating) {
		
		// set the ratings company to this
		
		tempRating.setCompany(this);
		
		if(ratings==null) {
			ratings = new ArrayList<>();
		}
		ratings.add(tempRating);
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
}
