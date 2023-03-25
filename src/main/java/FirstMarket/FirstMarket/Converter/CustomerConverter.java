package FirstMarket.FirstMarket.Converter;


import FirstMarket.FirstMarket.Models.Customer;
import FirstMarket.FirstMarket.RequestDTO.CustomerRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConverter{
    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto)
    {
          return Customer.builder()
                  .cName(customerRequestDto.getCustomerName())
                  .cAge(customerRequestDto.getCustomerAge())
                  .cEmail(customerRequestDto.getCustomerEmail())
                  .cPhnNo(customerRequestDto.getCustomerMoNumber())
                  .build();
    }
}
