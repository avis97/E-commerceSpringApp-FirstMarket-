package FirstMarket.FirstMarket.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.util.*;
import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Ordered{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oId;
    @CreationTimestamp
    private Date DeliveryDate;
    private int total;
    private int deliveryCharges;
    private String usedCardNoForPayment;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    List<Item> item=new ArrayList<>();

}
