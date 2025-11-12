package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateDeviceDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateDeviceDTO;
import com.gopassa.retailer_service.domain.entities.Device;
import com.gopassa.retailer_service.domain.entities.Retailer;
import com.gopassa.retailer_service.repository.DeviceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final  RetailerService retailerService;

    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Transactional
    public Device create(CreateDeviceDTO createDeviceDTO) {

        Retailer retailer = retailerService.findById(createDeviceDTO.getRetailerId());

        Device device = Device
                .builder()
                .designation(createDeviceDTO.getDesignation())
                .iotDeviceId(createDeviceDTO.getIotDeviceId())
                .type(createDeviceDTO.getType())
                .retailer(retailer)
                .status(createDeviceDTO.getStatus())
                .build();

        return deviceRepository.save(device);
    }


    public Device findById(String id) {
        return deviceRepository.findById(id).orElse(null);
    }


    @Transactional
    public Device update(String id, UpdateDeviceDTO updateDeviceDTO) {

        Retailer retailer = retailerService.findById(updateDeviceDTO.getRetailerId());

        Device device = findById(id);
        device.setDesignation(updateDeviceDTO.getDesignation());
        device.setType(updateDeviceDTO.getType());
        device.setStatus(updateDeviceDTO.getStatus());
        device.setIotDeviceId(updateDeviceDTO.getIotDeviceId());
        device.setRetailer(retailer);

        return device;
    }

    @Transactional
    public void delete(String id) {
        Device device = findById(id);
        deviceRepository.delete(device);
    }
}
