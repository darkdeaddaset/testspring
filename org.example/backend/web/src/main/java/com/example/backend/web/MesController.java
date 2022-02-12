package com.example.backend.web;

import com.example.backend.database.NumDB;

import java.util.List;
import java.util.Optional;

public interface MesController {

    String getMes();
    Long newNum(int i);
    List<NumDB> all();
    int getIdNum(Long id);
    Optional<NumDB> editNum(NumDB newNum, Long id);
    void delete(Long id);

    int getSum(List<Long> id);
    int getRazn(List<Long> id);
}

