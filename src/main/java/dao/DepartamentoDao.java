package dao;




import java.util.List;

import org.hibernate.Session;

import entities.Departamento;
import entities.Empleado;



public class DepartamentoDao {

	public static void insertDepartamento(Session s, Departamento departamento) {
		s.save(departamento);
	}

	public static Departamento readDepartamento(Session s, int codigo) {
		String hQuery = " from Departamento d " +
				" where d.codigo = :codigo";
		Departamento departamento = s.createQuery(hQuery, Departamento.class)
				.setParameter("codigo", codigo)
				.setMaxResults(1)
				.uniqueResult();

		return departamento;
	}

	public static void updateDepartamento(Session s, Departamento departamento) {
		s.update(departamento);
	}

	public static void deleteDepartamento(Session s, Departamento departamento) {
		s.delete(departamento);
	}

	public static List<Departamento> getAllDepartamentos(Session s) {
		String hQuery = "from Departamento";
		List<Departamento> departaamentoList = s.createQuery(hQuery, Departamento.class).getResultList();
		return departaamentoList;
	}
}
