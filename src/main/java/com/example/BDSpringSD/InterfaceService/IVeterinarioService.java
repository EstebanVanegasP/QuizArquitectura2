package com.example.BDSpringSD.InterfaceService;

import com.example.BDSpringSD.Model.Veterinario;
import java.util.List;
import java.util.Optional;

public interface IVeterinarioService {
    List<Veterinario> listar();
    void guardar(Veterinario veterinario);
    Optional<Veterinario> obtenerPorId(int id);
    void eliminar(int id);
}
