package kniga.project.bookshop.services;

import kniga.project.bookshop.dto.PublishingHouseRequest;
import kniga.project.bookshop.entity.PublishingHouse;
import kniga.project.bookshop.entity.Reports;
import kniga.project.bookshop.mappers.PublishingHouseMapper;
import kniga.project.bookshop.repos.PublishingHouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PublishingHouseService {

    private final PublishingHouseRepository repository;
    private final PublishingHouseMapper mapper;


    public PublishingHouse save(PublishingHouse publishingHouse) {
        return repository.save(publishingHouse);
    }


    public PublishingHouse getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }


    public Set<PublishingHouse> getAll() {
        List<PublishingHouse> list = repository.findAll();
        return new HashSet<>(list);
    }


    public PublishingHouse update(Long id, PublishingHouse publishingHouse) {
        PublishingHouse publishingHouse1 = repository.findById(id).orElseThrow(null);
        publishingHouse1 = publishingHouse;
        return repository.save(publishingHouse1);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public PublishingHouse create(PublishingHouseRequest request) {
        var publishingHouse = mapper.fromRequest(request);
        return repository.save(publishingHouse);
    }
}
