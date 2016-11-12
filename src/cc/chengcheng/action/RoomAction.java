package cc.chengcheng.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cc.chengcheng.json.Result;
import cc.chengcheng.model.Room;
import cc.chengcheng.service.RoomService;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;


public class RoomAction extends ActionSupport {
	private List<Room> rooms;
	private RoomService roomService = new RoomService();
	private String t;
	private int roomId;
	


	public String emputyRoomList() {
		rooms = roomService.getRooms(t);
		return SUCCESS;
	}
	
	public void orderList() throws IOException {
		rooms = roomService.getRooms(t);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Result result = new Result();
		if (!rooms.isEmpty()) {
			result.setResult(1);
			result.setRooms(rooms);
		} else {
			result.setResult(0);
			result.setRooms(null);
		}
		
		JSONObject json=new JSONObject();
		json.accumulate("result", result);
		out.println(json.toString());
		out.flush();
		out.close();
	}
	
	public String orderRoom() {
		if (roomService.orderRoom(roomId, t)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
			
		
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
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

}
