package li.productmanagement.Controller;

import li.productmanagement.pojo.Order;
import li.productmanagement.pojo.Result;
import li.productmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private Order order;

    @RequestMapping(value = "/order/getOrder", method = RequestMethod.GET)
    public Result getOrder(@RequestParam("id") Integer id) {
        order = orderService.selectOrder(id);
        order.setId(id);
        return new Result(200, order.toString());

    }

    @RequestMapping(value = "/order/manageOrder", method = {RequestMethod.POST})
    public Result manageOrder(@RequestParam("id") Integer id,
                              @RequestParam("order_status") String order_status) {

        Integer result = orderService.updateOrder(id, order_status);
        if (result == 0) {

            return new Result(500, "更新失败,order_status的值只能为'PENDING','SHIPPED','DELIVERED','CANCELLED'之一");

        }


        return new Result(200, "id为" + id + "的订单的订单状态已成功更新为" + order_status);

    }
}
