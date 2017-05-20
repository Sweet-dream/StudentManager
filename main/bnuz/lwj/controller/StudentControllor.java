package bnuz.lwj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bnuz.lwj.po.Student;
import bnuz.lwj.po.StudentCustom;
import bnuz.lwj.service.StudentService;

@Controller
@RequestMapping("/Student")
public class StudentControllor {
	String userType;
	Integer userid;
	@Autowired
	private StudentService studentService;
	// /Student/queryStudent.action
	@RequestMapping("/queryStudent")
	public ModelAndView queryStudent(HttpSession session)throws Exception{
		List<Student> studentList=new ArrayList<Student>();
		ModelAndView modelAndView = new ModelAndView();
		userType=(String)session.getAttribute("userType");
		userid=(Integer)session.getAttribute("userid");
		Student studentInf=studentService.findStudentById(userid);
		studentList.add(studentInf);
		//传值到jsp
		modelAndView.addObject("studentList", studentList);
		modelAndView.addObject("userType",userType);
		modelAndView.addObject("userid",userid);	
		
		modelAndView.setViewName("student/studentlist");
		return modelAndView;
		
	}
	
	//根据ID查询学生信息，点击修改时获得
		@RequestMapping("/editStudent")
		// /Student/editStudent.action
	public ModelAndView editStudent(HttpSession session,StudentCustom studentCustom)throws Exception{
		/*	,String userType,Integer userid*/
		studentCustom=studentService.findStudentById(studentCustom.getId());
		ModelAndView modelAndView = new ModelAndView();
		userType=(String)session.getAttribute("userType");
		userid=(Integer)session.getAttribute("userid");
		
		modelAndView.addObject("Student", studentCustom);
		modelAndView.addObject("userType",userType);
		modelAndView.addObject("userid",userid);
		modelAndView.setViewName("student/studentupdate");
			 
		return modelAndView;
			
	}
		
	//提交修改学生信息操作
	// /StudentCustom/editStudentSubmit.action
	@RequestMapping("/editStudentSubmit")
	public String editStudentSubmit(HttpSession session,Model model,StudentCustom studentCustom)throws Exception{		
		//传值到jsp
		userType=(String)session.getAttribute("userType");
		userid=(Integer)session.getAttribute("userid");
		
		model.addAttribute("userType",userType);
		model.addAttribute("userid",userid);
		studentService.updateStudent(studentCustom);
		return "redirect:/Student/queryStudent.action"; 
			
	}
}
