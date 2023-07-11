package com.unla.grupo2OO2.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	//HOME
	public final static String INDEX = "/index";
	public final static String HELLO = "home/hello";

	//dispositivos
	public final static String DISPOSITIVO_INDEX ="dispositivo/index";
	public final static String DISPOSITIVO_VIEW ="dispositivo/Dispositivo";
	public final static String DISPOSITIVO_DELETE ="dispositivo/borrar";
	public final static String DISPOSITIVO_EV_X_DISPO ="dispositivo/formConsultaDispositivo";
	public final static String DISPOSITIVO_EV_VIEW ="dispositivo/viewConsulta";
	
	
	public final static String ESTACIONAMIENYO_INDEX="estacionamiento/index";
	public final static String ESTACIONAMIENTO_VIEW ="estacionamiento/Estacionamiento";
	public final static String ESTACIONAMIENTO_ADD="estacionamiento/agregarEstacionamiento";
	public final static String ESTACIONAMIENYO_DELETE="estacionamiento/borrar";
	
	public final static String LUCES_INDEX="luces/index";
	public final static String LUCES_VIEW ="luces/Luces";
	public final static String LUCES_ADD="luces/agregarLuces";
	public final static String LUCES_DELETE="luces/borrar";
	
	public final static String TEMPERATURA_INDEX="disTemperatura/index";
	public final static String TEMPERATURA_NEW="disTemperatura/new";
	public final static String TEMPERATURALIST="disTemperatura/mostrarSensores";
	public final static String TEMPERATURA_DELETE="disTemperatura/borrar";
	public final static String SENSOR_UPDATE="disTemperatura/sensorUpdate";
	

	//USER
	public final static String USER_LOGIN = "login";
	public final static String USER_LOGOUT = "logout";
	
	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String ESTACIONAMIENTO="/EstacionamientoInteligente";
	public final static String LUCES="/LucesInteligente";
	public final static String DISPOSITIVO="/DispositivosInteligentes";
	public final static String TEMPERATURA="/dispositivoTemperatura";

}
