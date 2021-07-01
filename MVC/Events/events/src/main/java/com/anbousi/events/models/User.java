package com.anbousi.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 200 , message="Last name must be greater than 2 Chars")
    private String firstname;
    @NotNull
    @Size(min = 2, max = 200 , message="Last name must be greater than 2 Chars")
    private String lastname;
    @NotNull
    @Email(message="Email must be valid")
    @Column(unique = true)
    private String email;
    @NotNull
    @Size(min=2, message="location must be greater than 1 charachter")
    private String location;
    @NotNull
    @NotBlank
    @Size(min=5, message="Password must be greater than 5 charachters")
    private String password;
    @Transient
    private String passwordConfirmation;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Event> createdEvents;
     
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_events", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> joinedEvents;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Message> messages;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="state_id")
    private State state;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public User() {
	}
	public User(String firstname, String lastname, String email, String location, String password,
				String passwordConfirmation, State state) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.location = location;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.state = state;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public List<Event> getCreatedEvents() {
		return createdEvents;
	}
	public void setCreatedEvents(List<Event> createdEvents) {
		this.createdEvents = createdEvents;
	}
	public List<Event> getJoinedEvents() {
		return joinedEvents;
	}
	public void setJoinedEvents(List<Event> joinedEvents) {
		this.joinedEvents = joinedEvents;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
    
    
}