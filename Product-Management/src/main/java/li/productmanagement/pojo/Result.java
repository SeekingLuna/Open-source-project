package li.productmanagement.pojo;

import lombok.Data;

@Data
public class Result {
    Integer code;  //1:success,0:fail
    Object message;


    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
