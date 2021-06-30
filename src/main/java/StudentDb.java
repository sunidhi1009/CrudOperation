import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDb {
	   
	public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("org.hsqldb.jdbc.JDBCDriver()");
	            con = DriverManager.getConnection("jjdbc:hsqldb:hsql://localhost/mydb", "SA", "");
	        
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int AddDStudent(Student e){  
	        int status=0;  
	        try{  
	            Connection con=StudentDb.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into Student_management(full_name,password,email,country) values (?,?,?,?)");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getPassword());  
	            ps.setString(3,e.getEmail());  
	            ps.setString(4,e.getCountry());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(Student e){  
	        int status=0;  
	        try{  
	            Connection con=StudentDb.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update Student_management set full_name=?,password=?,email=?,country=? where id=?");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getPassword());  
	            ps.setString(3,e.getEmail());  
	            ps.setString(4,e.getCountry());  
	            ps.setInt(5,e.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=StudentDb.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from Student_management where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static Student getStudentId(int id){  
	        Student e=new Student();  
	          
	        try{  
	            Connection con=StudentDb.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from Student_management where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setPassword(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setCountry(rs.getString(5));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    public static List<Student> getAllStudent(){  
	        List<Student> list=new ArrayList<Student>();  
	          
	        try{  
	            Connection con=StudentDb.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from Student_management");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	Student e=new Student();  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setPassword(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setCountry(rs.getString(5));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
	    
	      public static List<Student> getRecords(int start,int total){  
	        List<Student> list=new ArrayList<Student>();  
	        try{  
	            Connection con=getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from Student_management limit "+(start-1)+","+total);  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	Student e=new Student();  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setEmail(rs.getString(4));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){System.out.println(e);}  
	        return list;
	      }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
