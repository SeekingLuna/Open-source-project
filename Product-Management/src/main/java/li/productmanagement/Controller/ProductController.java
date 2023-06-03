package li.productmanagement.Controller;

import li.productmanagement.pojo.Result;
import li.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/category/addProduct", method = {RequestMethod.POST})
    public Result addProduct(@RequestParam("product_name") String productName,
                             @RequestParam(value = "description", required = false) String description,
                             @RequestParam("price") double price,
                             @RequestParam("picture") String picture,
                             @RequestParam(value = "count", required = false) int count,
                             @RequestParam("category_id") int categoryId) {
        int result = productService.addProduct(productName, description, price, picture, count, categoryId);
        if (result == 0) {
            return new Result(500, "添加失败");


        }
        return new Result(200, "添加成功");
    }

    @RequestMapping(value = "/category/deleteProduct", method = RequestMethod.POST)
    public Result deleteProduct(@RequestParam(value = "id", required = false) Integer id) {
        int result = productService.deleteProduct(id);
        if (result == 0) {
            if (id == null) {
                return new Result(500, "未指定要删除的商品");

            }
            return new Result(501, "要删除的商品不存在");
        }
        return new Result(200, "删除成功");
    }

    @RequestMapping(value = "/category/editProduct")
    public Result editProduct(@RequestParam("id") int id,
                              @RequestParam("product_name") String productName,
                              @RequestParam(value = "description", required = false) String description,
                              @RequestParam("price") double price,
                              @RequestParam("picture") String picture,
                              @RequestParam(value = "count", required = false) int count,
                              @RequestParam("category_id") int categoryId) {
        int result = productService.editProduct(id, productName, description, price, picture, count, categoryId);
        if (result == 0) {

            return new Result(500, "修改失败");


        }
        return new Result(200, "修改成功");


    }
}



























