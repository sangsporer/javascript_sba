package bnym.casestudy.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	public enum Type{
		PAYMENT ("Payment"),
		DEPOSIT ("Deposit");
		
		private String description;

		Type(String description) {
			this.description = description;// TODO Auto-generated constructor stub
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "scholarship_id")
	private Scholarship scholarship;
	
	private Date date;
	@Enumerated(EnumType.STRING)
	private Type type; 
	private String toOrFrom;
	private BigDecimal amount;
	private BigDecimal balance;
	private String detail;
	
//	public Transaction(Long id, Scholarship scholarship, Date date, Type type, String toOrFrom, 
//			BigDecimal amount, BigDecimal balance, String description) {
//		super();
//		this.id = id;
//		this.scholarship = scholarship;
//		this.date = date;
//		this.type = type;
//		this.toOrFrom = toOrFrom;
//		this.amount = amount;
//		this.balance = balance;
//		this = description;
//	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getToOrFrom() {
		return toOrFrom;
	}

	public void setToOrFrom(String toOrFrom) {
		this.toOrFrom = toOrFrom;
	}

	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return detail;
	}

	public void setDescription(String detail) {
		this.detail = detail;
	}

	public Scholarship getScholarship() {
		return scholarship;
	}

	public void setScholarship(Scholarship scholarship) {
		this.scholarship = scholarship;
	}
	
	
	
	
}
