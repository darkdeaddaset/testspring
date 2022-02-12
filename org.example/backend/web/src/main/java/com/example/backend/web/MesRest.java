package com.example.backend.web;

import com.example.backend.bussines.Num;
import com.example.backend.bussines.Operation;
import com.example.backend.database.JpaNum;
import com.example.backend.database.NumDB;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "one", method = RequestMethod.GET)
public class MesRest implements MesController{

    private Num number;
    private JpaNum jpaNum;
    private List<Operation> operations;

    public MesRest(final Num number, final JpaNum jpaNum, final List<Operation> operations){
        this.number = number;
        this.jpaNum = jpaNum;
        this.operations = operations;
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
        return jpaNum.findAll();
    }

    //Внесения числа и получения его ID из БД
    @PostMapping("/num")
    @Override
    public final Long newNum(@RequestBody int i){
        return jpaNum.save(new NumDB(i)).getId();
        //return number.calc(i);
    }

    //Получение значения
    @GetMapping("/num/{id}")
    public final int getIdNum(@PathVariable Long id){
        return jpaNum.findById(id).get().getNum();
    }

    //Изменения значения и ID
    @PutMapping("/num/{id}")
    public final Optional<NumDB> editNum(@RequestBody NumDB newNum, @PathVariable Long id){
        return jpaNum.findById(id)
                .map(numDB -> {
                    numDB.setNum(newNum.getNum());
                    numDB.setId(newNum.getId());
                    return jpaNum.save(numDB);
                });
    }

    //Удалить данные по ID
    @DeleteMapping("/num/{id}")
    public final void delete(@PathVariable Long id){
        jpaNum.deleteById(id);
    }

    //Сумма по ID из БД
    @GetMapping("operation/sum/")
    public final int getSum(@RequestParam List<Long> id){
        int result = 0;

        for (int i=0; i<id.size(); i++){
            result += jpaNum.findById(id.get(i)).get().getNum();
            }
        return result;
    }

    @GetMapping("operation/razn")
    public final int getRazn(@RequestParam List<Long> id){
        int result = 0;
        for (int i=0; i<id.size(); i++){
            result -= jpaNum.findById(id.get(i)).get().getNum();
        }
        return result;
    }

    @GetMapping("/id/{i}")
    public final int getInt(@PathVariable Long i){
        return jpaNum.findById(i).get().getNum();
    }
}
