package FirstMarket.FirstMarket.Converter;

import FirstMarket.FirstMarket.Models.Product;
import FirstMarket.FirstMarket.ResponseDTO.ItemResponseDto;
import FirstMarket.FirstMarket.ResponseDTO.ProductResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemConverter{
    public static ItemResponseDto ItemToItemRequestDto(Product product)
    {
        return ItemResponseDto.builder()
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();
    }
}
