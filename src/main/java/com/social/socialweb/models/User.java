package com.social.socialweb.models;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(){
        //TODO auto-generated constructor stud
    }

    public User(Integer id, String firstName, String lastName, String email, String password){
        super();
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
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
