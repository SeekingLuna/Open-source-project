package edu.li.StudentInfo.handler;

import edu.li.StudentInfo.pojo.Student;
import edu.li.StudentInfo.pojo.Teacher;
import edu.li.StudentInfo.service.CoursePlanService;
import edu.li.StudentInfo.service.CourseService;
import edu.li.StudentInfo.service.SelectCourseService;
import edu.li.StudentInfo.service.StudentService;
import edu.li.StudentInfo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName: StudentInfo
 * @Package: edu.li.StudentInfo.handler
 * @ClassName: AdminHandler
 * @Description: admin的handler层（servlet）
 * @Version: 1.0
 */

@Controller
@RequestMapping("/AdminHandler")
//@SessionAttributes("studentList")
//@SessionAttributes("teacherList")
public class AdminHandler {


    @Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	CoursePlanService coursePlanService;
	@Autowired
	CourseService courseService;
	@Autowired
	SelectCourseService selectCourseService;


	
	String[] arr_belongcoll = {"人工智能学院","智能建筑学院","外国语学院","人文学院"};
	String[][] arr_belongpro = {
                    {"网络工程","软件工程","物联网","信息管理"},
                    {"土木工程","测绘工程","工程造价", "城市规划"},
                    {"英语", "日语", "俄语", "西班牙语"},
                    {"汉语言", "历史", "新闻", "网络新媒体"}
				};
	String[][][] arr_belongcla = {
                {
                    {"网络B201","网络B202","网络B211","网络B212","网络B221","网络B222"},
                    {"软件B201","软件B202","软件B211","软件B212","软件B221","软件B222"},
                    {"物联B201","物联B202","物联B211","物联B212","物联B221","物联B222"},
                    {"信管B201","信管B202","信管B211","信管B212","信管B221","信管B222"}
                    
                },
                {
                    {"土木B201","土木B202","土木B211","土木B212","土木B221","土木B222"},
                    {"测绘B201","测绘B202","测绘B211","测绘B212","测绘B221","测绘B222"},
                    {"造价B201","造价B202","造价B211","造价B212","造价B221","造价B222"},
                    {"规划B201","规划B202","规划B211","规划B212","规划B221","规划B222"}
                    
                },
                {
                    {"英语B201","英语B202","英语B211","英语B212","英语B221","英语B222"},
                    {"日语B201","日语B202","日语B211","日语B212","日语B221","日语B222"},
                    {"俄语B201","俄语B202","俄语B211","俄语B212","俄语B221","俄语B222"},
                    {"牙语B201","牙语B202","牙语B211","牙语B212","牙语B221","牙语B222"}
                    
				},
                {
                    {"汉语B201","汉语B202","汉语B211","汉语B212","汉语B221","汉语B222"},
                    {"历史B201","历史B202","历史B211","历史B212","历史B221","历史B222"},
                    {"新闻B201","新闻B202","新闻B211","新闻B212","新闻B221","新闻B222"},
                    {"网媒B201","网媒B202","网媒B211","网媒B212","网媒B221","网媒B222"}
                    
				}
		};

 // 添加
 	@RequestMapping("/addStudent")
 	public String addStudent(Student student, Model model) {
 		
 		
 		
 		
 		int col = Integer.parseInt(student.getCollege());
 		int pro = Integer.parseInt(student.getProfession());
 		int cla = Integer.parseInt(student.getClassr());
 		//总感觉前端js写的有问题。
 		student.setCollege(arr_belongcoll[pro]);
 		student.setProfession(arr_belongpro[pro][col]);
 		student.setClassr(arr_belongcla[pro][col][cla]);
 		
 		
 		
 		if (studentService.insertStudent(student) != 0) {
 			model.addAttribute("student", student);
 			return "success";
 			// return "admin/addStudent";
 		} else {
 			return "fail";
 		}

 	}
 	//查询全部学生方法
 	public void queryStu(HttpServletRequest request) {
 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.selectStudentBySql(1,10);
 		
 		
 		request.setAttribute("slist", studentList);
 	}

 	public void pageIn(Model model,List list) {
 		PageInfo page = new PageInfo(list, 5);
	 	model.addAttribute("pageInfo", page);
 	}
 	
