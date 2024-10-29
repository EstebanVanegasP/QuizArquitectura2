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
@RequestMapping("/propietarios")
public class PropietarioController {

    @Autowired
    private IPropietarioService propietarioService;

    @Autowired
    private IMascotaService mascotaService;

    @GetMapping("/listar")
    public String listarPropietarios(Model model) {
        model.addAttribute("propietarios", propietarioService.listar());
        return "propietarios";
    }

    @GetMapping("/nuevo")
    public String formAgregarPropietario(Model model) {
        model.addAttribute("propietario", new Propietario());
        return "formulario_propietario";
    }

    @PostMapping("/guardar")
    public String guardarPropietario(@ModelAttribute Propietario propietario) {
        propietarioService.guardar(propietario);
        return "redirect:/propietarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarPropietario(@PathVariable("id") Integer  id, Model model) {
        Optional<Propietario> propietario = propietarioService.editar(id);
        if (propietario.isPresent()) {
            model.addAttribute("propietario", propietario.get());
            return "formulario_propietario";
        }
        return "redirect:/propietarios/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPropietario(@PathVariable("id") Integer id) {
        propietarioService.eliminar(id);
        return "redirect:/propietarios/listar";
    }


    @GetMapping("/{propietarioId}/mascotas/nuevo")
    public String formAgregarMascota(@PathVariable("propietarioId") Integer propietarioId, Model model) {
        Mascota mascota = new Mascota();
        Optional<Propietario> propietario = propietarioService.editar(propietarioId);
        if (propietario.isPresent()) {
            mascota.setPropietario(propietario.get());
            model.addAttribute("mascota", mascota);
            model.addAttribute("propietarios", propietarioService.listar());
            return "formulario_mascota";
        }
        return "redirect:/propietarios/listar";
    }



    @PostMapping("/{propietarioId}/mascotas/guardar")
    public String guardarMascota(@PathVariable("propietarioId") Integer  propietarioId, @ModelAttribute Mascota mascota) {
        Optional<Propietario> propietario = propietarioService.editar(propietarioId);
        propietario.ifPresent(mascota::setPropietario);
        mascotaService.guardar(mascota);
        return "redirect:/propietarios/listar";
    }
}
