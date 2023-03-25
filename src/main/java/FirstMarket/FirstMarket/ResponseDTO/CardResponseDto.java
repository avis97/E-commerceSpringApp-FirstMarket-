package FirstMarket.FirstMarket.ResponseDTO;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardResponseDto{

    private String cardName;
    List<CardDto> cardDtoList;
}
