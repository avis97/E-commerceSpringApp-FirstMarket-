package FirstMarket.FirstMarket.Converter;


import FirstMarket.FirstMarket.Models.Card;
import FirstMarket.FirstMarket.Models.Customer;
import FirstMarket.FirstMarket.RequestDTO.CardRequestDto;
import FirstMarket.FirstMarket.RequestDTO.CustomerRequestDto;
import FirstMarket.FirstMarket.ResponseDTO.CardResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CardConverter{

    public static Card cardRequestDtoToCard(CardRequestDto cardRequestDto)
    {
        return Card.builder()
                .cardNo(cardRequestDto.getCardNumber())
                .cvv(cardRequestDto.getCvv())
                .cardtype(cardRequestDto.getCardType())
                .build();
    }

}
