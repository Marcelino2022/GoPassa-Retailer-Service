package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.DeviceDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateDeviceDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateDeviceDTO;
import com.gopassa.retailer_service.application.services.DeviceService;
import com.gopassa.retailer_service.domain.entities.Device;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping
    public ResponseEntity<List<DeviceDTO>> findAll() {
        List<Device> devices = deviceService.findAll();
        List<DeviceDTO> deviceDTOs = devices
                .stream()
                .map(DeviceDTO::create)
                .toList();

        return ResponseEntity.ok(deviceDTOs);
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> create(@RequestBody CreateDeviceDTO createDeviceDTO) {
        Device device = deviceService.create(createDeviceDTO);
        return ResponseEntity.created(URI.create("/devices/" + device.getId()))
                .body(DeviceDTO.create(device));
    }

    @GetMapping("{id}")
    public ResponseEntity<DeviceDTO> findById(@PathVariable String id) {
        Device device = deviceService.findById(id);
        return ResponseEntity.ok(DeviceDTO.create(device));
    }

    @PutMapping("{id}")
    public ResponseEntity<DeviceDTO> update(@PathVariable String id, @RequestBody UpdateDeviceDTO updateDeviceDTO) {
        Device device = deviceService.update(id, updateDeviceDTO);
        return ResponseEntity.ok(DeviceDTO.create(device));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DeviceDTO> delete(@PathVariable String id) {
        deviceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
