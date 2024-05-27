package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="instructor_id")
    private int instructorId;

    @ManyToOne
    @JoinColumn(name = "instructor_id")//which ever table has foreign key that entity used @joinColum
    private Instructor instructor;
}
