package FirstMarket.FirstMarket.ResponseDTO;

import FirstMarket.FirstMarket.Enum.Category;
import FirstMarket.FirstMarket.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDto{
     private String productName;
     private int productPrice;
     private Category productCategory;
     private ProductStatus productStatus;

}
