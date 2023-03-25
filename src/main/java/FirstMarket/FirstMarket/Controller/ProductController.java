package FirstMarket.FirstMarket.Controller;

import FirstMarket.FirstMarket.Enum.Category;
import FirstMarket.FirstMarket.RequestDTO.ProductRequestDto;
import FirstMarket.FirstMarket.ResponseDTO.ProductResponseDto;
import FirstMarket.FirstMarket.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController{

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productDto){

        ProductResponseDto responseDto;
        try{
             responseDto=productService.addProduct(productDto);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(responseDto,HttpStatus.ACCEPTED);
    }

    @GetMapping("/getCategory/{productCategory}")
    public List<ProductResponseDto> getAllProductByCategory(@PathVariable("productCategory") Category productcategory)
    {
        return productService.getAllProductByCategory(productcategory);
    }
}
