package google.model;

import java.util.Map;

import com.google.gson.JsonElement;

public class GoogleScholarCiteModel {
	private Map<String, JsonElement> cite;

	public Map<String, JsonElement> getCite() {
		return cite;
	}

	public void setCite(Map<String, JsonElement> cite) {
		this.cite = cite;
	}

	@Override
	public String toString() {
		return "GoogleScholarCiteModel [cite=" + cite + ", getCite()=" + getCite() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
