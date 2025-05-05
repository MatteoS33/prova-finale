/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progetto.biblioteca.Progetto;

/**
 *
 * @author pc
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LibroController {

    // Lista in memoria per simulare il database
    private List<Libro> libri = new ArrayList<>();

    // Visualizza la lista dei libri e il form per aggiungerne uno
    @GetMapping("/")
    public String visualizzaLibri(Model model) {
        model.addAttribute("libri", libri); // Passiamo la lista dei libri al template
        model.addAttribute("libro", new Libro()); // Aggiungiamo un nuovo libro per il form
        return "index"; // Visualizza tutto sulla stessa pagina
    }

    // Gestisce l'invio del form per aggiungere un libro
    @PostMapping("/")
    public String aggiungiLibro(@ModelAttribute Libro libro, Model model) {
        libri.add(libro); // Aggiunge il libro alla lista in memoria
        model.addAttribute("libri", libri); // Rende la lista aggiornata disponibile per il template
        return "index"; // Ritorna alla stessa pagina con la lista aggiornata
    }
}