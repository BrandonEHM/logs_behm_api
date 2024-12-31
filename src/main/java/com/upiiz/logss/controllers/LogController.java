package com.upiiz.logss.controllers;

import com.upiiz.logss.dto.LogDTO;
import com.upiiz.logss.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<LogDTO>> getAllLogs() {
        return ResponseEntity.ok(logService.getAllLogs());
    }
//-----------
    /*
    @GetMapping("/api/v1/logs/all")
    public ResponseEntity<String> getLogs() {
        return ResponseEntity.ok("Prueba exitosa");
    }
*/
//-----------
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<LogDTO> getLogById(@PathVariable Long id) {
        LogDTO log = logService.getLogById(id);
        return log != null ? ResponseEntity.ok(log) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<LogDTO> createLog(@RequestBody LogDTO logDTO) {
        return ResponseEntity.ok(logService.createLog(logDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<LogDTO> updateLog(@PathVariable Long id, @RequestBody LogDTO logDTO) {
        LogDTO updatedLog = logService.updateLog(id, logDTO);
        return updatedLog != null ? ResponseEntity.ok(updatedLog) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        logService.deleteLog(id);
        return ResponseEntity.ok().build();
    }
}