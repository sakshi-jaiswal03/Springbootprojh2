package com.company.service;

import com.company.entity.Emp;
import com.company.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpService {


        List<Emp> employeeList = new ArrayList<>(Arrays.asList(
                new Emp(1, "Abc", "Mum"),
                new Emp(2, "Def", "Del"),
                new Emp(3, "Xyz", "Up")
        ));

        @Autowired
        EmpRepository empRepository;
        public List<Emp> getAllEmp(){
            return employeeList;
        }

        public Emp getAnEmp(int id){
            return employeeList.stream().filter(e -> (
                    e.getEmpId() == id)).findFirst().get();
        }

        public void createEmp(Emp emp){
            //employeeList.add(emp);
            empRepository.save(emp);
        }

        public void updateEmp(Emp emp){
            List<Emp> tempEmp = new ArrayList<>();
            for(Emp emp1: employeeList){
                if (emp1.getEmpId() == emp.getEmpId()) {
                    emp1.setEmpName(emp.getEmpName());
                    emp1.setEmpCity(emp.getEmpCity());
                }
                tempEmp.add(emp1);
            }
            this.employeeList = tempEmp;
        }

    public void deleteEmp(int id){
        ArrayList<Emp> tempEmp = new ArrayList<>();
        for(Emp emp: employeeList){
            if (emp.getEmpId() == id)
                continue;
                tempEmp.add(emp);
        }
        this.employeeList = tempEmp;
    }
}
