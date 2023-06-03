package li.productmanagement.dao;

import li.productmanagement.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Mapper
@Repository
public interface UserDAO {
    @Insert("insert into user(username,password,email,phone,address) VALUES(#{name},#{password},#{email},#{phone},#{address})")
    int insert(User user);


    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteUserById(int id);

    @Update("UPDATE user SET username = #{name}, password = #{password},email=#{email},phone=#{phone},address=#{address} WHERE id = #{id}")
    int updateUser(User user);

    @Select("SELECT id FROM user WHERE username = #{username} and password = #{password}")
    Integer login(String username,String password);


}
