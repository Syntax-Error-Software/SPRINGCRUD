package org.jsp.employee.controller;

import org.jsp.employee.dao.EmployeeDao;
import org.jsp.employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;

	@RequestMapping("/open-register")
	public ModelAndView openRegister(ModelAndView modelAndView) {
		modelAndView.setViewName("register");
		modelAndView.addObject("emp", new Employee());
		return modelAndView;
	}

	@RequestMapping("/open-view")
	public String openView(@RequestParam String view) {
		return view;
	}

	@RequestMapping("/save")
	@ResponseBody
	public String saveEmployee(@ModelAttribute(name = "emp") Employee employee) {
		employee = dao.saveEmployee(employee);
		return "<h1>Employee saved with id:" + employee.getId() + "</h1>";
	}
	
	@PostMapping("/verify-by-phone")
	public ModelAndView verify(@RequestParam(name="phone") long phone,@RequestParam(name="password") String password)
	{
		Employee employee=dao.verify(phone, password);
		ModelAndView modelAndView=new ModelAndView();
		if(employee!=null)
		{
			modelAndView.setViewName("display");
			modelAndView.addObject("employee", employee);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid Phone Or Password");
		return modelAndView;
	}
	
	@PostMapping("/verify-by-email")
	public ModelAndView verify(@RequestParam(name="email") String email,@RequestParam(name="password") String password)
	{
		Employee employee=dao.verify(email, password);
		ModelAndView modelAndView=new ModelAndView();
		if(employee!=null)
		{
			modelAndView.setViewName("display");
			modelAndView.addObject("employee", employee);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid email Or Password");
		return modelAndView;
	}
	
	@PostMapping("/verify-by-id")
	public ModelAndView verify(@RequestParam(name = "id") int id, @RequestParam(name = "password") String password) {
		Employee employee =dao.verify(id, password);
		ModelAndView modelAndView = new ModelAndView();
		if (employee != null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("employee", employee);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid Employee Id or Password");
		return modelAndView;
	}
	
	@GetMapping("/find-by-id")
	public ModelAndView findById(@RequestParam(name="id") int id)
	{
		Employee employee=dao.findById(id);
		ModelAndView modelAndView=new ModelAndView();
		if(employee!=null)
		{
			modelAndView.setViewName("display");
			modelAndView.addObject("employee", employee);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid Id");
		return modelAndView;
	}
	
	@RequestMapping("/delete-by-id")
	@ResponseBody
	public String deleteById(int id)
	{
		boolean employee=dao.deleteById(id);
		if(employee)
		{
			return "employee id:"+id+"deleted";
		}
		else
		{
			return "invalid id";
		}
	}
	
}
