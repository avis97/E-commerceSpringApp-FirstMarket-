package FirstMarket.FirstMarket.RequestDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequestDto {

    private String customerName;
    private int customerAge;
    private String customerEmail;
    private String customerMoNumber;
}
