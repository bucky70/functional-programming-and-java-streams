package com.in28minutes.rest.webservices.restful_web_services;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name="user_details")
public class User {

        @Id
        @GeneratedValue//(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Size(min=2,message="name should have minimum of two characters")
        @JsonProperty("user_name")//change the name in json to user_name
        private String name;

        @Past(message="DOB should be in the past")
        @JsonProperty("birth_date")
        private LocalDate birthDate;

        @OneToMany(mappedBy = "user")
        @JsonIgnore
        private List<Post> posts;

        public User(){

        }
        public User(Integer id, String name, LocalDate birthDate) {
            super();
            this.id = id;
            this.name = name;
            this.birthDate = birthDate;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public void addPost(Post post){
            if(posts==null){
                posts=new ArrayList<>();
            }
            posts.add(post);
    }

    @Override
        public String toString() {
            return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
        }

    }