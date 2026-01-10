package com.optical.net.product.infrastructure.web.delete;

import com.optical.net.product.infrastructure.persistence.ProductPortAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/product")
public class ProductRemoveController {

    private final ProductPortAdapter productPortAdapter;

    public ProductRemoveController(ProductPortAdapter productPortAdapter) {
        this.productPortAdapter = productPortAdapter;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, String>> delete(@PathVariable Long id) {
        productPortAdapter.remove(id);
        HashMap<String, String> object = new HashMap<>();
        object.put("id", id.toString());
        object.put("status", "deleted");
        return ResponseEntity.ok(object);
    }
}
