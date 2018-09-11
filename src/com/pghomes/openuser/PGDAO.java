package com.pghomes.openuser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pghomes.dbconnection.DBConnection;

public class PGDAO {
	public static List<ArrayList<String>> getPGList(List<String> cityNames, List<String> locations, List<String> sharingTypes, List<String> rentMaxMinString, List<String> genders, int searchPage) {
		String condition = constructCondition(cityNames, locations, sharingTypes, rentMaxMinString, genders);
		List<ArrayList<String>> pgList = new ArrayList<ArrayList<String>>();
		String sql = "SELECT DISTINCT PGID, PGNAME, PGLOCATION, PGPHONE, PGOTHERCONTACTS, PGADDRESS, PGDETAILS, PGCITYNAME, PGTYPE FROM pg "+condition;
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int endPoint = 9 * searchPage;
			int startPoint = endPoint - 8;
			int counter = 1;
			while(rs.next()){
				if(counter >= startPoint && counter <= endPoint){
					ArrayList<String> list = new ArrayList<String>();
					list.add(rs.getString("PGNAME"));
					list.add(rs.getString("PGLOCATION"));
					list.add(rs.getString("PGPHONE"));
					list.add(rs.getString("PGOTHERCONTACTS"));
					list.add(rs.getString("PGADDRESS"));
					list.add(rs.getString("PGDETAILS"));
					list.add(rs.getString("PGCITYNAME"));
					list.add(rs.getString("PGID"));
					pgList.add(list);
				}
				counter++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return pgList;
	}
	public static int getPGListCount(List<String> cityNames, List<String> locations, List<String> sharingTypes, List<String> rentMaxMinString, List<String> genders) {
		String condition = constructCondition(cityNames, locations, sharingTypes, rentMaxMinString, genders);
		int count = 0;
		String sql = "SELECT DISTINCT PGID, PGNAME, PGLOCATION, PGPHONE, PGOTHERCONTACTS, PGADDRESS, PGDETAILS, PGCITYNAME, PGTYPE FROM pg "+condition;
		Connection con = null;
		Statement stmt = null;
		try {
			con =DBConnection.getDBConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return count;
	}
	public static String constructCondition(List<String> cityNames, List<String> locations, List<String> sharingTypes, List<String> rentMaxMinString, List<String> genders){
		String preFix = "JOIN room ON pg.PGID=room.ROOMPGID ";
		String condition = "WHERE ";
		if(cityNames != null && !cityNames.isEmpty()){
			condition = condition + " AND (";
			Iterator<String> it = cityNames.iterator();
			while(it.hasNext()){
				condition = condition + "PGCITYNAME='"+it.next()+"' OR ";
			}
			condition = condition.substring(0, condition.length()-4);
			condition = condition + ")";
		}
		if(rentMaxMinString != null && !rentMaxMinString.isEmpty()){
			condition = condition + " AND (";
			Iterator<String> it = rentMaxMinString.iterator();
			while(it.hasNext()){
				String[] rentArr = it.next().split("-");
				condition = condition + "(RENTPERBED BETWEEN "+Integer.parseInt(rentArr[0].toString())+" AND "+Integer.parseInt(rentArr[1].toString())+") OR ";
			}
			condition = condition.substring(0, condition.length()-4);
			condition = condition + ")";
		}
		if(locations != null && !locations.isEmpty()){
			condition = condition + " AND (";
			Iterator<String> it = locations.iterator();
			while(it.hasNext()){
				condition = condition + "PGLOCATION='"+it.next()+"' OR ";
			}
			condition = condition.substring(0, condition.length()-4);
			condition = condition + ")";
		}
		if(genders != null && !genders.isEmpty()){
			condition = condition + " AND (";
			Iterator<String> it = genders.iterator();
			while(it.hasNext()){
				condition = condition + "PGTYPE='"+it.next()+"' OR ";
			}
			condition = condition.substring(0, condition.length()-4);
			condition = condition + ")";
		}
		if(sharingTypes != null && !sharingTypes.isEmpty()){
			condition = condition + " AND (";
			Iterator<String> it = sharingTypes.iterator();
			while(it.hasNext()){
				condition = condition + "ROOMSHARINGTYPE='"+it.next()+"' OR ";
			}
			condition = condition.substring(0, condition.length()-4);
			condition = condition + ")";
		}
		if(condition.equals("WHERE ")){
			condition = condition + "(EMPTYBEDS > 0)";
			return preFix+condition;
		}
		condition = condition + " AND (EMPTYBEDS > 0)";
		condition = condition.substring(11, condition.length());
		condition = "WHERE "+condition;
		//System.out.println(preFix+condition);
		return preFix+condition;
	}
	public static ArrayList<String> getAllLocalityList() {
		ArrayList<String> localityList = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT LOCALITYNAME FROM localitylist");
			while(rs.next()){
				localityList.add(rs.getString("LOCALITYNAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return localityList;
	}
	public static ArrayList<String> getLocalityList(ArrayList<String> cityNames) {
		if(cityNames.isEmpty()) {
			return getAllLocalityList();
		}
		ArrayList<String> localityList = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String sql = "";
			for(int i = 0; i < cityNames.size(); i++){
				if(i != cityNames.size() - 1){
					sql = sql+"CITYNAME="+"'"+cityNames.get(i)+"' OR ";
				} else {
					sql = sql+"CITYNAME="+"'"+cityNames.get(i)+"'";
				}
			}
			ResultSet rs = stmt.executeQuery("SELECT LOCALITYNAME FROM localitylist WHERE "+sql);
			while(rs.next()){
				localityList.add(rs.getString("LOCALITYNAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return localityList;
	}
	public static ArrayList<String> getCityList() {
		ArrayList<String> cityList = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT CITYNAME FROM citylist");
			while(rs.next()){
				cityList.add(rs.getString("CITYNAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return cityList;
	}
	public static ArrayList<String> getAllSharingList() {
		ArrayList<String> sharingList = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SHARINGTYPES FROM sharingtypelist");
			while(rs.next()){
				sharingList.add(rs.getString("SHARINGTYPES"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return sharingList;
	}
	public static ArrayList<String> getRentRangeList() {
		ArrayList<String> rentList = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT RENTRANGE FROM rentrangelist");
			while(rs.next()){
				rentList.add(rs.getString("RENTRANGE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return rentList;
	}
	public static ArrayList<String> getPGImageId(int pgId) {
		ArrayList<String> pgIdList = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT IMAGELINKID FROM pgimage WHERE PGID="+pgId);
			while(rs.next()){
				String[] idList = rs.getString("IMAGELINKID").split(",");
				for(String s : idList) {
					pgIdList.add(s);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return pgIdList;
	}
	public static ArrayList<String> getPGLatLong(int pgId) {
		ArrayList<String> pgLatLong = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PGLAT, PGLONG FROM pgimage WHERE PGID="+pgId);
			while(rs.next()){
				pgLatLong.add(rs.getString("PGLAT"));
				pgLatLong.add(rs.getString("PGLONG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return pgLatLong;
	}
	public static ArrayList<String> getPGDiscriptionAd(int pgId) {
		ArrayList<String> pgDisc = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PGDESCRIPTION FROM pgimage WHERE PGID="+pgId);
			while(rs.next()){
				String[] discArray = rs.getString("PGDESCRIPTION").split("::");
				for(String s : discArray){
					pgDisc.add(s);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return pgDisc;
	}
}