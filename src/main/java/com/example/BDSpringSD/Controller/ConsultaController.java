package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.InterfaceService.IConsultaService;
import com.example.BDSpringSD.InterfaceService.IMascotaService;
import com.example.BDSpringSD.InterfaceService.IVeterinarioService;
import com.example.BDSpringSD.Model.Consulta;
import com.example.BDSpringSD.Model.Mascota;
import com.example.BDSpringSD.Model.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private IConsultaService consultaService;

    @Autowired
    private IMascotaService mascotaService;

    @Autowired
    private IVeterinarioService veterinarioService;

    @GetMapping("/listar")
    public String listarConsultas(Model model) {
        model.addAttribute("consultas", consultaService.listar());
        return "consultas";
    }

    @GetMapping("/nuevo")
    public String formAgregarConsulta(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("mascotas", mascotaService.listar());
        model.addAttribute("veterinarios", veterinarioService.listar());
        return "formulario_consulta";
    }

    @PostMapping("/guardar")
    public String guardarConsulta(@ModelAttribute Consulta consulta) {
        Optional<Mascota> mascotaOpt = mascotaService.editar(consulta.getMascotaId());
        Optional<Veterinario> veterinarioOpt = veterinarioService.obtenerPorId(consulta.getVeterinarioId());

        if (mascotaOpt.isPresent() && veterinarioOpt.isPresent()) {
            consulta.setMascota(mascotaOpt.get());
            consulta.setVeterinario(veterinarioOpt.get());
            consultaService.guardar(consulta);
            return "redirect:/consultas/listar";
        } else {
            return "redirect:/consultas/nueva?error=true";
        }
    }

    @GetMapping("/editar/{id}")
    public String editarConsulta(@PathVariable("id") int id, Model model) {
        Optional<Consulta> consultaOpt = consultaService.obtenerPorId(id);
        if (consultaOpt.isPresent()) {
            Consulta consulta = consultaOpt.get();
            consulta.setMascotaId(consulta.getMascota().getId());
            consulta.setVeterinarioId(consulta.getVeterinario().getId());
            model.addAttribute("consulta", consulta);
            model.addAttribute("mascotas", mascotaService.listar());
            model.addAttribute("veterinarios", veterinarioService.listar());
            return "formulario_consulta";
        }
        return "redirect:/consultas/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarConsulta(@PathVariable("id") int id) {
        consultaService.eliminar(id);
        return "redirect:/consultas/listar";
    }
}
