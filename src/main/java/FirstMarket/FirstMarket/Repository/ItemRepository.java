package FirstMarket.FirstMarket.Repository;

import FirstMarket.FirstMarket.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{

}