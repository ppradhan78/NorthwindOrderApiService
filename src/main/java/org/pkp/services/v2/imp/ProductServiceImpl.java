package org.pkp.services.v2.imp;

import org.pkp.dto.v2.response.ProductResponse;
import org.pkp.mapper.v2.ProductMapper;
import org.pkp.repository.ProductRepository;
import org.pkp.services.v2.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("productServiceV2") // <-- Explicit name
public class ProductServiceImpl implements ProductService {
    @Autowired
    private  ProductRepository repository;
    @Autowired
    private ProductMapper mapper;
//    public ProductServiceImpl(ProductRepository productRepository){
//        this.productRepository=productRepository;
//    }
    @Override
    public List<ProductResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse).collect(Collectors.toList());
    }
}
