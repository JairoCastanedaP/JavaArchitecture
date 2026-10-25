package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.service;

import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.SupplierResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.entity.SupplierEntity;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.exceptions.SupplierDuplicateException;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.exceptions.SupplierNotFoundException;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.mapper.SupplierMapper;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.repository.SupplierRepository;
import java.util.List;
import java.util.Optional;

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
                .orElseThrow(() -> new SupplierNotFoundException("Supplier not found with id " + id));
    }

    @Override
    public Long save(SupplierRequestDto supplier) {
        SupplierEntity existingSupplierByCompanyName = supplierRepository.findByCompanyName(supplier.companyName());
        if (existingSupplierByCompanyName != null) {
            throw new SupplierDuplicateException("Supplier already exists with company name " + supplier.companyName());
        }
        Optional<SupplierEntity> existingSupplierByDocumentNumber =
                supplierRepository.findByDocumentNumber(supplier.documentNumber());
        if (existingSupplierByDocumentNumber.isPresent()) {
            throw new SupplierDuplicateException("Supplier already exists with document number "
                    + supplier.documentNumber()
                    + " and company name "
                    + supplier.companyName());
        }
        SupplierEntity supplierEntity = this.supplierMapper.toEntity(supplier);
        supplierEntity.setSwDelete("1");
        return supplierRepository.save(supplierEntity).getId();
    }

    @Override
    public void update(Long id, SupplierRequestDto supplier) {
        SupplierEntity supplierEntity= supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException("Supplier not found with id " + id));
        SupplierEntity existingSupplierByCompanyName = supplierRepository.findByCompanyName(supplier.companyName());
        if (existingSupplierByCompanyName != null && !existingSupplierByCompanyName.getId().equals(id)) {
            throw new SupplierDuplicateException("Supplier already exists with company name "
                    + supplier.companyName());
        }
        Optional<SupplierEntity> existingSupplierByDocumentNumber =
                supplierRepository.findByDocumentNumber(supplier.documentNumber());
        if (existingSupplierByDocumentNumber.isPresent() && !existingSupplierByDocumentNumber.get().getId().equals(id)) {
            throw new SupplierDuplicateException("Supplier already exists with document number "
                    + supplier.documentNumber()
                    + " and company name "
                    + supplier.companyName());
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
                .orElseThrow(() -> new SupplierNotFoundException("Supplier not found with id " + id));
        supplierEntity.setSwDelete("0");
        this.supplierRepository.save(supplierEntity);
    }

    @Override
    public SupplierResponseDto findByDocumentNumber(String documentNumber) {
        return supplierRepository.findByDocumentNumber(documentNumber)
                .map(this.supplierMapper::toDto)
                .orElseThrow(() -> new SupplierNotFoundException("Supplier not found with document number " + documentNumber));
    }
}
