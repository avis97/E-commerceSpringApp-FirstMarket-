package FirstMarket.FirstMarket.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart")
public class Cart{
    //Cart is child of customer class..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cartNo;

    @OneToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    List<Item> item=new ArrayList<>();

}
