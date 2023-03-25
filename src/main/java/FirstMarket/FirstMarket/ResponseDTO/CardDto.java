package FirstMarket.FirstMarket.ResponseDTO;


import FirstMarket.FirstMarket.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDto {
    private String CardNumber;
    private CardType cardType;
}
