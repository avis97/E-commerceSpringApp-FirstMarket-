package FirstMarket.FirstMarket.RequestDTO;


import FirstMarket.FirstMarket.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardRequestDto{
    private int customerId;
    private String cardNumber;
    private int cvv;
    private CardType cardType;
}
