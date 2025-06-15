package ua.opnu.practice1_template.repository;

import org.springframework.data.repository.CrudRepository;
import ua.opnu.practice1_template.model.Workspace;

public interface WorkspaceRepository extends CrudRepository<Workspace, Long> {
}

