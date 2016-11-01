package cc.chengcheng.action;

import java.util.List;
import cc.chengcheng.model.Room;
import cc.chengcheng.service.RoomService;
import com.opensymphony.xwork2.ActionSupport;

public class RoomAction extends ActionSupport {
	private List<Room> rooms;
	private RoomService roomService = new RoomService();
	private String t;
	
	public String emputyRoomList() {
		System.out.println("t = " + t);
		rooms = roomService.getRooms(t);
		return SUCCESS;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	/*public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}*/

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

}
