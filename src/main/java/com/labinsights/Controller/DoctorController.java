package com.labinsights.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.labinsights.entity.Admin;
import com.labinsights.entity.Appointment;
import com.labinsights.entity.Tests;
import com.labinsights.repository.AppointmentRepository;
import com.labinsights.service.AdminServiceImplementation;
import com.labinsights.service.AppointmentServiceImplementation;
import com.labinsights.service.TestsService;
import com.labinsights.service.UserService;




@Controller
@RequestMapping("/doctor")
public class DoctorController {

	private UserService userService;

	private AdminServiceImplementation adminServiceImplementation;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private TestsService testsService;
	
	private AppointmentServiceImplementation appointmentServiceImplementation;

	
	@Autowired
	public DoctorController(UserService userService,AdminServiceImplementation obj,
			AppointmentServiceImplementation app) {
		this.userService = userService;
		adminServiceImplementation=obj;
		appointmentServiceImplementation=app;
	}
	
	
	@RequestMapping("/index")
	public String index(Model model){

	
		
		// get last seen
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		  String Pass = ((UserDetails)principal).getPassword();
		  System.out.println("One + "+username+"   "+Pass);
		  
		  
		} else {
		 username = principal.toString();
		  System.out.println("Two + "+username);
		}
		
		Admin admin = adminServiceImplementation.findByEmail(username);
				 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date now = new Date();  
		    
		         String log=now.toString();
		    
		         admin.setLastseen(log);
		         
		         adminServiceImplementation.save(admin);
		
		
		         
		List<Appointment> list=appointmentServiceImplementation.findAll();
		
		model.addAttribute("name",admin.getFirstName());
		
		model.addAttribute("email",admin.getEmail());
		
		
		model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		
		// add to the spring model
		model.addAttribute("app", list);
		
		return "doctor/index";
	}
	
	
	
	@RequestMapping("/showUpdateForm")
	public String showactvityupdate(Model model ,@RequestParam Integer employeeId) {
		
//		ModelAndView mav = new ModelAndView("doctor/update");
		 
		 List<Tests> tests = testsService.findAll();
		 
		 model.addAttribute("tests",tests);
		Appointment employee =  appointmentRepository.findAppointmentByInteger(employeeId);
//				appointmentRepository.findAllById(employeeId).get();
//		.addObjecModel model
		
	
		System.out.println(employee);
		model.addAttribute("app",employee);
		return "doctor/update";
		
//		return "doctor/update";
	}
	
	@PostMapping("/save-app")
	public String saveEmploye(@ModelAttribute("app") Appointment obj) {
//		obj.setstatus("Pending");
		System.out.println(obj);
		appointmentServiceImplementation.save(obj);
		
	
		// use a redirect to prevent duplicate submissions
		return "redirect:/doctor/index";
	}

	
	
}
