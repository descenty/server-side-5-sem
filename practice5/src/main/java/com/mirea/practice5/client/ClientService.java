package com.mirea.practice5.client;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.mirea.practice5.client.schema.ClientCreate;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getById(UUID id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Optional<UUID> create(ClientCreate ClientCreate) {
        return Optional.of(clientMapper.toEntity(ClientCreate)).map(clientRepository::save).map(Client::getId);
    }

    @Transactional
    public Optional<Client> partialUpdate(UUID id, ClientCreate ClientCreate) {
        return clientRepository.findById(id).map(Client -> clientMapper.update(Client, ClientCreate)).map(clientRepository::save);
    }

    @Transactional
    public boolean delete(UUID id) {
        return clientRepository.findById(id).map(Client -> {
            clientRepository.delete(Client);
            return true;
        }).orElse(false);
    }

}