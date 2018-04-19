package trial.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="product")
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	private String name; 
	private String description; 
	private String location;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_posted; 
	private boolean availability; 
	private boolean done;
	
	public Product() {
		
	}
	
	public Product(String name, String description, String location, Date date_posted, boolean availability,
			boolean done) {
		super();
		this.name = name;
		this.description = description;
		this.location = location;
		this.date_posted = date_posted;
		this.availability = availability;
		this.done = done;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate_posted() {
		return date_posted;
	}
	public void setDate_posted(Date date_posted) {
		this.date_posted = date_posted;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	
}