 	// 查询
 	@RequestMapping(value = "/query/{pn}", method = RequestMethod.GET)
 	public String redirect(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {

 		int no = Integer.parseInt(pn);
// 		System.out.println("-----"+no+"----");
 		List<Student> studentList = new ArrayList<Student>();
 		PageHelper.startPage(no, 5);
 		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
 		//查询全部
 		if (serc.equals("all")) {
 			
 			
 			
 	 		
 			System.out.println("------------------------------------------------------------------------------------------------");
// 			studentList = studentService.selectStudentBySql(1,10);
// 			//model.addAttribute("studentList", studentList);
// 			request.setAttribute("slist", studentList);
// 			System.out.println("00000"+request.getAttribute("slist"));
// 			System.out.println(studentList);
 			studentList = studentService.selectStudentBySql(1,10);
 			pageIn(model, studentList);
 	 		request.setAttribute("slist", studentList);
 			return "admin/queryStudent";

 		//根据学号查询
 		} else if (serc.equals("sid")) {

 			studentList = studentService.getByStudentSid(1,10,condition);
 			pageIn(model, studentList);
 			request.setAttribute("slist", studentList);
 			System.out.println("sid");

 			return "admin/queryStudent";

 		//根据学院查询
 		} else if (serc.equals("col")) {
 			
 			
 			studentList = studentService.getByStudentCol(1,10,condition);
 			pageIn(model, studentList);
 			request.setAttribute("slist", studentList);
 			System.out.println(studentList);
 			System.out.println("col");
 			return "admin/queryStudent";

 		//根据专业查询
 		} else if (serc.equals("pro")) {
 			studentList = studentService.getByStudentPro(1,10,condition);
 			pageIn(model, studentList);
 			request.setAttribute("slist", studentList);
 			System.out.println(studentList);
 			System.out.println("pro");
 			return "admin/queryStudent";

 		//根据班级查询
 		} else if (serc.equals("cla")) {
 			studentList = studentService.getByStudentCla(1,10,condition);
 			pageIn(model, studentList);
 			//model.addAttribute("studentList", studentList);
 			request.setAttribute("slist", studentList);
// 			System.out.println(studentList);
// 			System.out.println("cla");
 			return "admin/queryStudent";

 		} else {

// 			studentList = studentService.selectStudentBySql(1,10);
// 			model.addAttribute("studentList", studentList);
// 			request.setAttribute("slist", studentList);
// 			System.out.println("00000"+request.getAttribute("slist"));
// 			System.out.println(studentList);
 			studentList = studentService.selectStudentBySql(1,10);
 			pageIn(model, studentList);
 	 		request.setAttribute("slist", studentList);
 			return "admin/queryStudent";

 		}

 	}

 	// 删除学生
 	@RequestMapping(value = "/delete/{sid}", method = RequestMethod.GET)
 	public String deleteStudent(@PathVariable(value = "sid") String sid, Model model) {


 		if (studentService.deleteStudent(sid) != 0) {
 			System.out.println("success");
 			
 			return "success";
 		} else {
 			System.out.println("fail");
 			return "fail";
 		}

 	}

 	// 跳转页面
 	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
 	public String finalPage(HttpServletRequest request) {
 		queryStu(request);
 		return "admin/queryStudent";
 	}

 	// 修改定位
 	@RequestMapping(value = "/moditystu/{sid}", method = RequestMethod.GET)
 	public String editPre(@PathVariable("sid") String sid, HttpServletRequest request) {

 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.getByStudentSid(1,10,sid);
 		
 		request.setAttribute("studentList", studentList);
 		System.out.println("-----进入修改");
 		return "admin/modiStudent";
 	}

 	
 	
 	// 修改
 	@RequestMapping(value = "/moditystud/{sid}", method = RequestMethod.GET)
 	public String update(@PathVariable("sid") String sid, Student student, HttpServletRequest request) {

 		int col = Integer.parseInt(student.getCollege());
 		int pro = Integer.parseInt(student.getProfession());
 		int cla = Integer.parseInt(student.getClassr());
 		//总感觉前端js写的有问题。
 		student.setCollege(arr_belongcoll[pro]);
 		student.setProfession(arr_belongpro[pro][col]);
 		student.setClassr(arr_belongcla[pro][col][cla]);
 		
 		if (studentService.modifyStudent(student) != 0) {
 			System.out.println("----修改成功--------------------------------------------------------------------------------------------------------");
 			return "success";
 		} else {
 			System.out.println("----修改失败----------------------------------------------------------------");
 			return "fail";
 		}
 	}
 	
 	
 	

 	// 跳转页面
 	@RequestMapping("/managestu/{pn}")
 	public String manageStudent(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		
 		PageHelper.startPage(no, 5);
 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.selectStudentBySql(1,100);
 		pageIn(model, studentList);
 		request.setAttribute("slist", studentList);
 		return "admin/queryStudent";
 	}
 		
 	// 跳转页面
 	@RequestMapping("/managetea/{pn}")
 	public String manageTeacher(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		List<Teacher> teacherList = new ArrayList<Teacher>();
	 	teacherList = teacherService.selectTeacherBySql(1,10);
	 	pageIn(model, teacherList);
	 	request.setAttribute("teacherList", teacherList);
 		return "admin/queryTeacher";
 	}


 	// 跳转页面
 	@RequestMapping("/addstu")
 	public String adStudent() {
 		return "admin/addStudent";
 	}

 	// 跳转页面
 	@RequestMapping("/addtea")
 	public String adTeacher() {
 		return "admin/addTeacher";
 	}

 	// 跳转页面
 	@RequestMapping("/addcou")
 	public String adCourse() {
 		return "admin/addCourse";
 	}
 	
 // 添加
 	@RequestMapping("/addTeacher")
 	public String addTeacher(Teacher teacher, Model model, HttpSession httpSession) {

 		if (teacherService.insertTeacher(teacher) != 0) {
 			model.addAttribute("teacher", teacher);

 			//---------------------------------待优化-----同样不能实时刷新--------------------------------------------
 			return "success";
 			//return new ModelAndView(new RedirectView("/StudentInfo/TeacherHandler/finalPage"));
 			// return "techer/teacherFace";
 		} else {
 			return "fail";
 			//return new ModelAndView(new RedirectView("fail"));
 		}

 	}

 	
 	/**
 	 * 教师相关
 	 */
 	
 	//查询全部教师方法
 	 	public void queryTea(HttpServletRequest request) {
 	 		List<Teacher> teacherList = new ArrayList<Teacher>();
 	 		teacherList = teacherService.selectTeacherBySql(1,10);
 	 		request.setAttribute("teacherList", teacherList);
 	 	}
 	
 	// 查询
 	@RequestMapping(value = "/queryTea/{pn}", method = RequestMethod.GET)
 	public String redirectTea(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		List<Teacher> teacherList = new ArrayList<Teacher>();
 		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
 		
 		if (serc.equals("all")) {

 			teacherList = teacherService.selectTeacherBySql(1,10);
 			pageIn(model, teacherList);
 	 		request.setAttribute("teacherList", teacherList);
 			return "admin/queryTeacher";

 		} else if (serc.equals("tid")) {

 			teacherList = teacherService.getByTeacherTid(1,10,condition);
 			pageIn(model, teacherList);
 			request.setAttribute("teacherList", teacherList);
 			System.out.println("tid");

 			return "admin/queryTeacher";

 		} else {

 			teacherList = teacherService.selectTeacherBySql(1,10);
 			pageIn(model, teacherList);
 	 		request.setAttribute("teacherList", teacherList);
 			return "admin/queryTeacher";

 		}

 	}
 	
 	

 	//删除教师
 	@RequestMapping(value = "/deleteTea/{tid}", method = RequestMethod.GET)
 	public String deleteTeacher(@PathVariable(value = "tid") String tid, Model model) {


 		if (teacherService.deleteTeacher(tid) != 0) {
 			System.out.println("success");
 //------------------------代优化，现状：删除后需要手动刷新界面或者重新查询，不能实时刷新。---------------------------------------------------
 			return "success";
 		} else {
 			System.out.println("fail");
 			return "fail";
 			
 		}

 	}

 	@RequestMapping(value = "/finalPageTea", method = RequestMethod.GET)
 	public String finalPageTea(HttpServletRequest request) {
 		queryTea(request);
 		return "admin/queryTeacher";
 	}

 	//修改定位，可优化
 	@RequestMapping(value = "/modityTea/{tid}", method = RequestMethod.GET)
 	public String editPreTea(@PathVariable("tid") String tid, HttpServletRequest request) {

 		List<Teacher> teacherList = new ArrayList<Teacher>();
 		teacherList = teacherService.getByTeacherTid(1,10,tid);
 		//model.addAttribute("teacherList", teacherList);
 		request.setAttribute("teacherList", teacherList);

 		return "admin/modiTeacher";
 	}

 	// 修改
 	@RequestMapping(value = "/modityTeac/{tid}", method = RequestMethod.GET)
 	public String update(@PathVariable("tid") String tid, Teacher teacher, HttpServletRequest request) {

 		if (teacherService.modifyTeacher(teacher) != 0) {
 			return "success";
 		} else {
 			return "fail";
 		}
 	}
    
    
}
