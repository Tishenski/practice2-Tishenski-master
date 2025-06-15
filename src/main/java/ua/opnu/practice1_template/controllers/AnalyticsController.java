package ua.opnu.practice1_template.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.service.AnalyticsService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/available-workspaces")
    public ResponseEntity<List<Long>> getAvailableWorkspaces(@RequestParam String date) {
        return ResponseEntity.ok(analyticsService.getAvailableWorkspaceIds(LocalDate.parse(date)));
    }

    @GetMapping("/booking-count/{workspaceId}")
    public ResponseEntity<Long> getBookingCount(@PathVariable Long workspaceId) {
        return ResponseEntity.ok(analyticsService.getBookingCountByWorkspace(workspaceId));
    }

    @GetMapping("/popular-timeslots")
    public ResponseEntity<List<String>> getPopularTimeSlots() {
        return ResponseEntity.ok(analyticsService.getPopularTimeSlots());
    }

    @GetMapping("/workspace-income")
    public ResponseEntity<Map<String, BigDecimal>> getIncomeByWorkspace() {
        return ResponseEntity.ok(analyticsService.getIncomeByWorkspace());
    }

    @GetMapping("/active-users")
    public ResponseEntity<List<Long>> getMostActiveUsers() {
        return ResponseEntity.ok(analyticsService.getMostActiveUsers());
    }

    @GetMapping("/monthly-stats")
    public ResponseEntity<Map<Month, Long>> getMonthlyStats() {
        return ResponseEntity.ok(analyticsService.getMonthlyBookingStats());
    }
}

