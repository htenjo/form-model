package co.zero.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import co.zero.model.FormModel;
import co.zero.repository.FormModelRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FormModelRestController implements FormModelAPI {
    private FormModelRepository repository;

    public FormModelRestController(FormModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FormModel> list() {
        return repository.findAll();
    }

    @Override
    public FormModel create(FormModel model) {
        return repository.save(model);
    }

    @Override
    public Optional<FormModel> find(String id) {
        return repository.findById(id);
    }

    @Override
    public FormModel update(String id, FormModel model) {
        model.setId(id);
        return repository.save(model);
    }

    @Override
    public void delete(String id) {
        log.info("::: Deleting by id = {}", id);
        repository.deleteById(id);
    }

    @Override
    public Collection<FormModel> listFilteringByTag(List<String> tags) {
        log.info("::: Filtering by TAG");
        return repository.findByTagsIn(tags);
    }
}
