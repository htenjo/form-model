package co.zero.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Document(value = "models")
@Getter
@Setter
public class FormModel {
    @Id
    private String id;
    private String name;
    private Map<String, Object> model;

    public FormModel(String name) {
        this.name = name;
    }
}
