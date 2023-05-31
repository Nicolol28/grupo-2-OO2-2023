package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Evento;

public class EventoDao {
	
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) {
		tx.rollback();
		throw new HibernateException("ERROR en el acceso a la capa de datos");
	}

	@SuppressWarnings("deprecation")
	public int agregar(Evento evento) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(evento).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

}
