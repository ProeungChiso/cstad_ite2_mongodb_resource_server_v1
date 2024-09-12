package mongodb.spring_data_mongodb_v1.feature.product;

import mongodb.spring_data_mongodb_v1.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByName(String name);
}
