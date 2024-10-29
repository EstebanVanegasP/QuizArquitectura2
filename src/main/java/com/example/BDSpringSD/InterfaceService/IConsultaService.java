package com.example.BDSpringSD.InterfaceService;

import com.example.BDSpringSD.Model.Consulta;
import java.util.List;
import java.util.Optional;

public interface IConsultaService {
    List<Consulta> listar();
    void guardar(Consulta consulta);
    Optional<Consulta> obtenerPorId(int id);
    void eliminar(int id);
}
