package com.example.api.model;

import javax.persistence.*;

@Entity
@Table
public class Persona {
    @Id
    @SequenceGenerator(
            name="persona_sequence",
            sequenceName = "persona_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="persona_sequence"
    )

    private Long id;
    private String name;
    private String job;
    private String email;
    private Integer age;

    public Persona() {
    }
    public Persona( String name, String job, String email, Integer age) {

        this.name = name;
        this.job = job;
        this.email = email;

        this.age = age;
    }
    public Persona(Long id, String name, String email,String job, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.job = job;


        this.age = age;
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("id:");
        stringBuffer.append(this.id);
        stringBuffer.append("name:");
        stringBuffer.append(this.name);
        stringBuffer.append("email:");
        stringBuffer.append(this.email);
        stringBuffer.append("job:");
        stringBuffer.append(this.job);
        stringBuffer.append("age:");
        stringBuffer.append(this.age);

        return stringBuffer.toString();

    }
}
