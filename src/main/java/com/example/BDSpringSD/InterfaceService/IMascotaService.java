package com.example.BDSpringSD.InterfaceService;

import com.example.BDSpringSD.Model.Mascota;
import java.util.List;
import java.util.Optional;

public interface IMascotaService {
    List<Mascota> listar();
    void guardar(Mascota mascota);
    Optional<Mascota> editar(Integer id);
    void eliminar(Integer id);

}
