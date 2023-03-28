package FirstMarket.FirstMarket.Controller;

import FirstMarket.FirstMarket.Exception.ProductNotFoundException;
import FirstMarket.FirstMarket.RequestDTO.ItemRequestDto;
import FirstMarket.FirstMarket.ResponseDTO.ItemResponseDto;
import FirstMarket.FirstMarket.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController{
      @Autowired
      ItemService itemService;
      @GetMapping("/viewItem")
      public ResponseEntity viewItem(@RequestBody ItemRequestDto itemRequestDto)
      {
           ItemResponseDto itemResponseDto;
           try{
                 itemResponseDto=itemService.viewItem(itemRequestDto);
           }
           catch(ProductNotFoundException e)
           {
                 return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
           }
           return new ResponseEntity(itemResponseDto,HttpStatus.ACCEPTED);
      }
}
