package kniga.project.bookshop.repos;

import kniga.project.bookshop.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findAuthorByName(String name);

    @Query(value = "SELECT author.id, author.name, author.description FROM author as a where author.id = :id",nativeQuery = true)
    Optional<Author> findMyAuthor(Long id);
}
