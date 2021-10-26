package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.DepartamentoDao;
import dao.EmpleadoDao;
import entities.Departamento;
import entities.Empleado;
import utils.HibernateUtil;

/**
 * Servlet implementation class MostrarEmpleadosServ
 */
@WebServlet("/MostrarEmpleados")
public class MostrarEmpleadosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarEmpleadosServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		//String codigo = request.getParameter("codigo");
		out.print("<table><tr><th>Codigo</th><th>Nombre</th><th>Apellido 1</th><th>Apellido2</th><th> Cod Departamento</th><th>Puesto</th><th>Direccion</th><th>Fecha Nacimiento</th><th>Lugar Nacimiento</th><th>Telefono</th><th><tr>");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			List<Empleado> empleadoList = null;

			empleadoList = EmpleadoDao.getAllEmpleados(session);

		
			for (Empleado empleado : empleadoList) {

				out.print("<tr><td>");
				out.print(empleado.getCodigo());
				out.print("</td>");
				out.print("<td>");
				out.print(empleado.getNombre());
				out.print("</td>");
				out.print("<td>");
				out.print(empleado.getApellido1());
				out.print("</td>");
				out.print("<td>");
				out.print(empleado.getApellido2());
				out.print("</td>");
				out.print("<td>");
				out.print(empleado.getCodDepartamento());
				out.print("</td>");
				out.print("<td>");
				out.print(empleado.getPuesto());
				out.print("</td>");
				out.print("<td>");
				out.print(empleado.getDireccion());
				out.print("</td>");
				out.print("<td>");
				out.print(empleado.getFechaNacimiento());
				out.print("</td>");
				out.print("<td>");
				out.print(empleado.getLugarNacimiento());
				out.print("</td>");
				out.print("<td>");
				out.print(empleado.getTelefono());
				out.print("</td>");
				out.print("</tr>");

			}

		} catch (Exception e){
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
