package com.ejemplo.notasweb.controller;

import com.ejemplo.notasweb.model.Nota;
import com.ejemplo.notasweb.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotaController {

    @Autowired
    private NotaRepository repo;

    @GetMapping("/")
    public String listarNotas(Model model) {
        model.addAttribute("notas", repo.findAll());
        return "index"; // templates/index.html
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaNota(Model model) {
        model.addAttribute("nota", new Nota());
        return "formulario"; // templates/formulario.html
    }

    @PostMapping("/guardar")
    public String guardarNota(@ModelAttribute Nota nota) {
        repo.save(nota);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editarNota(@PathVariable Long id, Model model) {
        Nota nota = repo.findById(id).orElse(null);
        if (nota == null) {
            return "redirect:/";
        }
        model.addAttribute("nota", nota);
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarNota(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
