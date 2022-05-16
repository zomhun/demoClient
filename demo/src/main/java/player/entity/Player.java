package player.entity;

import java.util.Date;


public class Player {
	private int playerId;
	private String playerName;
	private boolean gender;
	private Date birthday;
	private String address;
	private String clubName;
	private String positionPlay;
	private float transportCost;
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getPositionPlay() {
		return positionPlay;
	}
	public void setPositionPlay(String positionPlay) {
		this.positionPlay = positionPlay;
	}
	public float getTransportCost() {
		return transportCost;
	}
	public void setTransportCost(float transportCost) {
		this.transportCost = transportCost;
	}
	public Player(int playerId, String playerName, boolean gender, Date birthday, String address, String clubName,
			String positionPlay, float transportCost) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.clubName = clubName;
		this.positionPlay = positionPlay;
		this.transportCost = transportCost;
	}
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
