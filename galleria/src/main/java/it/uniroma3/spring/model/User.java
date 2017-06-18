package it.uniroma3.spring.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String firstName;

	@NotNull
	@Size(min=1)
	private String lastName;

	@NotNull
	@Min(18)
	private Integer age;
	@NotNull
//	@Size(min=8,max=32)
	@Size(min=1)
	@Column(unique = true)
	private String username;
	@NotNull
//	@Size(min=8,max=32)
	@Size(min=1)
	private String password;
	@OneToOne(cascade=CascadeType.ALL)
	private Ruolo ruolo;
	public User() {}

	public User(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.ruolo=new Ruolo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
//	@Override
//	public String toString() {
//		return String.format(
//				"user[id=%d, firstName='%s', lastName='%s',username='%s', password='%s', Role='%s']",
//				id, firstName, lastName,username,password,ruolo);
//	}
	
	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	@Override
	public String toString() {
		return String.format(
				"user[id=%d, firstName='%s', lastName='%s',username='%s', password='%s']",
				id, firstName, lastName,username,password);
	}



}