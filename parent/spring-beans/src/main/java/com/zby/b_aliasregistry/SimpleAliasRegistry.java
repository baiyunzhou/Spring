package com.zby.b_aliasregistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.AliasRegistry;

public class SimpleAliasRegistry implements AliasRegistry {
	/**
	 * key为name，也就是别名，value为id
	 */
	private Map<String, String> aliasMap = new ConcurrentHashMap<>(16);

	@Override
	public void registerAlias(String name, String alias) {
		synchronized (aliasMap) {
			if (alias.equals(name)) {
				// 别名与本名相同，也就是
			} else {

			}
		}
	}

	@Override
	public void removeAlias(String alias) {

	}

	@Override
	public boolean isAlias(String name) {
		return false;
	}

	@Override
	public String[] getAliases(String name) {
		return null;
	}

}
