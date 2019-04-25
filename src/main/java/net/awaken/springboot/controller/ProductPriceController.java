package net.awaken.springboot.controller;

import net.awaken.springboot.domain.ProductPrice;
import net.awaken.springboot.repository.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Finn Zhao
 */
@Controller
@RequestMapping("/price")
public class ProductPriceController {

    private ProductPriceRepository productPriceRepository;

    @Autowired
    public ProductPriceController(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }

    @RequestMapping(value = "/{product}", method = RequestMethod.GET)
    public String searchPrice(@PathVariable("product") String product, Model model) {
        List<ProductPrice> prices = this.productPriceRepository.findByProduct(product);
        if (prices != null) {
            model.addAttribute("prices", prices);
        }
        return "priceList";
    }

    @RequestMapping(value = "/{product}", method = RequestMethod.POST)
    public String addToPriceList(@PathVariable("product") String product, ProductPrice productPrice) {
        productPrice.setProduct(product);
        this.productPriceRepository.save(productPrice);
        return "redirect:/{product}";
    }

}
