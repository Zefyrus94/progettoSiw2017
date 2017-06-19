package it.uniroma3.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="utenti")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@NotNull
	@Size(min=1)
	private String firstname;

	//@NotNull
	@Size(min=1)
	private String lastname;
	//@NotNull
	@Min(18)
	private Integer age;
	@Column(unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@NotNull
	@Column(nullable = false)
	private boolean enabled;
	
//	@OneToOne(cascade = {CascadeType.PERSIST})
//	private Atleta atletaGestito;
//	@OneToOne(cascade = {CascadeType.PERSIST})
//	private Societa societaGestita;

	public boolean isEnabled(){
		return enabled;
	}
	
	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}
	
	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

//
//	@Override
//	public String toString() {
//		return "Utente [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
//				+ ", atletaGestito=" + atletaGestito + ", societaGestita=" + societaGestita + "]";
//	}
}
