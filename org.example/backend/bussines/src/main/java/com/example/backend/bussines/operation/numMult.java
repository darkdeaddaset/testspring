package com.example.backend.bussines.operation;

import com.example.backend.database.JpaNum;

import java.util.List;

public class numMult implements oper{

    private JpaNum jpaNum;

    public numMult(JpaNum jpaNum){
        this.jpaNum = jpaNum;
    }

    @Override
    public final String readName(String name){
        if (name.equals("mult")){
            return name;
        }
        else return "Not operation";
    }

    @Override
    public final int actionOper(List<Long> id){
        int result = 1;

        for (Long i : id){
            result *= jpaNum.findById(i).get().getNum();
        }
        return result;
    }
}
