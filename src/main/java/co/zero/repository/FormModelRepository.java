package co.zero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.zero.model.FormModel;

public interface FormModelRepository extends MongoRepository<FormModel, String> {
}
