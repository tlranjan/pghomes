package com.pghomes.pgowner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pghomes.dbconnection.DBConnection;

public class ManageGuest {
	public static ArrayList<ArrayList<String>> getGuestInfo(int ownerId, int pgId, boolean onlyDueGuest) {
		ArrayList<ArrayList<String>> guestInfos = new ArrayList<ArrayList<String>>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String sql = "SELECT *FROM guest WHERE PG_ID="+pgId+" AND OWNER_ID="+ownerId;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ArrayList<String> guestInfo = new ArrayList<String>();
				Integer guestId = rs.getInt("GUESTID");
				guestInfo.add(guestId.toString());
				String name = rs.getString("NAME");
				guestInfo.add(name);
				String age = rs.getString("AGE");
				guestInfo.add(age);
				String gender = rs.getString("GENDER");
				guestInfo.add(gender);
				Date doj = rs.getDate("DATEOFJOINING");
				guestInfo.add(doj.toString());
				Date paid_upto = rs.getDate("PAID_UPTO");
				guestInfo.add(paid_upto.toString());
				Date due_date = rs.getDate("DUE_DATE");
				guestInfo.add(due_date.toString());
				Integer pg_id = rs.getInt("PG_ID");
				guestInfo.add(pg_id.toString());
				Integer room_id = rs.getInt("ROOM_ID");
				guestInfo.add(room_id.toString());
				String phone = rs.getString("PHONE");
				guestInfo.add(phone);
				String otherContacts = rs.getString("OTHERCONTACTS");
				guestInfo.add(otherContacts);
				String idCards = rs.getString("IDCARDS");
				guestInfo.add(idCards);
				Integer sucurityMoney = rs.getInt("SECURITYMONEY");
				guestInfo.add(sucurityMoney.toString());
				String paramAddress = rs.getString("PARAMADDRESS");
				guestInfo.add(paramAddress);
				String parentName = rs.getString("PARENTNAME");
				guestInfo.add(parentName);
				String parentMobile = rs.getString("PARENTMOBILE");
				guestInfo.add(parentMobile);
				String otherDetails = rs.getString("OTHERDETAILS");
				guestInfo.add(otherDetails);
				Integer rent = rs.getInt("RENT");
				guestInfo.add(rent.toString());
				Integer prev_prev_month = rs.getInt("PREVPREVMONTH");
				guestInfo.add(prev_prev_month.toString());
				Integer prev_month = rs.getInt("PREVIOUSMONTH");
				guestInfo.add(prev_month.toString());
				Integer curr_month = rs.getInt("CURRENTMONTH");
				guestInfo.add(curr_month.toString());
				if(onlyDueGuest == true) {
					guestInfos.add(guestInfo);
				} else {
					guestInfos.add(guestInfo);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		return guestInfos;
	}
}
