/*package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.InterfaceService.IEstudianteService;
import com.example.BDSpringSD.Model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class EstudianteController {

    @Autowired
    private IEstudianteService service;


    @GetMapping("/listar")
    public String listarEstudiantes(Model model){

        model.addAttribute("titulo","Spring DB");
        model.addAttribute("cuerpo","LISTA DE ESTUDIANTES");

        model.addAttribute("datos", service.listar());
        return "index";
    }

    @GetMapping("/nuevo")
    public String formAgregarEstufiantes(Model model){

        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "USUARIO NUEVO");

        model.addAttribute("estu",new Estudiante());
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Estudiante est){

        service.guardar(est);

        return "redirect:/listar";
    }


    @GetMapping("/editar/{id}")
    public String editarEstudiante(@PathVariable("id") int id, Model model){

       Optional<Estudiante> est =  service.editar(id);

        model.addAttribute("estu", service.editar(id));

        return "nuevo";

    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable("id") int id){

       service.eliminar(id);

        return "redirect:/listar";

    }


}

 */
