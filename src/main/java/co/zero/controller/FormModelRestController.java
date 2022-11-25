package co.zero.controller;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import co.zero.model.FormModel;
import co.zero.repository.FormModelRepository;

@RestController
public class FormModelRestController {
    private FormModelRepository repository;

    public FormModelRestController(FormModelRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public List<FormModel> list() {
        return repository.findAll();
    }

    @PostMapping("/")
    public FormModel create(@RequestBody FormModel model) {
        return repository.save(model);
    }

    @GetMapping("/{id}")
    public Optional<FormModel> find(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public FormModel update(@PathVariable("id") String id, @RequestBody FormModel model) {
        model.setId(id);
        return repository.save(model);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        repository.deleteById(id);
        return "::: ID deleted = " + id;
    }
}
