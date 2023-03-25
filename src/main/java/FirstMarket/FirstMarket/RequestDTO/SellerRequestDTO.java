package FirstMarket.FirstMarket.RequestDTO;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerRequestDTO {
    private String name;
    private String email;
    private String phNum;
    private String panNum;
}
