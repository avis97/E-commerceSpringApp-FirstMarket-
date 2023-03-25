package FirstMarket.FirstMarket.Service;
import java.util.stream.Collectors;
import FirstMarket.FirstMarket.Converter.SellerConverter;
import FirstMarket.FirstMarket.Models.Seller;
import FirstMarket.FirstMarket.Repository.SellerRepository;
import FirstMarket.FirstMarket.RequestDTO.SellerRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SellerService{


    @Autowired
    SellerRepository sellerRepo;
    public String addSeller(SellerRequestDTO requestDto){


        //we can use the converter class here hor create the object..
        Seller seller= SellerConverter.sellerRequestDtoToSeller(requestDto);
        sellerRepo.save(seller);
        return "Welcome the FirstMarket..now you can sell your product.";

        //create the object of seller because in seller repository the class is seller so we
        // just store the seller object not RequestDTo because Dto just use jor data transfer.

        //1st approach for make object....
//        Seller seller =new Seller();
//        seller.setSName(requestDto.getName());
//        seller.setSEmail(requestDto.getEmail());
//        seller.setSPanNo(requestDto.getPanNum());
//        seller.setSPanNo(requestDto.getPhNum());///   this is normal approach..
    }
    public List<SellerRequestDTO> getAllSellers()
    {
        List<Seller> sellers=sellerRepo.findAll();
        return sellers.stream().map(seller -> mapToDto(seller)).collect(Collectors.toList());
    }
    private SellerRequestDTO mapToDto(Seller seller) {
        SellerRequestDTO usersDto = new SellerRequestDTO();
        usersDto.setName(seller.getSName());
        usersDto.setEmail(seller.getSEmail());
        usersDto.setPhNum(seller.getSPhnNo());
        usersDto.setPanNum(seller.getSPanNo());
        return usersDto;
    }
}