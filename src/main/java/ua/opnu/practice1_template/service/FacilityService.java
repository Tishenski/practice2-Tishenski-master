package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Facility;
import ua.opnu.practice1_template.repository.FacilityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService {

    private final FacilityRepository facilityRepository;

    @Autowired
    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public Facility addFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    public List<Facility> getFacilitiesByWorkspace(Long workspaceId) {
        return facilityRepository.findByWorkspaceId(workspaceId);
    }

    public Facility updateFacility(Long id, Facility updated) {
        Optional<Facility> optional = facilityRepository.findById(id);
        if (optional.isPresent()) {
            Facility facility = optional.get();
            facility.setName(updated.getName());
            facility.setAvailable(updated.getAvailable());
            facility.setWorkspace(updated.getWorkspace());
            return facilityRepository.save(facility);
        }
        return null;
    }

    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }
}
