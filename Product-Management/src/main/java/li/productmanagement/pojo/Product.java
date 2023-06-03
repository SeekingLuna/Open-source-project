package li.productmanagement.pojo;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class Product {
    int id;
    String productName;
    String description;
    double price;
    String picture;
    int count;
    int categoryId;
}
