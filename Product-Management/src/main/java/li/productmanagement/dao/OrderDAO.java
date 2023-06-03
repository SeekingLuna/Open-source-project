package li.productmanagement.dao;

import li.productmanagement.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDAO {
    @Select("SELECT order_number,user_id,total_price,order_status,created_time,updated_time FROM orders WHERE id=#{id}")
    Order selectById(Integer id);

    @Update("UPDATE orders SET order_status=#{order_status} WHERE id = #{id}")
    Integer updateOrder(Integer id, String order_status) throws DataIntegrityViolationException;






}
