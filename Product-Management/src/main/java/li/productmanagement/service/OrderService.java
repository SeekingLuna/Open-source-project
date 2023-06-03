package li.productmanagement.service;

import li.productmanagement.dao.OrderDAO;
import li.productmanagement.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private Order order;

    public Order selectOrder(Integer id) {
        order = orderDAO.selectById(id);
        return order;

    }

    public Integer updateOrder(Integer id, String order_status) throws DataIntegrityViolationException {
        try {
            return orderDAO.updateOrder(id, order_status);
        } catch (DataIntegrityViolationException e) {
            return 0;
        }
    }


}
