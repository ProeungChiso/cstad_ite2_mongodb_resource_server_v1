package mongodb.spring_data_mongodb_v1.feature.product;
import mongodb.spring_data_mongodb_v1.domain.Product;
import mongodb.spring_data_mongodb_v1.feature.product.dto.ProductRequest;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface ProductService {
   Page<Product> findAll(int page, int size);
   Optional<Product> findByName(String name);
   Optional<Product> findById(String id);
   void createProduct(ProductRequest request);
   void updateProductById(String id, ProductRequest request);
   void deleteProductById(String id);
}
