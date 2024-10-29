package com.example.BDSpringSD.Repository;

import com.example.BDSpringSD.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RMascota extends JpaRepository<Mascota, Integer> {
}