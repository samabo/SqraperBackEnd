package com.qien.sqraper.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qien.sqraper.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
