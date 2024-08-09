package com.company.repository;

import com.company.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository  extends JpaRepository<Emp, Integer> {


}
