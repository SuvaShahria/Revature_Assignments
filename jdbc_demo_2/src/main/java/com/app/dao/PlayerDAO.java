package com.app.dao;

import java.util.List;

import com.app.model.Player;

public interface PlayerDAO {

	public int createPlayer(Player player) ;
	
	public List<Player> getAllPlayers();
	
	public int updatePlayer(int id,String city);
	
	public void deletePlayer(int id);
}