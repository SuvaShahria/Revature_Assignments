package com.app.services;
import java.security.NoSuchAlgorithmException;
import com.app.models.*;
import com.app.utils.Hashing;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService us =new UserService();
		User u= us.login("s5","s");
		System.out.println(u.getEmail());
	}

}
