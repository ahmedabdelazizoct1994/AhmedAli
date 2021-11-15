package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

 
 // This class to read form Json file "UserData.json"

public class JsonDataReader {
	public String UserName, Password , firstName , lastName, postalCode  ; 

	public void JsonReaderMethod() throws IOException, Exception
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";

		File srcFile = new File(filePath); 

		JSONParser parser = new JSONParser(); 
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile)); 

		for(Object jsonObj : jarray) 
		{
			JSONObject SauceDemoUser = (JSONObject) jsonObj ; 
			UserName  = (String) SauceDemoUser.get("UserName"); 
			System.out.println(UserName);

			Password = (String) SauceDemoUser.get("Password"); 
			System.out.println(Password);

			firstName = (String) SauceDemoUser.get("firstname"); 
			System.out.println(firstName);

			lastName = (String) SauceDemoUser.get("lastname"); 
			System.out.println(lastName);

			postalCode = (String) SauceDemoUser.get("postalCode"); 
			System.out.println(postalCode);

		}

	}

}
