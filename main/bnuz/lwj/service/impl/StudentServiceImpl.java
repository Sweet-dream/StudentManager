package bnuz.lwj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import bnuz.lwj.mapper.StudentMapper;
import bnuz.lwj.po.StudentCustom;
import bnuz.lwj.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	//查询学生个人信息
	@Override
	public StudentCustom findStudentById(Integer id) throws Exception {
		
		return studentMapper.findStudentById(id);
	}
	//修改学生个人信息
	@Override
	public void updateStudent(StudentCustom studentCustom) throws Exception {
		
		studentMapper.updateStudentById(studentCustom);
		
	}
	

}
