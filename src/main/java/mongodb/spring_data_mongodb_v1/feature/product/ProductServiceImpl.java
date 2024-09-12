package mongodb.spring_data_mongodb_v1.feature.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mongodb.spring_data_mongodb_v1.domain.Product;
import mongodb.spring_data_mongodb_v1.feature.product.dto.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Page<Product> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return productRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void createProduct(ProductRequest request) {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(request.name());
        product.setDesc(request.desc());
        product.setQty(request.qty());
        product.setPriceUnit(request.priceUnit());
        productRepository.save(product);
    }

    @Override
    public void updateProductById(String id, ProductRequest request) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            product.get().setName(request.name());
            product.get().setDesc(request.desc());
            product.get().setQty(request.qty());
            product.get().setPriceUnit(request.priceUnit());
            productRepository.save(product.get());
        }else{
            log.error("Product with id {} not found", id);
        }
    }

    @Override
    public void deleteProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(productRepository::delete);
    }
}
