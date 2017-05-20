package bnuz.lwj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import bnuz.lwj.mapper.TeacherMapper;
import bnuz.lwj.po.StudentCustom;
import bnuz.lwj.po.StudentQueryVo;
import bnuz.lwj.service.TeacherService;


public  class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherMapper studentMapperCustom;
	
	
	
	public List<StudentCustom> findStudentCustomList(StudentQueryVo studentQueryVo) throws Exception {
	
		return studentMapperCustom.findStudentCustomList(studentQueryVo);
	}


	//查询某个学生信息
	@Override
	public StudentCustom findStudentById(Integer id) throws Exception {
		return studentMapperCustom.selectStudentCustomByPrimaryKey(id);
		
		
	}

	//修改学生信息
	@Override
	public void updateStudentCustom(StudentCustom studentCustom) throws Exception {		
			
		studentMapperCustom.updateStudentCustomByPrimaryKey(studentCustom);
		
	}

	//删除学生信息
	@Override
	public void deleteStudentCustom(Integer id) throws Exception {
		
		studentMapperCustom.deleteStudentCustomById(id);
	}

	//插入学生信息
	@Override
	public void insertStudentCustom(StudentCustom studentCustom) throws Exception {
		
		studentMapperCustom.insertStudentCustom(studentCustom);
	}


	

}
