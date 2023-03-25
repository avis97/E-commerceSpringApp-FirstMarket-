package FirstMarket.FirstMarket.RequestDTO;


import FirstMarket.FirstMarket.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {

    private int sellerId;
    private String productName;
    private int productPrice;
    private int productQuantity;
    private Category  productCategory;

}
