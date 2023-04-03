package com.labinsights.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labinsights.entity.Admin;
import com.labinsights.entity.Appointment;
import com.labinsights.entity.Tests;
import com.labinsights.repository.AppointmentRepository;
import com.labinsights.service.AdminServiceImplementation;
import com.labinsights.service.AppointmentServiceImplementation;
import com.labinsights.service.TestsService;

 
@Controller
@RequestMapping("/user")
public class UserController {

	private AppointmentServiceImplementation appointmentServiceImplementation;

	private AdminServiceImplementation adminServiceImplementation;

	@Autowired
	private TestsService testsService;
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	

	
	
	@Autowired
	public UserController(AppointmentServiceImplementation obj1,AdminServiceImplementation obj ) {
		appointmentServiceImplementation= obj1;
		adminServiceImplementation=obj;
		 
	}
	
	@GetMapping("/index")
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
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
         obj.setuserid(admin.getEmail());
        obj.setStatus("Pending");


			
		 System.out.println(obj);
		 List<Tests> tests = testsService.findAll();
		 
//		 List<Tests> tests = testsService.findAll();
		 
		 model.addAttribute("app",obj);
		 model.addAttribute("tests",tests);
		//  model.addAttribute("tests",tests);
		
		return "user/index";
	}
	
	@PostMapping("/save-app")
	public String saveEmploye(@ModelAttribute("app") Appointment obj) {
//		obj.setstatus("Pending");
		
		appointmentServiceImplementation.save(obj);
		
	
		// use a redirect to prevent duplicate submissions
		return "redirect:/user/index";
	}


@PostMapping("/update-app")
	public String updateApp(@ModelAttribute("app") Appointment obj) {
		
		appointmentServiceImplementation.save(obj);
		
	
		// use a redirect to prevent duplicate submissions
		return "redirect:/doctor/index";
	}
	
	@GetMapping("/about")
	public String about(Model model){
		
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
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
obj.setuserid(admin.getEmail());
obj.setStatus("Pending");
			
		 System.out.println(obj);
		 
		 List<Tests> tests = testsService.findAll();
		 
		 model.addAttribute("app",obj);
		 model.addAttribute("tests",tests);
		 
		return "user/about";
	}
	
	@GetMapping("/blog-single")
	public String bs(Model model){
		
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
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
obj.setuserid(admin.getEmail());
obj.setStatus("Pending");
			
		 System.out.println(obj);
		 
		 List<Tests> tests = testsService.findAll();
		 
		 model.addAttribute("app",obj);
		 model.addAttribute("tests",tests);
		 
		return "user/blog-single";
	}
	
	@GetMapping("/appointment")
	public String blog(Model model){
		
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
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
obj.setuserid(admin.getEmail());
obj.setStatus("Pending");
			
		 System.out.println(obj);
		 List<Appointment> appointments = appointmentRepository.findAppointmentsByUserId(admin.getEmail());
		 System.out.println("***********\n***************");
		 System.out.println(appointments);
		 System.out.println("***********\n***************");
		 
		 List<Tests> tests = testsService.findAll();
		 
		 model.addAttribute("tests",tests);
		 model.addAttribute("app",obj);
		 model.addAttribute("appointments",appointments);
		
		return "user/blog";
	}
	
	@GetMapping("/contact")
	public String contact(Model model){
		
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
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
obj.setuserid(admin.getEmail());
obj.setStatus("Pending");
			
		 System.out.println(obj);
		 
		 List<Tests> tests = testsService.findAll();
		 
		 model.addAttribute("app",obj);
		 model.addAttribute("tests",tests);
		
		return "user/contact";
	}
	

	@GetMapping("/department-single")
	public String d(Model model){
		
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
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
obj.setuserid(admin.getEmail());
obj.setStatus("Pending");
			
		 System.out.println(obj);
		 
		 List<Tests> tests = testsService.findAll();
		 
		 model.addAttribute("app",obj);
		 model.addAttribute("tests",tests);

		
		return "user/department-single";
	}

	@GetMapping("/departments")
	public String dep(Model model){
		
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
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
obj.setuserid(admin.getEmail());
obj.setStatus("Pending");
		 
			
		 System.out.println(obj);
		 
		 List<Tests> tests = testsService.findAll();
		 
		 model.addAttribute("app",obj);
		 model.addAttribute("tests",tests);
		
		return "user/departments";
	}

	@GetMapping("/doctor")
	public String doctor(Model model){
		
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
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
obj.setuserid(admin.getEmail());
obj.setStatus("Pending");
			
		 System.out.println(obj);
		 
		 List<Tests> tests = testsService.findAll();
		 
		 model.addAttribute("app",obj);
		 model.addAttribute("tests",tests);

		
		return "user/doctor";
	}
}