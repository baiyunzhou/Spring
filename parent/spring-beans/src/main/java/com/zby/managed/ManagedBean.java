package com.zby.managed;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ManagedBean {
	private String str;
	private String[] strArray;
	private List<String> strList;
	private Set<String> strSet;
	private Map<String, String> strMap;
	private Properties properties;

	public ManagedBean(String[] strArray, String str) {
		super();
		this.strArray = strArray;
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String[] getStrArray() {
		return strArray;
	}

	public void setStrArray(String[] strArray) {
		this.strArray = strArray;
	}

	public List<String> getStrList() {
		return strList;
	}

	public void setStrList(List<String> strList) {
		this.strList = strList;
	}

	public Set<String> getStrSet() {
		return strSet;
	}

	public void setStrSet(Set<String> strSet) {
		this.strSet = strSet;
	}

	public Map<String, String> getStrMap() {
		return strMap;
	}

	public void setStrMap(Map<String, String> strMap) {
		this.strMap = strMap;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "ManagedBean [str=" + str + ", strArray=" + Arrays.toString(strArray) + ", strList=" + strList + ", strSet=" + strSet
				+ ", strMap=" + strMap + ", properties=" + properties + "]";
	}

}
