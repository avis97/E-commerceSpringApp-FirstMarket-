package FirstMarket.FirstMarket.ResponseDTO;

import FirstMarket.FirstMarket.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {
    private String ProductName;
    private int ProductPrice;
    private int ProductQuantity;
    private ProductStatus ProductStatus;
}
