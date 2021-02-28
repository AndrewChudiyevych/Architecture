package kniga.project.bookshop.services.interfaces;

import kniga.project.bookshop.entity.PublishingHouse;
import kniga.project.bookshop.entity.Reports;
import kniga.project.bookshop.services.impls.PublishingHouseService;

import java.util.Set;

public interface IPublishingHouseService {
    PublishingHouse save(PublishingHouse publishingHouse);
    PublishingHouse getById(Long id);
    Set<PublishingHouse> getAll();
    PublishingHouse edit(PublishingHouse publishingHouse);
    void delete(Long id);
}
