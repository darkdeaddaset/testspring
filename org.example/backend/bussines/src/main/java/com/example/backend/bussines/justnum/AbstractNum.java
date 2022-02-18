package com.example.backend.bussines.justnum;

import com.example.backend.database.*;
import java.util.List;
import java.util.Optional;

public abstract class AbstractNum implements justOper {

    private JpaNum jpaNum;
    private JpaInfo jpaInfo;

    protected AbstractNum(JpaNum jpaNum,
                          JpaInfo jpaInfo){
        this.jpaNum = jpaNum;
        this.jpaInfo = jpaInfo;
    }

    @Override
    public final List<NumDB> displayAll(){
        return jpaNum.findAll();
    }

    @Override
    public final NumDB newNumber(NumDB newNum){
        return jpaNum.save(newNum);
    }

    @Override
    public final int byId(Long id){
        return jpaNum.findById(id).get().getNum();
    }

    @Override
    public final Optional<NumDB> edit(final Long id, final NumDB newNum){
        return jpaNum.findById(id)
                .map(numDB -> {
                    numDB.setNum(newNum.getNum());
                    return jpaNum.save(numDB);
                });
    }

    @Override
    public final void delete(final Long id){
        jpaNum.deleteById(id);
    }

    @Override
    public final Long newVal(final int num){
        return jpaNum.save(new NumDB(num)).getId();
    }

    @Override
    public final String readName(final String name){
        if (name.equals("sum")){
            return name;
        }
        if (name.equals("razn")){
            return name;
        }
        if (name.equals("mult")){
            return name;
        }
        if (name.equals("div")){
            return name;
        }
        else return "Not operation";
    }

    @Override
    public final int actionOper(final List<Long> id, final String name){
        int result = 0;

        if (!id.isEmpty()){
            if (name.equals("sum")){
                for (Long i : id){
                    result += jpaNum.findById(i).get().getNum();
                }
            }
            if (name.equals("razn")){
                for (Long i : id){
                    result -= jpaNum.findById(i).get().getNum();
                }
            }
            if (name.equals("mult")){
                result = 1;
                for (Long i : id){
                    result *= jpaNum.findById(i).get().getNum();
                }
            }
            if (name.equals("div")){
                result = 1;
                for (Long i : id){
                    result /= jpaNum.findById(i).get().getNum();
                }
            }
            jpaInfo.save(new NumInfo(name, result));
        }
        return result;
    }

    @Override
    public final NumInfo getNewNumInfo(final NumInfo numInfo){
        return jpaInfo.save(new NumInfo(numInfo.getName(), numInfo.getResult()));
    }

    @Override
    public final Optional<NumInfo> editNumInfo(final Long id, final NumInfo editNumInfo){
        return jpaInfo.findById(id)
                .map(numInfo -> {
                    numInfo.setName(editNumInfo.getName());
                    numInfo.setResult(editNumInfo.getResult());
                    return jpaInfo.save(numInfo);
                });
    }

    @Override
    public final void deleteTest(Long id){
        jpaInfo.deleteById(id);
    }
}