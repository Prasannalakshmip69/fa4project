package com.infosys.infytel.product.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.infytel.product.dto.ProductDTO;
import com.infosys.infytel.product.dto.SubscribedProductDTO;
import com.infosys.infytel.product.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;
	
//	list all products
	@RequestMapping(value = "api/buyer/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SubscribedProductDTO> getAllProduct() {
		logger.info("Fetching all past Orders");
		return productService.getAllProduct();
	}
//	list all products based on category
	@RequestMapping(value = "api/buyer/product/{category}/category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getAllProduct2(@PathVariable String category) throws Exception{
		logger.info("Fetching all past Orders");
		return productService.getAllProduct2(category);
	}
//	list all products based on product name
	@RequestMapping(value = "api/buyer/product/{name}/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getAllProduct3(@PathVariable String name) throws Exception{
		logger.info("Fetching all past Orders");
		return productService.getAllProduct3(name);
	}
	
//	list all products based on product id
	@RequestMapping(value = "api/buyer/product/{prodId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getProductDetails(@PathVariable String prodId) throws Exception{
		logger.info("Fetching all past Orders");
		return productService.getProductDetails(prodId);
	}

//	new order by buyer, check product exist and change stock
	@RequestMapping(value = "api/buyer/product/{prodId}/quantity/{quantity}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getProductOrderd(@PathVariable String prodId,@PathVariable Integer quantity) throws Exception{
		logger.info("stock {} {}",prodId,quantity);
		return productService.getProductOrderd(prodId,quantity);
	}
	
//	Adding new product
	@PostMapping(value = "api/seller/product")
	public String register(@Valid @RequestBody ProductDTO productDTO) throws Exception {
		logger.info("Register request for buy {}",productDTO);
		return productService.addProduct(productDTO);
	}
	
//	Remove product
	@RequestMapping(value = "api/seller/product/{prodId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletProduct(@PathVariable String prodId) throws Exception{
		logger.info("deleting product from whishlist add to cart {}", prodId);
		String message=productService.deleteProduct(prodId);
		return message;
	}
	
//	return no of stocks available
	@RequestMapping(value = "/api/buyer/stock/{buyerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer getProductStock(@PathVariable String buyerId) {
		logger.info("Fetching buyer order address {}", buyerId);
		return Integer.parseInt(productService.getProductStock(buyerId));
	}

// 	return seller ID
	@RequestMapping(value = "/api/seller/product/id/{prodId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getSellerId(@PathVariable String prodId) throws Exception {
		logger.info("Fetching seller for productid {}", prodId);
		return productService.getSellerId(prodId);
	}
}
