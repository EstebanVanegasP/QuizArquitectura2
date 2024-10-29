package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.InterfaceService.IMascotaService;
import com.example.BDSpringSD.InterfaceService.IPropietarioService;
import com.example.BDSpringSD.Model.Mascota;
import com.example.BDSpringSD.Model.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private IMascotaService service;

    @GetMapping("/listar")
    public String listarMascotas(Model model) {
        model.addAttribute("mascotas", service.listar());
        return "mascotas";
    }

    @Autowired
    private IPropietarioService propietarioService;

    @GetMapping("/nuevo")
    public String formAgregarMascota(Model model) {
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("propietarios", propietarioService.listar());
        return "formulario_mascota";
    }



    @PostMapping("/guardar")
    public String guardarMascota(@ModelAttribute Mascota mascota) {
        if (mascota.getPropietario() != null && mascota.getPropietario().getId() != null) {
            Optional<Propietario> propietarioOpt = propietarioService.editar(mascota.getPropietario().getId());
            propietarioOpt.ifPresent(mascota::setPropietario);
        } else {
            return "redirect:/mascotas/nuevo?error=true";

        }
        service.guardar(mascota);
        return "redirect:/mascotas/listar";
    }





    @GetMapping("/editar/{id}")
    public String editarMascota(@PathVariable("id") Integer id, Model model) {
        Optional<Mascota> mascota = service.editar(id);
        if (mascota.isPresent()) {
            model.addAttribute("mascota", mascota.get());
            return "formulario_mascota";
        }
        return "redirect:/mascotas/listar";
    }



    @PostMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/mascotas/listar";
    }



}
