package dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;



public class DispositivoDao {
	private static Session session;
	private Transaction tx;
	private static DispositivoDao instancia = null;

	protected DispositivoDao() {
	}

	public static DispositivoDao getInstance() {
		if (instancia == null)
			instancia = new DispositivoDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	//falta base de datos para las querys
/* 
	public Dispositivo traerNombre(String nombre) {
		Dispositivo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Dispositivo) session.createQuery() //completar query
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	*/
}