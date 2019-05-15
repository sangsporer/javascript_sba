package bnym.casestudy.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Scholarship {

	public enum Type {
		ENDOWED("Endowed"), PASS_THRU("Pass-Thru");

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
	@NotEmpty(message = "Enter scholarship name")
	private String name;
	@NotEmpty
	@Enumerated(EnumType.STRING)
	private Type type;
	@NotNull
	private BigDecimal size;
	private String detail;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "scholarship", fetch = FetchType.EAGER, orphanRemoval = true)
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "scholarship" )
	private Collection<Winner> winners = new LinkedHashSet<>();
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "scholarship", fetch = FetchType.EAGER, orphanRemoval = true)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "scholarship" )
	private Collection<Transaction> transactions = new LinkedHashSet<>();

//	public Scholarship(Long id, String name, Type type, BigDecimal size, Integer term) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.type = type;
//		this.size = size;
//		this.term = term;
//	}
//
//	public Scholarship() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	

	public BigDecimal getSize() {
		return size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	
	public Collection<Winner> getWinners() {
		return this.winners;
	}

	public void setWinners(Collection<Winner> winners) {
		this.winners = winners;
	}
	

	public void addWinner(Winner winner) {
		this.winners.add(winner);
		winner.setScholarship(this);
	}
	
	
	public void removeWinner(Winner winner) {
		this.winners.remove(winner);
	}
	
	public Collection<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
		transaction.setScholarship(this);
	}
	
	public void removeTransaction(Transaction transaction) {
		this.transactions.remove(transaction);
	}

}
