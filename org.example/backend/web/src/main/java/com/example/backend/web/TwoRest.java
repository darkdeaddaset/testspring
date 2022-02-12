package com.example.backend.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "two", method = RequestMethod.GET)
public class TwoRest {

//    private Oper oper;
//
//    public TwoRest(final Oper oper){
//        this.oper = oper;
//    }

    @GetMapping("/str")
    public final String getMes(){
        return "My 2 test!";
    }

//    @GetMapping("/oper/operation = {operation}/id1 = {i}/id2 = {j}")
//    public final int getInt(@PathVariable String operation, @PathVariable Long i, @PathVariable Long j){
//        return oper.result_twoId(operation, i, j);
//    }
}
