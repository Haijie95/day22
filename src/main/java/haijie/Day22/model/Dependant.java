package haijie.Day22.model;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dependant {
        private Integer id;

        private String fullname;

        private String relatiomship;

        private Date birthdate;

}
