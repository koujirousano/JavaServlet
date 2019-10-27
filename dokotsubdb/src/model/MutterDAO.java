package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MutterDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/dokotsubu");
			this.db=ds.getConnection();
	}
	private void disconnect() throws SQLException {
		if(rs !=null) {
			rs.close();
		}
		if(ps !=null) {
			ps.close();
		}
		if(db != null) {
			db.close();
		}
	}
	public List<Mutter> findAll(){
		List<Mutter> list=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM mutters ORDER BY id DESC");
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String userName=rs.getString("userName");
				String text=rs.getString("body");
				list.add(new Mutter(id,userName,text));
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			try {
				this.disconnect();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return list;
	}
	public void insertOne(Mutter mutter) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO mutters(userName,body) values(?,?)");
			ps.setString(1, mutter.getUserName());
			ps.setString(2, mutter.getText());
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			try {
				this.disconnect();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}
