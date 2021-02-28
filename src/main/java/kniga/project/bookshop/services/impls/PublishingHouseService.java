package kniga.project.bookshop.services.impls;

import kniga.project.bookshop.entity.Order;
import kniga.project.bookshop.entity.PublishingHouse;
import kniga.project.bookshop.repos.OrderRepository;
import kniga.project.bookshop.repos.PublishingHouseRepository;
import kniga.project.bookshop.services.interfaces.IPublishingHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PublishingHouseService implements IPublishingHouseService {
    private final PublishingHouseRepository repository;

    @Override
    public PublishingHouse save(PublishingHouse publishingHouse) {
        return repository.save(publishingHouse);
    }

    @Override
    public PublishingHouse getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    public Set<PublishingHouse> getAll() {
        List<PublishingHouse> list = repository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public PublishingHouse edit(PublishingHouse publishingHouse) {
        return repository.save(publishingHouse);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
