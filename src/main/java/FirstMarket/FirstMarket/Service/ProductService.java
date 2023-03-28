package FirstMarket.FirstMarket.Service;

import FirstMarket.FirstMarket.Converter.ProductConverter;
import FirstMarket.FirstMarket.Enum.Category;
import FirstMarket.FirstMarket.Exception.sellerNotFoundException;
import FirstMarket.FirstMarket.Models.Product;
import FirstMarket.FirstMarket.Models.Seller;
import FirstMarket.FirstMarket.Repository.ProductRepository;
import FirstMarket.FirstMarket.Repository.SellerRepository;
import FirstMarket.FirstMarket.RequestDTO.ProductRequestDto;
import FirstMarket.FirstMarket.ResponseDTO.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService{
    @Autowired
    ProductRepository productRepo;
    @Autowired
    SellerRepository sellerRepo;

    public ProductResponseDto addProduct(ProductRequestDto productDto) throws sellerNotFoundException {

        Seller seller;
        try
        {
            seller=sellerRepo.findById(productDto.getSellerId()).get();
        }
        catch(Exception e)
        {
            throw new sellerNotFoundException("Invalid Seller Id!!");
        }
        Product product= ProductConverter.productRequestDtotoConvertProduct(productDto);
        product.setSellers(seller);

        seller.getProduct().add(product);  //add the product in the seller product list..(ArrayList).

        //save the seller and product parent and child,,
        productRepo.save(product);

        ProductResponseDto dto=ProductConverter.productConvertToResponseDto(product);
        return dto;
    }

    public List<ProductResponseDto> getAllProductByCategory(Category productcategory){

        List<Product> products =productRepo.findAllByProductCategory(productcategory);
        List<ProductResponseDto> responseDtos=new ArrayList<>();
        for(Product pro:products)
        {
            ProductResponseDto productResponseDto=ProductConverter.productConvertToResponseDto(pro);
            responseDtos.add(productResponseDto);
        }

        return responseDtos;
    }
}
