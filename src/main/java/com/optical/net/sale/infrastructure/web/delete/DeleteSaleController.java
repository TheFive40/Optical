package com.optical.net.sale.infrastructure.web.delete;

import com.optical.net.sale.application.SaleCrudCaseAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/sale")
@RestController
public class DeleteSaleController {

    private final SaleCrudCaseAdapter saleCrudCaseAdapter;

    public DeleteSaleController(SaleCrudCaseAdapter saleCrudCaseAdapter) {
        this.saleCrudCaseAdapter = saleCrudCaseAdapter;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable Long id){
        saleCrudCaseAdapter.remove(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }

}
