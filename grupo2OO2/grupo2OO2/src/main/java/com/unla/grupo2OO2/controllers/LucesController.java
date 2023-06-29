package com.unla.grupo2OO2.controllers;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo2OO2.entities.LucesInteligente;
import com.unla.grupo2OO2.helpers.ViewRouteHelper;
import com.unla.grupo2OO2.service.IEventoService;
import com.unla.grupo2OO2.service.ILucesService;
import com.unla.grupo2OO2.entities.Evento;

import org.modelmapper.ModelMapper;


@Controller
@RequestMapping("/")
public class LucesController {
	
	
	@Autowired
	@Qualifier("lucesService")
	private ILucesService lucesService;
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@GetMapping("/LucesInteligente")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.LUCES_INDEX);
		return model;

	}
	
	
	@GetMapping("/Luces")
	public ModelAndView luces() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.LUCES_VIEW);
		
		model.addObject("luces", lucesService.getAll());
		model.addObject("eventos", eventoService.getEventosLuces());
		
		return model;
	}
	
	@GetMapping("/agregarLuces")
	public String newLuces(Model model) {
		model.addAttribute("luces", new LucesInteligente());
		return ViewRouteHelper.LUCES_ADD;
	}
	
	
	@PostMapping("/DisLuces")
	public RedirectView luces(@ModelAttribute("luces") LucesInteligente luces) {
		
		System.out.println(luces);
		lucesService.insertOrUpdate(luces);
		
		return new RedirectView(ViewRouteHelper.LUCES);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/agregarEventoLuces")
    public ModelAndView agregarEvento(){
       ModelAndView mAV = new ModelAndView("luces/agregarEvento");
       Evento evento = new Evento();
       mAV.addObject("estacionamientos", lucesService.getAll());
       mAV.addObject("evento", evento);
       return mAV;
    }
	
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/agregarEventoLuces")
    public RedirectView agregarEvento(@RequestParam("dispositivoId") int dispositivoId,
    		@RequestParam("fecha") LocalDate fecha,
    		@RequestParam("horaDesde") LocalTime horaDesde,
    		@RequestParam("horaHasta") LocalTime horaHasta,
    		@RequestParam("descripcion") String descripcion){
    	LucesInteligente dispositivo = lucesService.findById(dispositivoId); 
    	if (dispositivo != null) {      
    		lucesService.agregarEvento(dispositivo, fecha, horaDesde, horaHasta, descripcion);
    	}
    	return new RedirectView(ViewRouteHelper.LUCES);
    }
}
