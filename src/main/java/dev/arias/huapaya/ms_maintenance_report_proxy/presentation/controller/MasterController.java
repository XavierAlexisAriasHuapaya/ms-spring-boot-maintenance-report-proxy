package dev.arias.huapaya.ms_maintenance_report_proxy.presentation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.ms_maintenance_report_proxy.service.interfaces.MasterService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "master")
@AllArgsConstructor
public class MasterController {

    private final MasterService masterService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        Map<String, Object> response = new HashMap<>();
        response = this.masterService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
