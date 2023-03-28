package FirstMarket.FirstMarket.Service;

import FirstMarket.FirstMarket.Converter.ItemConverter;
import FirstMarket.FirstMarket.Exception.ProductNotFoundException;
import FirstMarket.FirstMarket.Models.Item;
import FirstMarket.FirstMarket.Models.Product;
import FirstMarket.FirstMarket.Repository.ProductRepository;
import FirstMarket.FirstMarket.RequestDTO.ItemRequestDto;
import FirstMarket.FirstMarket.ResponseDTO.ItemResponseDto;
import FirstMarket.FirstMarket.ResponseDTO.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService{
    @Autowired
    ProductRepository productRepository;
    public ItemResponseDto viewItem(ItemRequestDto itemRequestDto) throws ProductNotFoundException {
        Product product;
        try {
            product = productRepository.findById(itemRequestDto.getProductId()).get();
        }
        catch(Exception e)
        {
           throw new ProductNotFoundException("Sorry!!This Product It's Not Available");
        }

        Item item=Item.builder()
                .requiredQuantity(0)
                .products(product)
                .build();

        product.setItem(item);

        productRepository.save(product);

        ItemResponseDto itemResponseDto= ItemConverter.ItemToItemRequestDto(product);
        return itemResponseDto;
    }

}
//kdwe