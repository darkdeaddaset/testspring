package com.example.backend.database;

import javax.persistence.*;

@Entity
@Table(name = "num_info")
public class NumInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "name")
    private String name;
    //@Column(name = "result")
    private int result;

    public NumInfo(){
    }

    public NumInfo(final String name, final int result){
        this.name = name;
        this.result = result;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public int getResult(){
        return this.result;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setResult(int result){
        this.result = result;
    }
}
