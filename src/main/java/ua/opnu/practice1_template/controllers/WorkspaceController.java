package ua.opnu.practice1_template.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.model.Workspace;
import ua.opnu.practice1_template.service.WorkspaceService;

import java.util.List;

@RestController
@RequestMapping("/workspaces")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @Autowired
    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @PostMapping
    public ResponseEntity<Workspace> addWorkspace(@RequestBody Workspace workspace) {
        return ResponseEntity.ok(workspaceService.addWorkspace(workspace));
    }

    @GetMapping
    public ResponseEntity<List<Workspace>> getAllWorkspaces() {
        return ResponseEntity.ok(workspaceService.getAllWorkspaces());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workspace> updateWorkspace(@PathVariable Long id, @RequestBody Workspace workspace) {
        Workspace updated = workspaceService.updateWorkspace(id, workspace);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkspace(@PathVariable Long id) {
        workspaceService.deleteWorkspace(id);
        return ResponseEntity.noContent().build();
    }
}
