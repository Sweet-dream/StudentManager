package bnuz.lwj.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bnuz.lwj.po.User;
import bnuz.lwj.service.UserLoginService;


@Controller
public class UserController {
	//上次少了 Autowired 一直空指针异常，下次要注意 
	@Autowired
	private UserLoginService userLoginService;

	@Scope(value="prototype")
	@RequestMapping(value="/login",method=RequestMethod.POST)  
	
    public String login(User user,HttpSession session) throws Exception {
    	System.out.println(user.getUsername()+user.getPassword());
    	
    	User userDate=new User();
    	userDate=userLoginService.checkLogin(user.getUsername(), user.getPassword());
	
        if(userDate!=null){

            String flag=new String();
            //从数据库的user表中获取账户的type
            if(userDate.getType().equals("0")){
            	
            	flag="教师";
            }
            if(userDate.getType().equals("1")){
            	
            	flag="学生";
            }
            
            session.setAttribute("userType", flag);
            session.setAttribute("userid",Integer.valueOf(userDate.getUsername()));
           /* attr.addAttribute("userType", flag);
            attr.addAttribute("userid",Integer.valueOf(userDate.getUsername()));*/
            //重定向
            if(flag.equals("教师")){
            	
            	return "redirect:/StudentCustom/queryStudentCustom.action"; 
            }
            if(flag.equals("学生")){
            	
            	return "redirect:/Student/queryStudent.action"; 
            }
            
        }
        
        return "error";         
    }
	
	
	//退出  
    @RequestMapping("/logout")  
    public String logout(HttpSession session)throws Exception{  
          
        //清除session  
        session.invalidate();  
          
        //重定向到商品列表界面  
        return "redirect:index.jsp";  
    }  
 

}
