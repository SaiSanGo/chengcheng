package cc.chengcheng.json;

import java.util.List;

import cc.chengcheng.model.Room;

public class Result {
	private int result;
	private List<Room> rooms;
	public int getResult() {
		return result;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	
}
