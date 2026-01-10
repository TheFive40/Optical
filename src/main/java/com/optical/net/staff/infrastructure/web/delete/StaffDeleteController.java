package com.optical.net.staff.infrastructure.web.delete;

import com.optical.net.staff.application.StaffCaseAdapter;
import com.optical.net.staff.infrastructure.persistence.ports.CrudStaffPortAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
public class StaffDeleteController {


    private final CrudStaffPortAdapter crudStaffPortAdapter;

    public StaffDeleteController(CrudStaffPortAdapter crudStaffPortAdapter) {
        this.crudStaffPortAdapter = crudStaffPortAdapter;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id){
        crudStaffPortAdapter.deleteStaff(id);
        return ResponseEntity.ok("Staff eliminado correctamente");
    }
}
