package com.rimt.modules.service;

import java.util.List;

public interface GenericObjectService<T> {
	List<T> findAllObjects();
}
