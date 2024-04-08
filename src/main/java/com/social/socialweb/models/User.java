package com.social.socialweb.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String gender;
    private List<Integer> followers = new ArrayList<>();
    private List<Integer> followings = new ArrayList<>();

    public User(){
        //TODO auto-generated constructor stud
    }

    public User(Integer id, String firstName, String lastName, String email, String password, String gender, List<Integer> followers, List<Integer> followings){
        super();
        this.id = id;
        this.firstName = firstName; 
        this.lastName = lastName;
        this.email = email;
        this.password = password; 
        this.gender = gender;
        this.followers = followers; 
        this.followings = followings;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

    public String getGender(){
        return gender;
    }

    public void setFollowers(List<Integer> followers){
        this.followers=followers;
    }

    public List<Integer> getFollowers(){
        return followers;
    }

    public void setFollowings(List<Integer> followings){
        this.followings=followings;
    }

    public List<Integer> getFollowings(){
        return followings;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public Integer getId(){
        return id;
    }
    
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public void setPassword(String password){
        this.password=password;
    }
    
    public String getPassword(){
        return password;
    }
}
