package dao;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entities.Empleado;
import utils.HibernateUtil;



public class EmpleadoDao {



	public static void insertEmpleado(Session s, Empleado empleado) {
		s.saveOrUpdate(empleado);
	}

	public static Empleado readEmpleado(Session s, int codigo) {		
		String hQuery = " from Empleado e " +
				" where e.codigo = :codigo";
		Empleado empleado = s.createQuery(hQuery, Empleado.class)
				.setParameter("codigo", codigo)
				.setMaxResults(1)
				.uniqueResult();

		return empleado;
	}

	/** 
	 * No hace falta por que en insertar puede insertar o actualizar
	public static void updateEmpleado(Session s, Empleado empleado) {
		s.update(empleado);
	}
	 */

	public static void deleteEmpleado(Session s, Empleado empleado) {
		s.delete(empleado);
	}

	// hql queries
	public static List<Empleado> getAllEmpleado() {
		return getAllEmpleados(HibernateUtil.retrieveSession());
	}

	public static List<Empleado> getAllEmpleados(Session s) {
		String hQuery = "from Empleado";
		List<Empleado> empleadoList = s.createQuery(hQuery, Empleado.class).getResultList();
		return empleadoList;
	}


}
