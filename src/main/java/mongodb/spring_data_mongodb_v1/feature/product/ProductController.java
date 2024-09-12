package mongodb.spring_data_mongodb_v1.feature.product;

import lombok.RequiredArgsConstructor;
import mongodb.spring_data_mongodb_v1.domain.Product;
import mongodb.spring_data_mongodb_v1.feature.product.dto.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public Page<Product> getProducts(@RequestParam int page, @RequestParam int size) {
        return productService.findAll(page, size);
    }

    @GetMapping("/name/{name}")
    public Optional<Product> findByName(@PathVariable String name){
        return productService.findByName(name);
    }

    @PreAuthorize("hasAuthority('SCOPE_openid')")
    @GetMapping("/id/{id}")
    public Optional<Product> findById(@PathVariable String id){
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductRequest request){
        productService.createProduct(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    public void updateById(@PathVariable String id, @RequestBody ProductRequest request){
        productService.updateProductById(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        productService.deleteProductById(id);
    }
}