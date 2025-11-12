package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.domainDTO.SectionDeviceDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.SaveSectionDeviceDTO;
import com.gopassa.retailer_service.domain.entities.Device;
import com.gopassa.retailer_service.domain.entities.Section;
import com.gopassa.retailer_service.domain.entities.SectionDevice;
import com.gopassa.retailer_service.repository.SectionDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionDeviceService {

    private final SectionDeviceRepository sectionDeviceRepository;
    private final SectionService sectionService;
    private final DeviceService deviceService;

    public List<SectionDevice> findAll() {
        return sectionDeviceRepository.findAll();
    }

    public SectionDevice create(SaveSectionDeviceDTO saveSectionDeviceDTO){

        Section section = sectionService.findById(saveSectionDeviceDTO.getSectionId());
        Device device = deviceService.findById(saveSectionDeviceDTO.getDeviceId());

        SectionDevice sectionDevice = SectionDevice.builder()
                .section(section)
                .device(device)
                .build();

        sectionDeviceRepository.save(sectionDevice);

        return sectionDevice;
    }


    public SectionDevice findById(String id) {
        return sectionDeviceRepository.findById(id).orElse(null);
    }



    public SectionDevice update(String id, SaveSectionDeviceDTO saveSectionDeviceDTO) {

        Section section = sectionService.findById(saveSectionDeviceDTO.getSectionId());
        Device device = deviceService.findById(saveSectionDeviceDTO.getDeviceId());

        SectionDevice sectionDevice = findById(id);
        sectionDevice.setSection(section);
        sectionDevice.setDevice(device);

        return sectionDeviceRepository.save(sectionDevice);
    }


    public void delete(String id) {
        sectionDeviceRepository.deleteById(id);
    }
}
