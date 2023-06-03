package li.productmanagement.pojo;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class Order {
    private Integer id;
    private String order_number;
    private int user_id;
    private double total_price;
    private String order_status;
    private Date created_time;
    private Date updated_time;
}
