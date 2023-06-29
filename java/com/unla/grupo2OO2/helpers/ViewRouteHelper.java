package com.unla.grupo2OO2.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	//HOME
	public final static String INDEX = "/index";
	public final static String HELLO = "home/hello";

	//dispositivos
	public final static String ESTACIONAMIENYO_INDEX="estacionamiento/index";
	public final static String ESTACIONAMIENTO_VIEW ="estacionamiento/Estacionamiento";
	public final static String ESTACIONAMIENTO_ADD="estacionamiento/agregarEstacionamiento";
	
	public final static String LUCES_INDEX="luces/index";
	public final static String LUCES_VIEW ="luces/Luces";
	public final static String LUCES_ADD="luces/agregarLuces";

	//USER
	public final static String USER_LOGIN = "login";
	public final static String USER_LOGOUT = "logout";

	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String ESTACIONAMIENTO="/EstacionamientoInteligente";
	public final static String LUCES="/LucesInteligente";
}
