package mongodb.spring_data_mongodb_v1.feature.product.dto;

public record ProductRequest(
        String name,
        String desc,
        Double priceUnit,
        Integer qty
) {
}
