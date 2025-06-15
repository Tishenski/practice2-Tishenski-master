package ua.opnu.practice1_template.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.model.Facility;
import ua.opnu.practice1_template.service.FacilityService;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping
    public ResponseEntity<Facility> addFacility(@RequestBody Facility facility) {
        return ResponseEntity.ok(facilityService.addFacility(facility));
    }

    @GetMapping("/workspace/{workspaceId}")
    public ResponseEntity<List<Facility>> getFacilitiesByWorkspace(@PathVariable Long workspaceId) {
        return ResponseEntity.ok(facilityService.getFacilitiesByWorkspace(workspaceId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facility> updateFacility(@PathVariable Long id, @RequestBody Facility facility) {
        Facility updated = facilityService.updateFacility(id, facility);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacility(@PathVariable Long id) {
        facilityService.deleteFacility(id);
        return ResponseEntity.noContent().build();
    }
}
