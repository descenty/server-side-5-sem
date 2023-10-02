package com.mirea.practice5.telephone;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.mirea.practice5.telephone.schema.TelephoneCreate;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelephoneService {
    private final TelephoneRepository telephoneRepository;
    private final TelephoneMapper telephoneMapper;

    public List<Telephone> getAll() {
        return telephoneRepository.findAll();
    }

    public Optional<Telephone> getById(Long id) {
        return telephoneRepository.findById(id);
    }

    @Transactional
    public Optional<Long> create(TelephoneCreate TelephoneCreate) {
        return Optional.of(telephoneMapper.toEntity(TelephoneCreate)).map(telephoneRepository::save).map(Telephone::id);
    }

    @Transactional
    public Optional<Telephone> partialUpdate(Long id, TelephoneCreate TelephoneCreate) {
        return telephoneRepository.findById(id).map(Telephone -> telephoneMapper.update(Telephone, TelephoneCreate)).map(telephoneRepository::save);
    }

    @Transactional
    public boolean delete(Long id) {
        return telephoneRepository.findById(id).map(Telephone -> {
            telephoneRepository.delete(Telephone);
            return true;
        }).orElse(false);
    }

}