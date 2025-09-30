package com.example.shop.product;

import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller //컨트롤러 어노테이션
@ResponseBody // 반환 받은 값을 http 응답 본문에 직접 작성해줌
@RequiredArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 생성
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    // service 계층을 이용하기 위한 어노테이션

    @PostMapping   // 상품 정보 등록
    public ResponseEntity<Product> createProduct(@RequestBody ProductCreateRequest product) {
        Long productId = productService.createProduct(request);
        return ResponseEntity.created(URI.create("/products/" + productId)).build();
    }

    @GetMapping   // 상품 목록 조회
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")    // 개별 상품 정보 상세 조회
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{productId}")  // 상품 정보 수정
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long productId, // 경로에서 Id 가져옴
            @RequestBody ProductUpdateRequest request) { // 본문에서 업데이트 데이터를 가져옴
        productService.updateProduct(productId, request);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{productId}") // 상품 삭제
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
        // 성공적으로 삭제시 204 no content 출력
    }







}