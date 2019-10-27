package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class MemberParser {
	public List<Member> getList(String path){
		List<Member> list=new ArrayList<>();
		JsonReader jr=null;
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		    jr=new JsonReader(isr);
			JsonObject root=new Gson().fromJson(jr,JsonObject.class);
			JsonArray beatles=root.get("Beatles").getAsJsonArray();
			for(int i=0;i<beatles.size();i++) {
				JsonObject memObj=beatles.get(i).getAsJsonObject();
				String name=memObj.get("name").getAsString();
				int age=memObj.get("age").getAsInt();
				list.add(new Member(name,age));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(jr !=null) {
				try {
					jr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
