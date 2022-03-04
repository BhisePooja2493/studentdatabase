

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        this.studentDAO=new StudentDAO();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.doGet(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
		String action=request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertStudent(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/delete":
			try {
			    deleteStudent(request, response);
			}catch(IOException e) {
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
			    updateStudent(request, response);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;	
		default:
			try {
				listStudent(request, response);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
			
			
		}
		
		
		
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String date_of_birth=request.getParameter("date_of_birth");
		String date_of_joining=request.getParameter("date_of_joining");
		Student newStudent=new Student(name,date_of_birth,date_of_joining);
		try {
			studentDAO.insertStudent(newStudent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
		
		
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Student existingUser=studentDAO.selectStudent(id);
	
		RequestDispatcher dispatcher=request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student",existingUser);
		dispatcher.forward(request, response);
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		studentDAO.deleteStudent(id);
		response.sendRedirect("list");
	}
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String date_of_birth=request.getParameter("date_of_birth");
		String date_of_joining=request.getParameter("date_of_joining");
		
		Student book=new Student(id,name,date_of_birth,date_of_joining);
		studentDAO.updateStudent(book);
		response.sendRedirect("list");
	}
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		List<student> listStudent=studentDAO.selectAllStudents();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher=request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);
		
	}
}
