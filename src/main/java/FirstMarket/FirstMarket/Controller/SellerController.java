package FirstMarket.FirstMarket.Controller;

import java.util.*;
import FirstMarket.FirstMarket.Models.Seller;
import FirstMarket.FirstMarket.RequestDTO.SellerRequestDTO;
import FirstMarket.FirstMarket.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController{

    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDTO requestDto)
    {
       return sellerService.addSeller(requestDto);
    }

    @GetMapping("/getAllSeller")
    public List<SellerRequestDTO> getAllSeller()
    {
        return sellerService.getAllSellers();
    }

}
