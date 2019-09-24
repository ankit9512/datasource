package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import entity.RegisterStudent;

public class StudentDAO implements StudentDAOInterface {
	
	private StudentDAO(){}

	public static StudentDAO createDaoObject(String string) {
		
		return new StudentDAO();
	}

	public int createProfileDao(RegisterStudent rs) {
		int i=1;
		try{
			
			InitialContext ctx=new InitialContext();
			DataSource ds=null;
			ds=(DataSource)ctx.lookup("java:/zensar");
			Connection con=ds.getConnection();
			
			PreparedStatement ps=con.prepareStatement("insert into facebookemployee values(?,?,?,?)");
			ps.setString(1, rs.getName());
			ps.setString(2, rs.getPass());
			ps.setString(3, rs.getEmail());
			ps.setString(4, rs.getAddress());
			i=ps.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

}
