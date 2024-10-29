/*package com.example.BDSpringSD.Service;

import com.example.BDSpringSD.InterfaceService.IEstudianteService;
import com.example.BDSpringSD.Model.Estudiante;
import com.example.BDSpringSD.Repository.REstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService implements IEstudianteService  {

    // AQUI SE IMPLMENTAN LOS METODOS QUE ESTAN EN INTERFACE SERVICE

    // SE DEBE INYECTAR LA INTERFACE QUE EXITENDE DE JPA

    @Autowired
    private REstudiante repositorio;


    @Override
    public List<Estudiante> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Estudiante est) {
        repositorio.save(est);
    }

    @Override
    public Optional<Estudiante> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {

        repositorio.deleteById(id);

    }
}

 */
