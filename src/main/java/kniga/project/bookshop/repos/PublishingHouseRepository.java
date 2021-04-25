package kniga.project.bookshop.repos;

import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.PublishingHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, Long> {
    Page<PublishingHouse> findAll(Pageable pageable);
}
