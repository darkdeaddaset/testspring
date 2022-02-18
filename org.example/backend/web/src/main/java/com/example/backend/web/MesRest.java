package com.example.backend.web;

import com.example.backend.bussines.justnum.justOper;
import com.example.backend.bussines.operation.oper;
import com.example.backend.database.NumDB;
import com.example.backend.database.NumInfo;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "one", method = RequestMethod.GET)
public class MesRest implements MesController{

    private List<oper> opers;
    private justOper justOper;
    private List<justOper> justOpers;

    public MesRest(final List<oper> opers,
                   final justOper justOper,
                   final List<justOper> justOpers){
        this.opers = opers;
        this.justOper = justOper;
        this.justOpers = justOpers;
    }

    //Чисто проверка
    @GetMapping("/str")
    @Override
    public final String getMes(){
        return "Test";
    }

    //Вывести все ID с числами
    @GetMapping("/nums")
    @Override
    public List<NumDB> all(){
        return justOper.displayAll();
    }

    //По-первому заданию
    @GetMapping("/nums/new/{num}")
    @Override
    public Long newVal(@PathVariable final int num){
        return justOper.newVal(num);
    }

    //Внесения числа и получения его ID из БД
    @PostMapping("/nums/new")
    @Override
    public final NumDB newNum(@RequestBody NumDB newNum){
        return justOper.newNumber(newNum);
    }

    //Получение значения по ID
    @GetMapping("/nums/x/{id}")
    @Override
    public final int getIdNum(@PathVariable Long id){
        return justOper.byId(id);
    }

    //Изменения значения и ID
    @PutMapping("/nums/{id}")
    @Override
    public final Optional<NumDB> editNum(@PathVariable Long id, @RequestBody NumDB newNum){
        return justOper.edit(id, newNum);
    }

    //Удалить данные по ID
    @DeleteMapping("/nums/{id}")
    @Override
    public final void delete(@PathVariable Long id){
        justOper.delete(id);
    }

    //Выбор операции, данные по ID
    @GetMapping("/oper/{name}/{id}")
    @Override
    public final String getResOper(@PathVariable String name, @PathVariable List<Long> id){
        int result = 0;

        for (oper o : opers){
            if (o.readName(name).equals(name)){
                result = o.actionOper(id);
                break;
            }
        }
        return String.format("Operation: %s, result: %d", name, result);
    }

    //Ручной выбор
    @GetMapping("/oper/test/{name}/{id}")
    @Override
    public final String getResTwo(@PathVariable String name, @PathVariable List<Long> id){
        int result = 0;

        for (justOper j : justOpers){
            if (j.readName(name).equals(name)){
                result = j.actionOper(id, name);
                break;
            }
        }
        return String.format("Operation: %s, result: %d", name, result);
    }

    //Внесение типа операции и результат
    @PostMapping("/oper/test")
    @Override
    public final NumInfo getNewNumInfo(@RequestBody NumInfo numInfo){
        return justOper.getNewNumInfo(numInfo);
    }

    //Изменение
    @PutMapping("/oper/test/{id}")
    @Override
    public final Optional<NumInfo> editNumInfo(@PathVariable Long id, @RequestBody NumInfo editNumInfo){
        return justOper.editNumInfo(id, editNumInfo);
    }

    //Удаление
    @DeleteMapping("/oper/test/{id}")
    @Override
    public final void deleteTest(@PathVariable Long id){
        justOper.deleteTest(id);
    }
}
