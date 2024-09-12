package mongodb.spring_data_mongodb_v1.domain;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@Document("products")
public class Product {
    @Id
    String id;
    String name;
    String desc;
    Integer qty;
    Double priceUnit;
}
