package li.productmanagement.dao;

import li.productmanagement.pojo.Product;
import li.productmanagement.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductDAO {
    @Insert("INSERT IGNORE INTO product(product_name,description,price,picture,count,category_id) values(#{productName},#{description},#{price},#{picture},#{count},#{categoryId})")
    int insert(Product product);

    @Delete("DELETE FROM product WHERE id =#{id}")
    int delete(Integer id);

    @Update("UPDATE product SET product_name = #{productName}, description = #{description},price=#{price},picture=#{picture},count=#{count},category_id=#{categoryId} WHERE id = #{id}")
    int update(Product product);


}
