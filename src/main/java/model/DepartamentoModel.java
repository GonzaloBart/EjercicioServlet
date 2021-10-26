package model;

import java.net.URL;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;

import com.mysql.cj.xdevapi.SessionFactory;

import dao.DepartamentoDao;
import entities.Departamento;
import utils.HibernateUtil;

public class DepartamentoModel {
	
	public static SessionFactory sessionFactory;

	private static Logger logger = LogManager.getLogger(DepartamentoModel.class);

	public static List<Departamento> leerDepartamento(int codigo) {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Departamento> departamentoList = null;
		try {		
			departamentoList = DepartamentoDao.getAllDepartamentos(session);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error al acceder a la BD" + e);	
		}
		return departamentoList;
	}

}
