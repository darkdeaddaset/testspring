package com.example.backend.bussines;

import java.util.List;

public class RaznNum implements Operation{

    private List<Integer> numbers;

    public RaznNum(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public final boolean OperName(String name){
        boolean oper = false;
        if (name == "razn"){
            oper = true;
        }
        return oper;
    }

    @Override
    public final int Operation(List<Integer> numbers){
        int result = 0;

        for(int Num : this.numbers){
            result -= Num;
        }

        return result;
    }
}
