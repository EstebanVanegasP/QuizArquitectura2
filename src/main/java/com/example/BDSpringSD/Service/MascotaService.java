package com.example.BDSpringSD.Service;

import com.example.BDSpringSD.InterfaceService.IMascotaService;
import com.example.BDSpringSD.Model.Mascota;
import com.example.BDSpringSD.Repository.RMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private RMascota repositorio;

    @Override
    public List<Mascota> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Mascota mascota) {
        repositorio.save(mascota);
    }

    @Override
    public Optional<Mascota> editar(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }
}
