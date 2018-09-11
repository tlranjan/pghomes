package com.pghomes.pgowner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pghomes.dbconnection.DBConnection;

public class ManageRoom {
	public static ArrayList<ArrayList<String>> getRoomList(Integer ownerId, Integer pgId){
		ArrayList<ArrayList<String>> roomList = new ArrayList<ArrayList<String>>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String sql = "SELECT ROOMID, ROOMNAME, ROOMWHICHFLOOR, ROOMSHARINGTYPE, EMPTYBEDS, ROOMPGID FROM owner JOIN pg ON owner.OWNERID=pg.PGOWNERID JOIN room ON pg.PGID=room.ROOMPGID WHERE OWNERID="+ownerId+" AND PGID="+pgId;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ArrayList<String> roomRow = new ArrayList<String>();
				Integer rId = rs.getInt("ROOMID");
				roomRow.add(rId.toString());
				roomRow.add(rs.getString("ROOMNAME"));
				roomRow.add(rs.getString("ROOMWHICHFLOOR"));
				roomRow.add(rs.getString("ROOMSHARINGTYPE"));
				Integer emptyBeds = rs.getInt("EMPTYBEDS");
				roomRow.add(emptyBeds.toString());
				Integer rPGId = rs.getInt("ROOMPGID");
				roomRow.add(rPGId.toString());
				roomList.add(roomRow);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return roomList;
	}
	public static ArrayList<ArrayList<String>> getPGList(Integer ownerId){
		ArrayList<ArrayList<String>> pgList = new ArrayList<ArrayList<String>>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String sql = "SELECT PGID, PGNAME FROM pg WHERE PGOWNERID="+ownerId;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ArrayList<String> pgRow = new ArrayList<String>();
				Integer i = rs.getInt("PGID");
				pgRow.add(i.toString());
				pgRow.add(rs.getString("PGNAME"));
				pgList.add(pgRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return pgList;
	}
}
