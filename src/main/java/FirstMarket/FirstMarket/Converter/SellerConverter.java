package FirstMarket.FirstMarket.Converter;

import FirstMarket.FirstMarket.Models.Seller;
import FirstMarket.FirstMarket.RequestDTO.SellerRequestDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerConverter{
    public static Seller sellerRequestDtoToSeller(SellerRequestDTO requestDto)
    {
             //this is builder approach for make object...This converter class help convert requestDto to Seller..
             return  Seller.builder()
            .sName(requestDto.getName())
            .sEmail(requestDto.getEmail())
            .sPhnNo(requestDto.getPhNum())
            .sPanNo(requestDto.getPanNum())
            .build();
    }

}
