package com.labinsights.service;

import java.util.List;
import com.labinsights.entity.Admin;
import com.labinsights.entity.User;
 
public interface AdminService {


	public List<Admin> findByRole(String user);

	public Admin findByEmail(String user);
	
	public List<Admin> findAll();

	public void save(Admin admin);
	
}
