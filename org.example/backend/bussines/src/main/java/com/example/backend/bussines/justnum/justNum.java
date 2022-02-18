package com.example.backend.bussines.justnum;

import com.example.backend.database.JpaInfo;
import com.example.backend.database.JpaNum;

public class justNum extends AbstractNum {

    public justNum(JpaNum jpaNum,
                   JpaInfo jpaInfo){
        super(jpaNum, jpaInfo);
    }

//    @Override
//    public final List<NumDB> displayAll(){
//        return jpaNum.findAll();
//    }
//
//    @Override
//    public final NumDB newNumber(NumDB newNum){
//        return jpaNum.save(newNum);
//    }
//
//    @Override
//    public final int byId(Long id){
//        return jpaNum.findById(id).get().getNum();
//    }
//
//    @Override
//    public final Optional<NumDB> edit(final Long id, final NumDB newNum){
//        return jpaNum.findById(id)
//                .map(numDB -> {
//                    numDB.setNum(newNum.getNum());
//                    return jpaNum.save(numDB);
//                });
//    }
//
//    @Override
//    public final void delete(final Long id){
//        jpaNum.deleteById(id);
//    }
//
//    @Override
//    public final Long newVal(final int num){
//        return jpaNum.save(new NumDB(num)).getId();
//    }
}