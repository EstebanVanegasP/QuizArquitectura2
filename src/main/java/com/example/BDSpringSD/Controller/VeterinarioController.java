package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.Model.Veterinario;
import com.example.BDSpringSD.Service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService service;

    @GetMapping("/listar")
    public String listarVeterinarios(Model model) {
        model.addAttribute("veterinarios", service.listar());
        return "veterinarios";
    }

    @GetMapping("/nuevo")
    public String formAgregarVeterinario(Model model) {
        model.addAttribute("veterinario", new Veterinario());
        return "formulario_veterinario";
    }

    @PostMapping("/guardar")
    public String guardarVeterinario(@ModelAttribute Veterinario veterinario) {
        service.guardar(veterinario);
        return "redirect:/veterinarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarVeterinario(@PathVariable("id") int id, Model model) {
        Optional<Veterinario> veterinario = service.obtenerPorId(id);
        if (veterinario.isPresent()) {
            model.addAttribute("veterinario", veterinario.get());
            return "formulario_veterinario";
        }
        return "redirect:/veterinarios/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVeterinario(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/veterinarios/listar";
    }
}
