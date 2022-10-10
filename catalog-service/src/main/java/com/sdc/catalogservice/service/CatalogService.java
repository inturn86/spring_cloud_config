package com.sdc.catalogservice.service;

import com.sdc.catalogservice.jpa.CatalogEntity;

public interface CatalogService {

	Iterable<CatalogEntity> getAllCatalogs();
}
