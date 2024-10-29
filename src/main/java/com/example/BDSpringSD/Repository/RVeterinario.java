package com.example.BDSpringSD.Repository;

import com.example.BDSpringSD.Model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RVeterinario extends JpaRepository<Veterinario, Integer> {
}
