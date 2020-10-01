package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.PlayerDAO;
import com.app.dbutil.MySqlConnection;
import com.app.model.Player;

public class PlayerDAOImpl implements PlayerDAO {

	@Override
	public int createPlayer(Player player) {
		int c=0;
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="insert into player(id,name,age,city,gender,teamName) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, player.getId());
			preparedStatement.setString(2, player.getName());
			preparedStatement.setInt(3, player.getAge());
			preparedStatement.setString(4, player.getCity());
			preparedStatement.setString(5, player.getGender());
			preparedStatement.setString(6, player.getTeamName());
			
			c=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		
		return c;
	}

	@Override
	public List<Player> getAllPlayers() {
		List<Player> playersList=new ArrayList<>();
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="select id,name,age,city,gender,teamName from player";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Player player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setAge(resultSet.getInt("age"));
				player.setName(resultSet.getString("name"));
				player.setGender(resultSet.getString("gender"));
				player.setTeamName(resultSet.getString("teamName"));
				player.setCity(resultSet.getString("city"));
				playersList.add(player);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return playersList;
	}

	@Override
	public int updatePlayer(int id, String city) {
		
		String sql="update player set city=? where id=?";
		return 0;
	}

	@Override
	public void deletePlayer(int id) {
		String sql="delete from player where id=?";
		
	}
}