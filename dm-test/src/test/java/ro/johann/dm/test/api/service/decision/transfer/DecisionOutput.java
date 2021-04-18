package ro.johann.dm.test.api.service.decision.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class DecisionOutput {
  String id;
  String name;
  String description;
  List<CriteriaOutput> criteria = List.of();
  List<AlternativeOutput> alternatives = List.of();
  List<PropertyOutput> properties = List.of();
}
