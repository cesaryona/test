package com.test.mapper;

import com.test.controller.request.ProductRequestBody;
import com.test.controller.request.UserRequestBody;
import com.test.repository.entity.ProductEntity;
import com.test.repository.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        ProductMapperImpl.class
})
class ProductMapperTest {

    private static final String NAME = "product01";
    private static final BigDecimal PRICE = BigDecimal.TEN;

    @Autowired
    private ProductMapper mapper;

    @Test
    void toEntity() {
        var request = ProductRequestBody.builder()
                .name(NAME)
                .price(PRICE)
                .build();

        var response = mapper.toEntity(request);

        assertThat(response).isNotNull();
        assertThat(response.getName()).isEqualTo(NAME);
        assertThat(response.getPrice()).isEqualTo(PRICE);
    }

    @Test
    void toResponseBody() {
        var entity = ProductEntity.builder()
                .name(NAME)
                .price(PRICE)
                .build();

        var response = mapper.toResponseBody(entity);

        assertThat(response).isNotNull();
        assertThat(response.getName()).isEqualTo(NAME);
        assertThat(response.getPrice()).isEqualTo(PRICE);
    }
}