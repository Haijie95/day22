package haijie.Day22.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import haijie.Day22.model.Room;

@Repository //this is a repo so need to annotate it
public class RoomRepoImpl implements RoomRepo { //this class is to implement the interface

    @Autowired
    JdbcTemplate jdbcTemplate;

    //this is what is in the mysql workbench
    String countSQL="select count(*) from room";
    String selectSQL="select * from room";
    String selectByIdSQL="select * from room where id = ?";
    String insertSQL="insert into room (room_type,price) values (?, ?)";
    String updateSQL="update room set room_type = ?, price = ? where id = ?";
    String deleteSQL="delete from room where id = ?";

    @Override
    public int count() {
        Integer result=0;
        //the integer.class is to tell what type of result to return
        result=jdbcTemplate.queryForObject(countSQL, Integer.class);
        return result;
    }

    @Override
    public Boolean save(Room room) {
        Boolean saved=false;
        //as prompt by the system we need the preparestatement callback
        //and since we getting boolean therefore change the t to boolean
        saved = jdbcTemplate.execute(insertSQL, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, room.getRoomType());
                ps.setInt(2, room.getPrice());
                Boolean rslt=ps.execute();
                return rslt;
            }
            
        });
        return saved;
    }

    @Override
    public List<Room> findall() {
        //List<Room> rList = new ArrayList<>();
        //rList = jdbcTemplate.query(selectSQL, BeanPropertyRowMapper.newInstance(Room.class));
        //return rList; 
        //Same meaning as below
        return jdbcTemplate.query(selectSQL, BeanPropertyRowMapper.newInstance(Room.class));
    }

    @Override
    public Room findById(Integer id) { 
        return jdbcTemplate.queryForObject(selectByIdSQL,BeanPropertyRowMapper.newInstance(Room.class),id);
    }

    @Override
    public int update(Room room) {
        int updated=0;
        updated=jdbcTemplate.update(updateSQL, new PreparedStatementSetter(){

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,room.getRoomType());
                ps.setInt(2,room.getPrice());
                ps.setInt(3,room.getId());
                
            }
        
        });
        return updated;
    }

    @Override
    public int deleteById(Integer id) {
        int deleted=0;
        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException{
                ps.setInt(1,id);
            }
        };
        deleted= jdbcTemplate.update(deleteSQL,pss);
        return deleted;
    }
    
}
