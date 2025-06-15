package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Workspace;
import ua.opnu.practice1_template.repository.WorkspaceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    @Autowired
    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public Workspace addWorkspace(Workspace workspace) {
        return workspaceRepository.save(workspace);
    }

    public List<Workspace> getAllWorkspaces() {
        return (List<Workspace>) workspaceRepository.findAll();
    }

    public Workspace updateWorkspace(Long id, Workspace updated) {
        Optional<Workspace> optional = workspaceRepository.findById(id);
        if (optional.isPresent()) {
            Workspace existing = optional.get();
            existing.setName(updated.getName());
            existing.setCapacity(updated.getCapacity());
            existing.setLocation(updated.getLocation());
            return workspaceRepository.save(existing);
        }
        return null;
    }

    public void deleteWorkspace(Long id) {
        workspaceRepository.deleteById(id);
    }
}

