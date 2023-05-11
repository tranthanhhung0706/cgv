package com.example.demo.model;
import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<>();
    
	// @OneToOne(mappedBy = "user")
    // private Customer customer;
	
	// @OneToOne(mappedBy = "user")
    // private Staff staff;

    

	//@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "profile_id")
	//private  Staff staff;
	
	public User() {
		super();
	}

    
    public User(String username, String password, String fullName) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
	}
    
    
	

	public User(String username, String password, String fullName, Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.roles = roles;
	}




	



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
    
}