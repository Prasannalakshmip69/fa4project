package com.infosys.infytel.product;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infosys.infytel.product.dto.ProductDTO;
import com.infosys.infytel.product.dto.SubscribedProductDTO;
import com.infosys.infytel.product.service.ProductService;

@SpringBootTest
class ProductApplicationTests {
	@Mock
	ProductService productService =new ProductService();
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void productExist() throws Exception {
		productService.productExist("P101");
		logger.info("success");
	}
    public void addproduct() throws Exception {
     ProductDTO productDTO =new ProductDTO();
     productDTO.getProdId();
	 logger.info("success");

	}
    public void deletproduct() throws Exception {
        ProductDTO productDTO =new ProductDTO();
        productDTO.getProdId();
   	 logger.info("success");
    }
    public void getProductDetails() throws Exception {
        ProductDTO productDTO =new ProductDTO();
        productDTO.getProdId();
   	 logger.info("success");
    }

	@Test
	void contextLoads() {
	}

}