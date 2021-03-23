package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classesEJB.Activity;
import classesEJB.Person;
import facade.FacadeLocal;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private FacadeLocal facade;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>Person - Activity demo</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		
		out.println("<h3>Skapar en Person och en Activity</h3>");
		
		//Skapar en person
		Person p = new Person();
		p.setPersonId("931114");
		p.setName("Martin Klingstedt");
		p.setAddress("Vimpelgatan 11, Malmö");
		p.setUsername("martinklingstedt");
		p.setPassword("lösenord123");
		
		facade.createPerson(p);
		out.println("<br>");
		out.println("Person " + p.getName() + " with person id " + p.getPersonId() + " is created");
		
		//Skapar en activity		
		facade.createActivity("A2", "2021-03-23", "Running", 55.5, 11.0, "Felt GREAT!", p.getPersonId());
		
		out.println("<br><h3>Alla personer:</h3>");
		List<Person> allPersons = facade.findAllPersons();
		for (Person person : allPersons) {
			out.print("<h5>Hittade person med namn: " + person.getName());
			out.println(" och personnummer: " + person.getPersonId() +"</h5>");
		}
		
		out.println("</body></html>");
	}

}
