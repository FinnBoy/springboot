package net.awaken.springboot.repository;

import net.awaken.springboot.domain.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Finn Zhao
 */
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {

    List<ProductPrice> findByProduct(String product);

}
