package com.qien.sqraper.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qien.sqraper.domain.Vacature;


@Repository
public interface VacatureRepository extends CrudRepository<Vacature, Long>{

}
