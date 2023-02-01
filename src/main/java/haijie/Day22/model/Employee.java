package haijie.Day22.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;

    private String firstName; 

    private String lastName;

    private Integer salary;

    private List<Dependant> dependants;
}
