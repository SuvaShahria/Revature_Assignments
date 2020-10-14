package com.app.dao;
import java.security.NoSuchAlgorithmException;
import com.app.models.*;
import com.app.utils.Hashing;
public class test {

	public static void main(String[] args) {
//		RoleDao r = new RoleDao(1);
////		System.out.print("hi");
//	Role r1 = r.findRoleById(2);
//	System.out.print(r1.getRole());
//		Role r = new Role(1,"admin");
//		Role r2 = new Role(2,"employee");
//		Role r3 = new Role(3,"customer");
//		User a = new User("a", "a", "a", "a", "a@gmail.com", r);
//		User e = new User("e", "e", "e", "e", "e@gmail.com", r2);
//		User c = new User("c", "c", "c", "c", "c@gmail.com", r3);
//		UserDao ud = new UserDao(1);
		//User u2 = ud.insert(a);
		//ud.insert(e);
		//ud.insert(c);
		//User up = new User("s5", "s", "s", "s", "ss@gmail.com", r);
		//boolean t = ud.update(up);
	//System.out.println(u2.getEmail());
		//ud.delete(u);
		
		AccountStatusDao asd = new AccountStatusDao(1);
		AccountStatus as = asd.findById(2);
//		System.out.println(as.getStatusId()+as.getStatus());
		AccountTypeDao atd = new AccountTypeDao(1);
		AccountType at = atd.findById(1);
//		System.out.println(at.getTypeId()+at.getType());
//		AccountDao ad = new  AccountDao(1);
//		Account a = ad.findById(1);
//		System.out.println(a.getAccountId());
//		System.out.println(a.getUserId());
//		System.out.println(a.getUser().getUserId());
//		System.out.println(a.getBalance());
//		System.out.println(a.getStatus().getStatus());
//		System.out.println(a.getType().getType());
		AccountDao ad = new  AccountDao(1);
		Account ac = new Account(21,15,as,at);
		ac.setAccountId(4);
		ad.delete(ac);
		//ad.updateStatus(ac);
	}

}
