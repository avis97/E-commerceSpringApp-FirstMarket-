package FirstMarket.FirstMarket.Repository;

import FirstMarket.FirstMarket.Enum.Category;
import FirstMarket.FirstMarket.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

         List<Product> findAllByProductCategory(Category category);
}
