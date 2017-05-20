package bnuz.lwj.mapper;

import java.util.List;


import bnuz.lwj.po.StudentCustom;
import bnuz.lwj.po.StudentQueryVo;


public interface TeacherMapper {
	
	public List<StudentCustom> findStudentCustomList(StudentQueryVo studentQueryVo)throws Exception;
	
	public StudentCustom selectStudentCustomByPrimaryKey(Integer id);
	
	public int updateStudentCustomByPrimaryKey(StudentCustom record);
	
	public int deleteStudentCustomById(Integer id);
	
	public void insertStudentCustom(StudentCustom studentCustom);
	
}
