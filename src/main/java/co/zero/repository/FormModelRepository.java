package co.zero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

import co.zero.model.FormModel;

public interface FormModelRepository extends MongoRepository<FormModel, String> {
    Collection<FormModel> findByTagsIn(List<String> tags);
}
