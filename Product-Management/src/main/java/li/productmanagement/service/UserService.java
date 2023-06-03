package li.productmanagement.service;

import li.productmanagement.dao.UserDAO;
import li.productmanagement.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private User user;

    public int addUser(String username, String userPassword, String userEMail, String userPhone, String userAddress) {
        user.setName(username);
        user.setPassword(userPassword);
        user.setEmail(userEMail);
        user.setPhone(userPhone);
        user.setAddress(userAddress);
        int result = userDAO.insert(user);
        return result;
    }

    public int deleteUser(int id) {
        int result = userDAO.deleteUserById(id);

        return result;

    }

    public int editUser(int id, String username, String userPassword, String userEMail, String userPhone, String userAddress) {
        user.setId(id);
        user.setName(username);
        user.setPassword(userPassword);
        user.setEmail(userEMail);
        user.setPhone(userPhone);
        user.setAddress(userAddress);
        int result = userDAO.updateUser(user);
        return result;
    }

    public Integer userLogin(String username,String password){
        Integer result=userDAO.login(username,password);
        return result;



    }


}
