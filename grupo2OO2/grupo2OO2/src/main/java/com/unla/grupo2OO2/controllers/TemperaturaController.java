package com.unla.grupo2OO2.controllers;


import java.time.LocalDate;
import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.DispositivoTemperatura;
import com.unla.grupo2OO2.entities.Evento;
import com.unla.grupo2OO2.helpers.ViewRouteHelper;
import com.unla.grupo2OO2.models.SensorTemperaturaModel;
import com.unla.grupo2OO2.service.IDispositivoService;
import com.unla.grupo2OO2.service.IEventoService;


@Controller
@RequestMapping("/")
public class TemperaturaController {
	
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	private ModelMapper modelMapper = new ModelMapper();
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/dispositivoTemperatura")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.TEMPERATURA_INDEX);
		return model;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/newDisTemperatura")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.TEMPERATURA_NEW);
		mAV.addObject("sensor", new SensorTemperaturaModel());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public RedirectView agregarSensor(@ModelAttribute("sensor") SensorTemperaturaModel sensorTemperaturaModel) {
		
		dispositivoService.insertOrUpdate(modelMapper.map(sensorTemperaturaModel, DispositivoTemperatura.class));
		
		return new RedirectView(ViewRouteHelper.TEMPERATURA);
	}
	
	@GetMapping("/mostrar")
	public ModelAndView mostrarSensores() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.TEMPERATURALIST);
		mAV.addObject("sensores",dispositivoService.finBySensor());
		mAV.addObject("eventos", eventoService.getEventosTemperatura());
		return mAV;
		
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_UPDATE);
		DispositivoTemperatura dispositivo = (DispositivoTemperatura) dispositivoService.findById(id);
		SensorTemperaturaModel sensorTemperatura = modelMapper.map(dispositivo,SensorTemperaturaModel.class);
		mAV.addObject("sensor", sensorTemperatura);
		return mAV;
	}

	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("sensor") DispositivoTemperatura sensorTemperatura) {
		DispositivoTemperatura sensor = modelMapper.map(sensorTemperatura, DispositivoTemperatura.class);
		if(sensorTemperatura.getId() > 0) {
			DispositivoTemperatura sensorOld = modelMapper.map(dispositivoService.findById(sensorTemperatura.getId()),DispositivoTemperatura.class);
			
			sensor.setActivo(sensorOld.isActivo());
			sensor.setEventos(sensorOld.getEventos());
			sensor.setId(sensorOld.getId());
			sensor.setNombre(sensorOld.getNombre());
			sensor.setCreatedAt(sensorOld.getCreatedAt());
		}
		
		dispositivoService.insertOrUpdate(sensor);
		
		return new RedirectView(ViewRouteHelper.TEMPERATURA);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/borrarDispositivoTemperatura")
	public ModelAndView borrar() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.TEMPERATURA_DELETE);
		
		model.addObject("sensores", dispositivoService.finBySensor());
		return model;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/eliminarDispositivoTemperatura")
    public RedirectView borrar(@RequestParam("dispositivoId") int dispositivoId){
	    dispositivoService.remove(dispositivoId);
    	return new RedirectView(ViewRouteHelper.TEMPERATURA);
    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/newEvento")
    public ModelAndView agregarEvento(){
       ModelAndView mAV = new ModelAndView("disTemperatura/agregarEvento");
       Evento evento = new Evento();
       mAV.addObject("sensores", dispositivoService.finBySensor());
       mAV.addObject("evento", evento);
       return mAV;
    }
	
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addEvento")
    public RedirectView agregarEvento(@RequestParam("dispositivoId") int dispositivoId,
    		@RequestParam("fecha") LocalDate fecha,
    		@RequestParam("horaDesde") LocalTime horaDesde,
    		@RequestParam("descripcion") String descripcion){
    	Dispositivo dispositivo = dispositivoService.findById(dispositivoId); 
    	Evento ev = new Evento();
    	ev.setDescripcion(descripcion);
    	ev.setDia(fecha);
    	ev.setDispositivo(dispositivo);
    	ev.setHoraDesde(horaDesde);
    	eventoService.insertOrUpdate(ev);
    	return new RedirectView(ViewRouteHelper.TEMPERATURA);
    }


}
