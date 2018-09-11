package com.pghomes.pgowner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pghomes.dbconnection.DBConnection;

public class ManagePG {
	public static ArrayList<ArrayList<String>> getPGList(Integer ownerId){
		ArrayList<ArrayList<String>> pgList = new ArrayList<ArrayList<String>>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String sql = "SELECT *FROM pg WHERE PGOWNERID="+ownerId;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ArrayList<String> pgRow = new ArrayList<String>();
				Integer i = rs.getInt("PGID");
				pgRow.add(i.toString());
				pgRow.add(rs.getString("PGNAME"));
				pgRow.add(rs.getString("PGLOCATION"));
				pgRow.add(rs.getString("PGPHONE"));
				pgRow.add(rs.getString("PGOTHERCONTACTS"));
				pgRow.add(rs.getString("PGADDRESS"));
				pgRow.add(rs.getString("PGDETAILS"));
				pgRow.add(rs.getString("PGCITYNAME"));
				pgList.add(pgRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return pgList;
	}
	public static ArrayList<ArrayList<String>> getPGDetails(Integer ownerId) {
		ArrayList<ArrayList<String>> pgDetails = new ArrayList<ArrayList<String>>();
		Connection con = null;
		Statement stmt = null;
		try {
			
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String pgSql = "SELECT DISTINCT PGNAME FROM pg WHERE PGOWNERID="+ownerId;
			ResultSet pgRs = stmt.executeQuery(pgSql);
			ArrayList<String> allPg = new ArrayList<String>();
			while(pgRs.next()) {
				allPg.add(pgRs.getString("PGNAME"));
			}
			for(int i=0; i < allPg.size(); i++) {
				ArrayList<String> singlePGDetails = new ArrayList<String>();
				String pgName = allPg.get(i);
				Integer totalRooms = 0;
				Integer totalBeds = 0;
				Integer emptyBeds = 0;
				Integer totalGuests = 0;
				
				String sql = "SELECT *FROM owner JOIN pg ON owner.OWNERID=pg.PGOWNERID JOIN room ON pg.PGID=room.ROOMPGID WHERE PGOWNERID="+ownerId+" AND PGNAME='"+pgName+"'";
				ResultSet allRooms = stmt.executeQuery(sql);
				while(allRooms.next()) {
					totalRooms++;
					if(allRooms.getString("ROOMSHARINGTYPE").equalsIgnoreCase("SingleBedroom")){
						totalBeds++;
					}
					if(allRooms.getString("ROOMSHARINGTYPE").equalsIgnoreCase("TwoSharing")){
						totalBeds = totalBeds + 2;
					}
					if(allRooms.getString("ROOMSHARINGTYPE").equalsIgnoreCase("ThreeSharing")){
						totalBeds = totalBeds + 3;
					}
					if(allRooms.getString("ROOMSHARINGTYPE").equalsIgnoreCase("FourSharing")){
						totalBeds = totalBeds + 4;
					}
					if(allRooms.getString("ROOMSHARINGTYPE").equalsIgnoreCase("DoubleDecker")){
						totalBeds = totalBeds + 6;
					}
					if(allRooms.getString("ROOMSHARINGTYPE").equalsIgnoreCase("Doormetory")){
						totalBeds = totalBeds + 8;
					}
					int num = allRooms.getInt("EMPTYBEDS");
					emptyBeds = emptyBeds + num;
				}
				singlePGDetails.add(pgName);
				singlePGDetails.add(totalRooms.toString());
				singlePGDetails.add(totalBeds.toString());
				singlePGDetails.add(emptyBeds.toString());
				singlePGDetails.add(totalGuests.toString());
				pgDetails.add(singlePGDetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return pgDetails;
	}
}
