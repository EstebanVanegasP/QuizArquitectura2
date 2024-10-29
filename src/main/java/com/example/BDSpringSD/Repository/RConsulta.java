package com.example.BDSpringSD.Repository;

import com.example.BDSpringSD.Model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RConsulta extends JpaRepository<Consulta, Integer> {
}
