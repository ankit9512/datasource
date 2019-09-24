package service;

import dao.StudentDAO;
import dao.StudentDAOInterface;
import entity.RegisterStudent;

public class StudentService implements StudentServiceInterface{

	
	private StudentService(){}

	public static StudentServiceInterface createServiceObject(String string) {
		// TODO Auto-generated method stub
		return new StudentService();
	}

	@Override
	public int createProfileService(RegisterStudent rs) {
		StudentDAOInterface rr = StudentDAO
				.createDaoObject("f");
		int i = rr.createProfileDao(rs);
		return i;
	}

	

	public static StudentServiceInterface createServiceObject1(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
