package edu.li.StudentInfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.li.StudentInfo.mapper.GradeMapper;
import edu.li.StudentInfo.pojo.Grade;
import edu.li.StudentInfo.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeMapper gradeMapper;
	
	@Override
	public int insertGrade(Grade grade) {
		
		return gradeMapper.insertGrade(grade);
	}

	@Override
	public String queryCreditsSum(String sid) {
		return gradeMapper.queryCreditsSum(sid);
	}

	@Override
	public List<Grade> getEedCourseBySid(int pageNo, int pageSize, String sid) {
		Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("sid",sid);
        return gradeMapper.getEedCourseBySid(data);
	}

}
