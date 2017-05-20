package bnuz.lwj.service;

import java.util.List;

import bnuz.lwj.po.StudentCustom;
import bnuz.lwj.po.StudentQueryVo;


public interface TeacherService {
	//查询学生名单
	public List<StudentCustom> findStudentCustomList(StudentQueryVo studentQueryVo)throws Exception;
	
	//根据ID查找学生名单
	public StudentCustom findStudentById(Integer id) throws Exception;
	
	//修改学生信息
	public void updateStudentCustom(StudentCustom studentCustom) throws Exception;
	
	//根据ID删除学生信息
	public void deleteStudentCustom(Integer id)throws Exception;
	
	//插入学生信息
	public void insertStudentCustom(StudentCustom studentCustom) throws Exception;

	
	
}
