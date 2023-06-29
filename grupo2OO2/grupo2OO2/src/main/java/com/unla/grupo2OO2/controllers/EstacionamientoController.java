package com.unla.grupo2OO2.controllers;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

import com.unla.grupo2OO2.entities.Evento;
import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.EstacionamientoInteligente;
import com.unla.grupo2OO2.helpers.ViewRouteHelper;
import com.unla.grupo2OO2.service.IDispositivoService;
import com.unla.grupo2OO2.service.IEstacionamientoService;
import com.unla.grupo2OO2.service.IEventoService;
import com.unla.grupo2OO2.service.implementation.EstacionamientoService;

import org.modelmapper.ModelMapper;


@Controller
@RequestMapping("/")
public class EstacionamientoController {
	
	
	@Autowired
	@Qualifier("estacionamientoService")
	private IEstacionamientoService estacionamientoService;
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@GetMapping("/EstacionamientoInteligente")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.ESTACIONAMIENYO_INDEX);
		return model;
	}
	
	@GetMapping("/Estacionamiento")
	public ModelAndView estacionamiento() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.ESTACIONAMIENTO_VIEW);
		
		List<EstacionamientoInteligente> est = new ArrayList<EstacionamientoInteligente>();
		
		for(int i=0; i<estacionamientoService.getAll().size(); i++) {
			if(estacionamientoService.getAll().get(i).isActivo()==true) {
				est.add(estacionamientoService.getAll().get(i));
			}
		}
		model.addObject("estacionamientos", est);
		model.addObject("eventos", eventoService.getEventosEstacionamiento());
		
		return model;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/agregarEstacionamiento")
	public String newEstacionamiento(Model model) {
		model.addAttribute("estacionamiento", new EstacionamientoInteligente());
		return ViewRouteHelper.ESTACIONAMIENTO_ADD;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/DisEstacionamiento")
	public RedirectView estacionamiento(@ModelAttribute("estacionamiento") EstacionamientoInteligente estacionamiento) {
		
		System.out.println(estacionamiento);
		estacionamientoService.insertOrUpdate(estacionamiento);
		
		return new RedirectView(ViewRouteHelper.ESTACIONAMIENTO);
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/borrarDispositivoEstacionamiento")
	public ModelAndView borrar() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.ESTACIONAMIENYO_DELETE);
		List<EstacionamientoInteligente> dis = new ArrayList<EstacionamientoInteligente>();
		
		for(int i=0; i<estacionamientoService.getAll().size(); i++) {
			if(estacionamientoService.getAll().get(i).isActivo()==true) {
				dis.add(estacionamientoService.getAll().get(i));
			}
		}
		
		model.addObject("estacionamientos", dis);
		return model;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/borrarDispositivoEstacionamiento")
    public RedirectView borrar(@RequestParam("dispositivoId") int dispositivoId){
		estacionamientoService.remove(dispositivoId);
    	return new RedirectView(ViewRouteHelper.ESTACIONAMIENTO);
    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/agregarEvento")
    public ModelAndView agregarEvento(){
       ModelAndView mAV = new ModelAndView("Eventos/agregarEvento");
       Evento evento = new Evento();
       mAV.addObject("estacionamientos", estacionamientoService.getAll());
       mAV.addObject("evento", evento);
       return mAV;
    }
	
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/agregarEvento")
    public RedirectView agregarEvento(@RequestParam("dispositivoId") int dispositivoId,
    		@RequestParam("fecha") LocalDate fecha,
    		@RequestParam("horaDesde") LocalTime horaDesde,
    		@RequestParam("horaHasta") LocalTime horaHasta,
    		@RequestParam("descripcion") String descripcion){
    	EstacionamientoInteligente dispositivo = estacionamientoService.findById(dispositivoId); 
    	if (dispositivo != null) {      
    		estacionamientoService.agregarEvento(dispositivo, fecha, horaDesde, horaHasta, descripcion);
    	}
    	return new RedirectView(ViewRouteHelper.ESTACIONAMIENTO);
    }
}
