package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class AddressParser {
	public List<Address> getList(String urlString){
		List<Address> list=new ArrayList<>();
		HttpURLConnection con=null;
		JsonReader jr=null;
		try {
			URL url=new URL(urlString);
			con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			InputStream is=con.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			jr=new JsonReader(isr);
			JsonObject root=new Gson().fromJson(jr,JsonObject.class);
			JsonArray results=root.get("results").getAsJsonArray();
			for(int i=0;i<results.size();i++) {
				JsonObject address=results.get(i).getAsJsonObject();

				String address1=address.get("address1").getAsString();

				String address2=address.get("address2").getAsString();
				String address3=address.get("address3").getAsString();
				list.add(new Address(address1,address2,address3));
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if(jr !=null) {
				try {
					jr.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(con !=null) {
				con.disconnect();
			}
		}
		return list;
	}

}
