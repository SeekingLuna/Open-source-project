package li.productmanagement.pojo;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class User {
   private int id;
   private String name;
   private String password;
   private String email;
   private String phone;
   private String address;
}
