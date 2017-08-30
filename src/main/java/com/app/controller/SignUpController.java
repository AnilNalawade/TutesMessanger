package com.app.controller;

 

 

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.pojo.Institute;
import com.app.pojo.Login;
import com.app.pojo.Role;
import com.app.pojo.Teacher;
import com.app.service.InstituteService;
import com.app.service.LoginService;
import com.app.service.TeacherService;
import com.app.service.impl.TeacherServiceImpl;

@Controller
@SessionAttributes({ "teacher", "institute" })
public class SignUpController {

	@Autowired
	LoginService loginService;

	@Autowired
	TeacherService teacherService;

	@Autowired
	InstituteService instituteService;

	
	//Teacher RegisterTeacher
    

     @RequestMapping(value="/RegisterTeacher",method = RequestMethod.GET)  
    public String  AddNewTeacher(Model model) {  
    	
    	System.out.println("this is AddNewTeacher controller");
    	Teacher teach=new Teacher();
    	
  
    	model.addAttribute("Teacher", teach);
		String output="signup/addTeacher";
		
        return output;  
    }
    
    
    @RequestMapping(value="/createTeacher",method = RequestMethod.GET)  
    public String  RegisterTeacher(Model model,@ModelAttribute("Teacher") Teacher teach ) {  
    	
    	System.out.println("this is Register Teacher controller");
    	String output="signup/CreateTeacher";
    	System.out.println(teach);
    	model.addAttribute("addTeacher",teach);
  //  	Teacher t= new Teacher();
  //  	model.addAttribute("Teacher", t);
    	
		System.out.println("redirecting to the page: "+ output );
		
        return output;  
    }
	
	/*
    @RequestMapping(value="/SaveTeacher",method = RequestMethod.POST)  
    public String  SaveInstituteAdmin(Model model,@ModelAttribute("addInstitute") Institute inst ,@ModelAttribute("Teacher") Teacher teacher ) {  
    	 
    	System.out.println("this is SaveInstituteAdmin controller");
    	String output="signup/";   	 
		try{	
			
			//call to the service which creates the institute with its Admin, uid-pwd and permissions
		 	appAdminService.AddInstituteWithAdmin(inst, teacher);
		 	TeacherService.
	    	model.addAttribute("SuccessMessage", "institute Saved with It's Admin"); 
	    	
	    	// add the existing institute into list ans show it on the 
	    	ArrayList<Institute> Institutelist= new ArrayList<Institute>();
			Institutelist.addAll(instituteService.getall());
			model.addAttribute("listOfInstitute", Institutelist);
			Institute inst1= new Institute();
			model.addAttribute("Institute", inst1);
			output+="ExistingInstitutes";
			
		}
		catch(Exception e)
		{
			// mostly error will be that their is duplicate entry in record 
			model.addAttribute("ErrorMessage", "Duplicate entry Name of the Institute or other attribute already exist try again with unique values");
	    	System.out.println("duplicate key unique key voilation");
	    	e.printStackTrace();
	    	output+="AddNewInstitute";
		}   	
		
			
        return output;  
    }
	
	*/
	
	
	/*

	@RequestMapping(value = "/Checklogin", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("login") Login login, Login l) {

		System.out.println("this is from Checklogin controller");
		//System.out.println("login credentials are " + login.toString());
		String output = "";
		if (loginService.exist(login)) {
			System.out.println("**********such a user exists ");
			
		
			
			
			Login userLogin = loginService.find_By_Uname_pwd(login);

			if(loginService.Isenabled(userLogin)) {
				Role userRole = userLogin.getRole();
				int roleId = userRole.getId();
				switch (roleId) {
				case 1:
					output = "hello";// student
					System.out.println("student logged in");
					break;

				case 2:
					output = "Teacher/home";// teacher
					model.addAttribute("teacher", teacherService.findByLoginId(userLogin.getId()));
					System.out.println("teacher logged in");
					break;

				case 3:
					output = "Teacher/home";// ** institute admin
					Teacher t=teacherService.findByLoginId(userLogin.getId());
					System.out.println(t);
					model.addAttribute("teacher",t );
					model.addAttribute("institute",teacherService.GetInstitute(t.getId()) );
					model.addAttribute("appAdmin", teacherService.findByLoginId(userLogin.getId()));
					System.out.println("institute admin logged in");
					break;

				case 4:
					output = "appAdmin/dashboard";// app Admin
					System.out.println("admin logged in");
					break;

				case 5:
					output = "template/index";// app Admin
					System.out.println("template logged in");
					break;

				default:
					model.addAttribute("message", login.toString());
					System.out.println("error in login incorect role logged in");
					output = "hello";
					break;
				}
						
						
						
					}else
					{
						System.out.println("user is blocked due to not having permissions");

						model.addAttribute("ErrorMessage", "Your Accont is not Active Please contact Your Application Admin");
						model.addAttribute("Login", l);
						output = "login";
						
					}
					
			
		} else {
			System.out.println("**************no such a user");

			model.addAttribute("ErrorMessage", "Username or Password incorrect");
			model.addAttribute("Login", l);
			output = "login";
		}
		return output;
	}
*/
}

// comment by rahul pr