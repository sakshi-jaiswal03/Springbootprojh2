package com.company.controller;

import com.company.entity.Emp;
import com.company.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
public class EmpController {
    @Autowired
    public EmpService empService;

    @RequestMapping("/employees")
    public List<Emp> findAllEmp(){
         return empService.getAllEmp();
    }

    @RequestMapping("/employees/{id}")
    public Emp findAnEmp(@PathVariable int id){
        return empService.getAnEmp(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public void createEmp(@RequestBody Emp emp){
        empService.createEmp(emp);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public void updateEmp(@PathVariable int id, @RequestBody Emp emp){
        empService.updateEmp(emp);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public List<Emp> deleteEmp(@PathVariable int id){
        empService.deleteEmp(id);
         return empService.getAllEmp();
    }
}
