package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.service;

import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.SupplierResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.entity.SupplierEntity;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.exceptions.SupplierException;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.mapper.SupplierMapper;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.repository.SupplierRepository;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;
    public SupplierServiceImpl(SupplierRepository supplierRepository,
                               SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public List<SupplierResponseDto> findAll() {
        return this.supplierRepository.findAll()
                .stream()
                .map(this.supplierMapper::toDto)
                .toList();
    }

    @Override
    public SupplierResponseDto findById(Long id) {
        return this.supplierRepository
                .findById(id)
                .map(this.supplierMapper::toDto)
                .orElseThrow(() -> new SupplierException("Supplier not found with id " + id));
    }

    @Override
    public Long save(SupplierRequestDto supplier) {
        SupplierEntity existingSupplier = supplierRepository.findByCompanyName(supplier.companyName());
        if (existingSupplier != null) {
            throw new SupplierException("Supplier already exists with company name " + supplier.companyName());
        }
        SupplierEntity supplierEntity = this.supplierMapper.toEntity(supplier);
        supplierEntity.setSwDelete("1");
        return supplierRepository.save(supplierEntity).getId();
    }

    @Override
    public void update(Long id, SupplierRequestDto supplier) {
        SupplierEntity supplierEntity= supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierException("Supplier not found with id " + id));
        SupplierEntity existingSupplier = supplierRepository.findByCompanyName(supplier.companyName());
        if (existingSupplier != null && !existingSupplier.getId().equals(id)) {
            throw new SupplierException("Supplier already exists with company name " + supplier.companyName());
        }
        supplierEntity.setCompanyName(supplier.companyName());
        supplierEntity.setEmail(supplier.email());
        supplierEntity.setPhone(supplier.phone());
        supplierEntity.setAddress(supplier.address());
        this.supplierRepository.save(supplierEntity);
    }

    @Override
    public void delete(Long id) {

        SupplierEntity supplierEntity= supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierException("Supplier not found with id " + id));
        // Physical delete
        //this.supplierRepository.delete(supplierEntity);
        supplierEntity.setSwDelete("0");
        this.supplierRepository.save(supplierEntity);
    }

    @Override
    public SupplierResponseDto findByDocumentNumber(String documentNumber) {
        return null;
    }
}
