package com.mirea.practice5.telephone;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.mirea.practice5.telephone.schema.TelephoneCreate;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TelephoneService {
    private final TelephoneRepository telephoneRepository;
    private final TelephoneMapper telephoneMapper;

    public List<Telephone> getAll() {
        return telephoneRepository.findAll();
    }

    public Optional<Telephone> getById(UUID id) {
        return telephoneRepository.findById(id);
    }

    @Transactional
    public Optional<UUID> create(TelephoneCreate TelephoneCreate) {
        return Optional.of(telephoneMapper.toEntity(TelephoneCreate)).map(telephoneRepository::save).map(Telephone::getId);
    }

    @Transactional
    public Optional<Telephone> partialUpdate(UUID id, TelephoneCreate TelephoneCreate) {
        return telephoneRepository.findById(id).map(Telephone -> telephoneMapper.update(Telephone, TelephoneCreate)).map(telephoneRepository::save);
    }

    @Transactional
    public boolean delete(UUID id) {
        return telephoneRepository.findById(id).map(Telephone -> {
            telephoneRepository.delete(Telephone);
            return true;
        }).orElse(false);
    }

}