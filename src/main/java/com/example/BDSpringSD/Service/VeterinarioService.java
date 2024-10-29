package com.example.BDSpringSD.Service;

import com.example.BDSpringSD.InterfaceService.IVeterinarioService;
import com.example.BDSpringSD.Model.Veterinario;
import com.example.BDSpringSD.Repository.RVeterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService implements IVeterinarioService {

    @Autowired
    private RVeterinario repository;

    @Override
    public List<Veterinario> listar() {
        return repository.findAll();
    }

    @Override
    public void guardar(Veterinario veterinario) {
        repository.save(veterinario);
    }

    @Override
    public Optional<Veterinario> obtenerPorId(int id) {
        return repository.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repository.deleteById(id);
    }
}
