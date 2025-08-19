package com.shm.common.util;

public enum FilePath {
	PATH_ROOT("UPLOAD"), 
	PATH_PRODUCT_THUMBNAIL("PRODUCT_THUMBNAIL"), 
	PATH_PRODUCT_DETAIL("PRODUCT_DETAIL");

	private String pathName;

	FilePath(String name) {
		pathName = name;
	}

	public String getName() {
		return pathName;
	}
}
