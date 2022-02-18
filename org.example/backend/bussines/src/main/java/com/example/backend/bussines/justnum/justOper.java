package com.example.backend.bussines.justnum;

import com.example.backend.database.NumDB;
import com.example.backend.database.NumInfo;

import java.util.List;
import java.util.Optional;

public interface justOper {

    List<NumDB> displayAll();
    NumDB newNumber(NumDB newNum);
    int byId(Long id);
    Optional<NumDB> edit(Long id, NumDB newNum);
    void delete(Long id);
    Long newVal(int num);

    String readName(String name);
    int actionOper(List<Long> id, String name);
    NumInfo getNewNumInfo(final NumInfo numInfo);
    void deleteTest(Long id);
    Optional<NumInfo> editNumInfo(final Long id, final NumInfo numInfo);
}

