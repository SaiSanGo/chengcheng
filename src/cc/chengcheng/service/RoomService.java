package cc.chengcheng.service;

import java.util.List;
import cc.chengcheng.model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cc.chengcheng.util.DB;

public class RoomService {
	public List<Room> getRooms(String t) {
		Connection conn = DB.createConn();
		String sql = "select roomId from rooms where ? = 1";
		List<Room> rooms = new ArrayList<Room>();
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Room r = new Room();
				r.setRoomId(rs.getInt("roomId"));
				rooms.add(r);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		
		return rooms;
	}
}