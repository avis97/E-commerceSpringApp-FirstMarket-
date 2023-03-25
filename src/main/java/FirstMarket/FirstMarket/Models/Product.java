package FirstMarket.FirstMarket.Models;

import FirstMarket.FirstMarket.Enum.Category;
import FirstMarket.FirstMarket.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="product")
public class Product {
    //product is a child of seller class so here ManytoOne relationship between product and sellers
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String productName;
    private int productPrice;
    private int productQuantity;
    @Enumerated(EnumType.STRING)
    private Category productCategory;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
    @ManyToOne
    @JoinColumn
    Seller sellers;
    @OneToOne(mappedBy = "products",cascade = CascadeType.ALL)
    Item item;
}
