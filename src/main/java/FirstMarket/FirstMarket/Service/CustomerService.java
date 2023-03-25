package FirstMarket.FirstMarket.Service;

import FirstMarket.FirstMarket.Converter.CustomerConverter;
import FirstMarket.FirstMarket.Models.Cart;
import FirstMarket.FirstMarket.Models.Customer;
import FirstMarket.FirstMarket.Repository.CustomerRepository;
import FirstMarket.FirstMarket.RequestDTO.CustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(CustomerRequestDto customerRequestDto)
    {
        //this a new customer object made by builder annotation in customerConverterClass
        Customer customer= CustomerConverter.CustomerRequestDtoToCustomer(customerRequestDto);

        //allocate the cart in this customer.
        Cart cart=new Cart();
        cart.setCartNo(0);
        cart.setCustomer(customer);

        //save the cart with this customer.
        customer.setCart(cart);

        customerRepository.save(customer);   //save the customer because cart is a child class of customer class.

        return "Welcome in FirstMarket!! You can use our services";
    }
}
