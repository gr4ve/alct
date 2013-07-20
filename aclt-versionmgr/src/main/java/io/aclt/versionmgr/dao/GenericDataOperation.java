package io.aclt.versionmgr.dao;


public interface GenericDataOperation<T> {
	
	public void save(T object);

	public void update(T object);


}
