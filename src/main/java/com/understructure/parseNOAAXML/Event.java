package com.understructure.parseNOAAXML;

import java.util.HashMap;
import java.util.Map;

public class Event {
	private String id;
	private String title;
	private String summary;
	private String effectiveDate;
	private String expirationDate;
	private String category;
	private String urgency;
	private String certainty;
	private String area;
	private Boolean active;
	private String updatedDate;
	
	private Map<String, String> createFieldListMap() {
		Map<String, String> eventMap = new HashMap<String, String>();
		eventMap.put("id", "id");
		eventMap.put("title", "title");
		eventMap.put("summary", "summary");
		eventMap.put("cap:effective", "effectiveDate");
		eventMap.put("cap:expires", "expirationDate");
		eventMap.put("cap:category", "category");
		eventMap.put("cap:urgency", "urgency");
		eventMap.put("cap:certainty", "certainty");
		eventMap.put("cap:areaDesc", "area");
		eventMap.put("updated", "updatedDate");
		return eventMap;
	}
	
	// make private eventually (and a class method, 'static')
	public String checkMap(String xmlName) {
		Map<String, String> map = createFieldListMap();
		String checkField = map.get(xmlName);
		return checkField;
//		if(checkField != null && !checkField.isEmpty()) {
//			// set property value
//			return checkField;
//		}
//		else {
//			return xmlName;
//		}
	}
	public void setValue(String propName, String value) {
		switch(propName) {
		case("id"): {
			setId(value);
		}
		case("title"): {
			setTitle(value);
		}
		case("summary"): {
			setSummary(value);
		}
		case("effectiveDate"): {
			setEffectiveDate(value);
		}
		case("expirationDate"): {
			setExpirationDate(value);
		}
		case("category"): {
			setCategory(value);
		}
		case("urgency"): {
			setUrgency(value);
		}
		case("area"): {
			setArea(value);
		}
		case("updatedDate"): {
			setUpdatedDate(value);
		}
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	public String getCertainty() {
		return certainty;
	}
	public void setCertainty(String certainty) {
		this.certainty = certainty;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
//	protected String fieldMap(String key) {
//		
//	}
}
