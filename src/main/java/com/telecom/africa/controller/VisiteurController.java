package com.telecom.africa.controller;

import com.telecom.africa.model.Visiteur;
import com.telecom.africa.repository.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisiteurController {

    @Autowired
    private VisiteurRepository visiteurRepository;

    @GetMapping("/")
    public String accueil(Model model) {
        model.addAttribute("visiteurs", visiteurRepository.findAll());
        return "index";
    }

    @PostMapping("/register")
    public String enregistrement(@RequestParam MultiValueMap body) {
        Visiteur visiteur = new Visiteur();
        visiteur.setNom((String) body .getFirst("nom"));
        visiteur.setPrenom((String) body .getFirst("prenom"));
        visiteurRepository.save(visiteur);
        return "redirect:/";
    }
}
