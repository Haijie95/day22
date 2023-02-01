package haijie.Day22.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private Integer id;

    private String roomType; //if generate DB from code, it will create a field called room_type
    
    private Integer price;
}
