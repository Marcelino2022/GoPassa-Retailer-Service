package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.SectionDeviceDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.SaveSectionDeviceDTO;
import com.gopassa.retailer_service.application.services.SectionDeviceService;
import com.gopassa.retailer_service.domain.entities.SectionDevice;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("section-devices")
@AllArgsConstructor
public class SectionDeviceController {

    private final SectionDeviceService sectionDeviceService;


    @GetMapping
    public ResponseEntity<List<SectionDeviceDTO>> findAll() {

        List<SectionDevice> sectionDevices = sectionDeviceService.findAll();
        List<SectionDeviceDTO> sectionDeviceDTOs = sectionDevices
                .stream()
                .map(SectionDeviceDTO::create)
                .toList();

        return ResponseEntity.ok(sectionDeviceDTOs);
    }


    @PostMapping
    public ResponseEntity<SectionDeviceDTO> create(@RequestBody @Valid SaveSectionDeviceDTO saveSectionDeviceDTO) {
        SectionDevice sectionDevice = sectionDeviceService.create(saveSectionDeviceDTO);
        return ResponseEntity.created(URI.create("section-devices/" + sectionDevice.getId()))
                .body(SectionDeviceDTO.create(sectionDevice));
    }


    @GetMapping("{id}")
    public ResponseEntity<SectionDeviceDTO> findById(@PathVariable @Valid String id) {
        SectionDevice sectionDevice = sectionDeviceService.findById(id);
        return ResponseEntity.ok(SectionDeviceDTO.create(sectionDevice));
    }

    @PutMapping("{id}")
    public ResponseEntity<SectionDeviceDTO> update(@PathVariable @Valid String id,
                                                   @RequestBody @Valid SaveSectionDeviceDTO saveSectionDeviceDTO) {
        SectionDevice sectionDevice = sectionDeviceService.update(id, saveSectionDeviceDTO);
        return ResponseEntity.ok(SectionDeviceDTO.create(sectionDevice));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid String id) {
        sectionDeviceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
