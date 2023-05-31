package negocio;

import dao.DispositivoDao;
import datos.Dispositivo;

public class DispositivoAbm {
		
		private static DispositivoAbm instancia=null;
		public DispositivoAbm() {}
		public static DispositivoAbm getInstance(){
		if(instancia==null)
		instancia=new DispositivoAbm();
		return instancia;
		}
		
		/*// completar query de dispositivoDao
		
		public Dispositivo traerDispo(String nombre){
			  return DispositivoDao.getInstance().traerNombre(nombre);
				}	*/
		
	}