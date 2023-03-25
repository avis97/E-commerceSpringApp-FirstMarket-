package FirstMarket.FirstMarket.Models;

import FirstMarket.FirstMarket.Enum.CardType;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="card")
public class Card{

    //card is a child class of customer class.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    private String cardNo;
    private int cvv;
    @Enumerated(EnumType.STRING)
    private CardType cardtype;
    @ManyToOne
    @JoinColumn
    Customer customer;
}
