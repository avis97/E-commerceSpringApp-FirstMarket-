package FirstMarket.FirstMarket.Converter;

import FirstMarket.FirstMarket.Enum.ProductStatus;
import FirstMarket.FirstMarket.Models.Product;
import FirstMarket.FirstMarket.RequestDTO.ProductRequestDto;
import FirstMarket.FirstMarket.ResponseDTO.ProductResponseDto;
import lombok.experimental.UtilityClass;


@UtilityClass
public class ProductConverter{

    public static Product productRequestDtotoConvertProduct(ProductRequestDto requestDto)
    {
         return Product.builder()
                 .productName(requestDto.getProductName())
                 .productPrice(requestDto.getProductPrice())
                 .productQuantity(requestDto.getProductQuantity())
                 .productCategory(requestDto.getProductCategory())
                 .productStatus(ProductStatus.AVAILABLE)
                 .build();
    }
    public static ProductResponseDto productConvertToResponseDto(Product product)
    {
         return ProductResponseDto.builder()
                 .ProductQuantity(product.getProductQuantity())
                 .ProductPrice(product.getProductPrice())
                 .ProductName(product.getProductName())
                 .ProductStatus(product.getProductStatus())
                 .build();
    }
}
