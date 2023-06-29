package com.unla.grupo2OO2.controllers;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.EstacionamientoInteligente;
import com.unla.grupo2OO2.helpers.ViewRouteHelper;
import com.unla.grupo2OO2.service.IDispositivoService;
import com.unla.grupo2OO2.service.IEventoService;

@Controller
@RequestMapping("/")
public class DispositivoController {
	
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;
	
	
	@GetMapping("/DispositivosInteligentes")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.DISPOSITIVO_INDEX);

		return model;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/borrarDispositivo")
	public ModelAndView borrar() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.DISPOSITIVO_DELETE);
		List<Dispositivo> dis = new ArrayList<Dispositivo>();
		
		for(int i=0; i<dispositivoService.getAll().size(); i++) {
			if(dispositivoService.getAll().get(i).isActivo()==true) {
				dis.add(dispositivoService.getAll().get(i));
			}
		}
		
		
		model.addObject("dispositivos", dis);
		return model;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/borrarDispositivo")
    public RedirectView borrar(@RequestParam("dispositivoId") int dispositivoId){
    	dispositivoService.remove(dispositivoId);
    	return new RedirectView(ViewRouteHelper.DISPOSITIVO);
    }
	
	
	@GetMapping("/Dispositivos")
	public ModelAndView estacionamiento() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.DISPOSITIVO_VIEW);
		
		List<Dispositivo> dis = new ArrayList<Dispositivo>();
		
		for(int i=0; i<dispositivoService.getAll().size(); i++) {
			if(dispositivoService.getAll().get(i).isActivo()==true) {
				dis.add(dispositivoService.getAll().get(i));
			}
		}
		
		model.addObject("dispositivos", dis);
		
		return model;
	}
}
