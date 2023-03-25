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
@Table(name="customer")
public class Customer{

    //Customer is a parent class of card class..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;
    private String cName;
    private int cAge;
    @Column(unique = true)
    private String cEmail;
    @Column(unique = true)
    private String cPhnNo;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Card> card=new ArrayList<>();
    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Ordered> order=new ArrayList<>();
}
