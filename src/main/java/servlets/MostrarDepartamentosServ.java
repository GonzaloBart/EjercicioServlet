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
import entities.Departamento;
import entities.Empleado;
import utils.HibernateUtil;

/**
 * Servlet implementation class MostrarDepartamentosServ
 */
@WebServlet("/MostrarDepartamentos")
public class MostrarDepartamentosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarDepartamentosServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String codigo = request.getParameter("codigo");
		out.print("<table><tr><th>Codigo</th><th>Codigo Responsable</th><th>Nombre</th><tr>");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			List<Departamento> departamentoList = null;

			departamentoList = DepartamentoDao.getAllDepartamentos(session);


			for (Departamento departamento : departamentoList) {

				out.print("<tr><td>");
				out.print(departamento.getCodigo());
				out.print("</td>");
				out.print("<td>");
				out.print(departamento.getCodResponsable());
				out.print("</td>");
				out.print("<td>");
				out.print(departamento.getNombre());
				out.print("</td>");
				out.print("</tr>");
	
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		out.print("</table>");



		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
