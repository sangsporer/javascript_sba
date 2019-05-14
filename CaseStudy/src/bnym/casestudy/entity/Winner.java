package bnym.casestudy.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Winner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String school;
	private Date year;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "scholarship_id")
	private Scholarship scholarship;

//	public Winner(Long id, String name, String school, Date year) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.school = school;
//		this.year = year;
//	}

	public Scholarship getScholarship() {
		return scholarship;
	}

	public void setScholarship(Scholarship scholarship) {
		this.scholarship = scholarship;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Winner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	

}
