package li.productmanagement.pojo;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class Category {

        private int id;
        private String categoryName;
        private String description;
}
