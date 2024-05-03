package com.aluraSpring.screenmatch.repository;

import com.aluraSpring.screenmatch.Model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISerieRepository extends JpaRepository<Serie,Long> {
}
