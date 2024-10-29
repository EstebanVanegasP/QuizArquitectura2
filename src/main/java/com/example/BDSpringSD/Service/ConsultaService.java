package com.example.BDSpringSD.Service;

import com.example.BDSpringSD.InterfaceService.IConsultaService;
import com.example.BDSpringSD.Model.Consulta;
import com.example.BDSpringSD.Repository.RConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService implements IConsultaService {

    @Autowired
    private RConsulta repository;

    @Override
    public List<Consulta> listar() {
        return repository.findAll();
    }

    @Override
    public void guardar(Consulta consulta) {
        repository.save(consulta);
    }

    @Override
    public Optional<Consulta> obtenerPorId(int id) {
        return repository.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repository.deleteById(id);
    }
}
