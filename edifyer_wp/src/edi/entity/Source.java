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
@Table(name="source")
public class Source {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="name")
	private String name; 
	
	@Column(name="scrape_script")
	private String scrapeScript;
	
	@Column(name="home_link")
	private String homeLink;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="source_id")
	private List<Rating> ratings;
	
	public Source() {
		
	}

	public Source(String name, String scrapeScript, String sourceLink) {
		this.name = name;
		this.scrapeScript = scrapeScript;
		this.homeLink = sourceLink;
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

	public String getScrapeScript() {
		return scrapeScript;
	}

	public void setScrapeScript(String scrapeScript) {
		this.scrapeScript = scrapeScript;
	}

	public String getSourceLink() {
		return homeLink;
	}

	public void setSourceLink(String sourceLink) {
		this.homeLink = sourceLink;
	}

	public String getHomeLink() {
		return homeLink;
	}

	public void setHomeLink(String homeLink) {
		this.homeLink = homeLink;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	// convenience method
	
	public void addRating(Rating tempRating) {
		
		tempRating.setSource(this);
		
		if(ratings==null) {
			ratings = new ArrayList<>();
		}
		ratings.add(tempRating);
	}

	@Override
	public String toString() {
		return "Source [id=" + id + ", name=" + name + ", scrapeScript=" + scrapeScript + ", sourceLink=" + homeLink
				+ "]";
	}
	
	
	

}