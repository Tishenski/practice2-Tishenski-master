package ua.opnu.practice1_template.repository;

import org.springframework.data.repository.CrudRepository;
import ua.opnu.practice1_template.model.Facility;

import java.util.List;

public interface FacilityRepository extends CrudRepository<Facility, Long> {
    List<Facility> findByWorkspaceId(Long workspaceId);
}
