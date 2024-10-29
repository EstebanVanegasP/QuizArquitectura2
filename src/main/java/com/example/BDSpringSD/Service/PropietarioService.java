package com.example.BDSpringSD.Service;

import com.example.BDSpringSD.InterfaceService.IPropietarioService;
import com.example.BDSpringSD.Model.Propietario;
import com.example.BDSpringSD.Repository.RPropietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService implements IPropietarioService {

    @Autowired
    private RPropietario repositorio;

    @Override
    public List<Propietario> listar() {
        return repositorio.findAll();
    }


    @Override
    public void guardar(Propietario propietario) {
        repositorio.save(propietario);
    }

    @Override
    public Optional<Propietario> editar(Integer  id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(Integer  id) {
        repositorio.deleteById(id);
    }
}
