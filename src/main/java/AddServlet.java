import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

        PrintWriter out=response.getWriter();  
       String spageid=request.getParameter("page");  
       int pageid=Integer.parseInt(spageid);  
       int total=5;  
       if(pageid==1){}  
       else{  
           pageid=pageid-1;  
           pageid=pageid*total+1;  
       }  
       List<Student> list=StudentDb.getRecords(pageid,total); 
        out.println("<a href='index.html'>Add Employee</a>");  
 
       out.print("<h1>W3adda EMP LIST Page No: "+spageid+"</h1>");  
       out.print("<table border='1' cellpadding='4' width='60%'>");  
       out.print("<tr><th>Id</th><th>Name</th><th>Email</th>");  
       for(Student e:list){  
           out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td></tr>");  
       }  
       out.print("</table>");  
         
       out.print("<a href='ViewEmpServlet?page=1'>1</a> ");  
       out.print("<a href='ViewEmpServlet?page=2'>2</a> ");  
       out.print("<a href='ViewEmpServlet?page=3'>3</a> ");  
         
       out.close();  
       
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
