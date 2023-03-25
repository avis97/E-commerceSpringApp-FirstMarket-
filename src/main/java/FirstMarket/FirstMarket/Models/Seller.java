package FirstMarket.FirstMarket.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Seller")
public class Seller {
    //Sellers is a parent of product class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sId;
    private String sName;
    @Column(unique = true)
    private String sEmail;
    @Column(unique = true)
    private String sPhnNo;
    @Column(unique = true)
    private String sPanNo;

    @OneToMany(mappedBy = "sellers",cascade = CascadeType.ALL)
    List<Product> product=new ArrayList<>();

}
