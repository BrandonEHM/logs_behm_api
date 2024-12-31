package com.upiiz.logss.repositories;


import com.upiiz.logss.entities.LogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<LogEntity, Long> {
}