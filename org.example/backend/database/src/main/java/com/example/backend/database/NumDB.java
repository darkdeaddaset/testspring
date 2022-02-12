package com.example.backend.database;

import javax.persistence.*;

@Entity
@Table(name = "randnum")
public class NumDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int value;

    public NumDB(){
    }

    public NumDB(final int value){
        this.value = value;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public int getNum(){
        return value;
    }

    public void setNum(final int value){
        this.value = value;
    }
}
