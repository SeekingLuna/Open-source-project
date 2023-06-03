package li.productmanagement.Controller;

import li.productmanagement.dao.UserDAO;
import li.productmanagement.pojo.Result;
import li.productmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/addUser", method = {RequestMethod.POST})
    public Result addUser(@RequestParam("name") String userName,
                          @RequestParam("password") String userPassword,
                          @RequestParam("e-mail") String userEMail,
                          @RequestParam(value = "phone", required = false) String userPhone,
                          @RequestParam(value = "address", required = false) String userAddress) {

        int result = userService.addUser(userName, userPassword, userEMail, userPhone, userAddress);
        if (result == 0) {
            return new Result(500, "用户添加失败");

        }
        return new Result(200, "用户添加成功,受影响的行数为" + result);
    }

    @RequestMapping(value = "/user/deleteUser", method = RequestMethod.GET)
    public Result deleteUser(@RequestParam("id") int id) {
        int result = userService.deleteUser(id);

        if (result == 0) {
            return new Result(500, "用户删除失败");

        }
        return new Result(200, "用户删除成功,受影响的行数为" + result);

    }

    @RequestMapping(value = "/user/editUser", method = {RequestMethod.POST})
    public Result editUser(@RequestParam("id") int id,
                           @RequestParam("username") String userName,
                           @RequestParam("password") String userPassword,
                           @RequestParam("email") String userEMail,
                           @RequestParam(value = "phone", required = false) String userPhone,
                           @RequestParam(value = "address", required = false) String userAddress) {

        int result = userService.editUser(id, userName, userPassword, userEMail, userPhone, userAddress);
        if (result == 0) {
            return new Result(500, "用户编辑失败");

        }
        return new Result(200, "用户编辑成功,受影响的行数为" + result);

    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public Result UserLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        Integer result = userService.userLogin(username, password);
        if (result == null) {
            return new Result(500, "账户名或密码错误");
        }
        return new Result(200, "欢迎您："+username);

    }
}