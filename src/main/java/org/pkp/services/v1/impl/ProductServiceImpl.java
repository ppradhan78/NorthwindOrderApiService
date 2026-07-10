package org.pkp.services.v1.impl;

import org.pkp.dto.v1.response.ProductResponse;
import org.pkp.mapper.v1.ProductMapper;
import org.pkp.repository.ProductRepository;
import org.pkp.services.v1.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
