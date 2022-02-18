package com.example.backend.web;

import com.example.backend.database.NumDB;
import com.example.backend.database.NumInfo;

import java.util.List;
import java.util.Optional;

public interface MesController {

    String getMes();
    NumDB newNum(NumDB NeWnumDB);
    List<NumDB> all();
    int getIdNum(Long id);
    Optional<NumDB> editNum(Long id, NumDB newNum);
    void delete(Long id);
    Long newVal(int num);

    String getResOper(String name, List<Long> id);
    String getResTwo(String name, List<Long> id);
    NumInfo getNewNumInfo(NumInfo numInfo);
    void deleteTest(Long id);
    Optional<NumInfo> editNumInfo(Long id, NumInfo editNumInfo);
}

