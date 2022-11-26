package co.zero.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
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
    private String version;
    private List<String> countries;
    private List<String> tags;
    private Map<String, Object> model;

    public FormModel(String name, String version, List<String> countries, List<String> tags, Map<String, Object> model) {
        this.name = name;
        this.version = version;
        this.countries = countries;
        this.tags = tags;
        this.model = model;
    }
}
