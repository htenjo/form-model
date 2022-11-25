package co.zero.controller;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import co.zero.model.FormModel;

public interface FormModelAPI {
    String BASE_PATH = "/";
    String ID_PATH = BASE_PATH + "{id}";

    @GetMapping(value = BASE_PATH, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    Collection<FormModel> list();

    @PostMapping(BASE_PATH)
    FormModel create(@RequestBody FormModel model);

    @GetMapping(ID_PATH)
    Optional<FormModel> find(@PathVariable String id);

    @PutMapping(ID_PATH)
    FormModel update(@PathVariable String id, @RequestBody FormModel model);

    @DeleteMapping(ID_PATH)
    void delete(@PathVariable String id);

    @GetMapping(value = BASE_PATH, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, params = "tags")
    Collection<FormModel> listFilteringByTag(@RequestParam List<String> tags);
}
