package com.qa.helper;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestUtil {

	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICITLY_WAIT = 30;

	public static HashMap<String, String> readTestDataFromJson(String testcaseID) throws Exception {

		JsonParser jsonParser = new JsonParser();
		FileReader reader = new FileReader("./src/main/java/testdata/TestData.json");
		Object obj = jsonParser.parse(reader);
		JsonObject obj1 = (JsonObject) obj;
		HashMap<String, String> testdata = new HashMap<String, String>();

		JsonObject data = (JsonObject) obj1.get(testcaseID);
		for (Entry<String, JsonElement> entry : data.entrySet()) {
			testdata.put(entry.getKey().toString(), entry.getValue().getAsString());
		}
		return testdata;
	}
}
