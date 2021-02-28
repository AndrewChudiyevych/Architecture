package kniga.project.bookshop.controller;


import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.entity.PublishingHouse;
import kniga.project.bookshop.services.impls.PublishingHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/publishingHouses")
public class PublishingHouseController {

    private final PublishingHouseService servise;

    @GetMapping("/")
    public Set<PublishingHouse> getAllPublishingHouse(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                      @RequestParam(required = false, defaultValue = "1") Integer page) {
        return servise.getAll();
    }

    @GetMapping("/{id}")
    public PublishingHouse getPublishingHouseById(@PathVariable long id) {

        return servise.getById(id);
    }

    @PostMapping("/")
    public PublishingHouse createPublishingHouse(@RequestBody PublishingHouse publishingHouse) {

        return servise.save(publishingHouse);
    }

    @PutMapping("/{id}")
    public PublishingHouse updatePublishingHouse(@PathVariable long id, @RequestBody PublishingHouse publishingHouse) {
        return servise.edit(publishingHouse);
    }

    @DeleteMapping("/{id}")
    public void deletePublishingHouse(long id) {
        servise.delete(id);
    }

    @GetMapping("/{publishingHouse_id}/books")
    public List<Book> getBooksByPublishingHouse(@PathVariable long publishingHouse_id) {
        return null;
    }
}
