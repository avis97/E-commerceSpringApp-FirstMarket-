package FirstMarket.FirstMarket.Service;


import FirstMarket.FirstMarket.Converter.CardConverter;
import FirstMarket.FirstMarket.Exception.sellerNotFoundException;
import FirstMarket.FirstMarket.Models.Card;
import FirstMarket.FirstMarket.Models.Customer;
import FirstMarket.FirstMarket.Repository.CardRepository;
import FirstMarket.FirstMarket.Repository.CustomerRepository;
import FirstMarket.FirstMarket.RequestDTO.CardRequestDto;
import FirstMarket.FirstMarket.ResponseDTO.CardDto;
import FirstMarket.FirstMarket.ResponseDTO.CardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.List;

@Service
public class CardService{

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws sellerNotFoundException {
        Customer customer;
        try
        {
            customer=customerRepository.findById(cardRequestDto.getCustomerId()).get();
        }
        catch(Exception e)
        {
            throw new sellerNotFoundException("Opps!!!Not register this customer Id..");
        }
        //create the card object by using builder annotation in cardConverterClass
        Card card= CardConverter.cardRequestDtoToCard(cardRequestDto);
             //add the customer with the card object because card is a child of customer
             card.setCustomer(customer);

         //add the card in the card list.
        customer.getCard().add(card);

        //save the customer with the card in customer repo.
        customerRepository.save(customer);

        //make the cardResponseDto object
        CardResponseDto cardResponseDto=new CardResponseDto();
        cardResponseDto.setCardName(customer.getCName());

        //convert every card to cardDto
        List<CardDto> cardDtoList=new ArrayList<>();
        for(Card card1: customer.getCard())
        {
            CardDto cardDto=new CardDto();
            cardDto.setCardNumber(card1.getCardNo());
            cardDto.setCardType(card1.getCardtype());
            cardDtoList.add(cardDto);
        }
        cardResponseDto.setCardDtoList(cardDtoList);

        return cardResponseDto;
    }
}
