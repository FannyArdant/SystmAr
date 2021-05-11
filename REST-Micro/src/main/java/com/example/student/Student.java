package com.example.student;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Immatrikule")
    public String immatrikul;

    @Column(name = "name")
    public String name;

    @Column(name = "semester")
    public int semester;
}
