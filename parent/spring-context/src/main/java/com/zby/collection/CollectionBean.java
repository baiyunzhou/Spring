package com.zby.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {

	private String[] strings;
	private List<String> list;
	private Set<String> set;
	private Map<String, String> map;
	private Properties properties;

	public String[] getStrings() {
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "CollectionBean [strings=" + Arrays.toString(strings) + ", list=" + list + list.getClass() + ", set="
				+ set + set.getClass() + ", map=" + map + map.getClass() + ", properties=" + properties
				+ properties.getClass() + "]";
	}
}
