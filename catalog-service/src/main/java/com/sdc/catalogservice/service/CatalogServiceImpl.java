package com.sdc.catalogservice.service;

import org.springframework.stereotype.Service;

import com.sdc.catalogservice.jpa.CatalogEntity;
import com.sdc.catalogservice.jpa.CatalogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService{


	private final CatalogRepository catalogRepository;

	@Override
	public Iterable<CatalogEntity> getAllCatalogs() {
		return catalogRepository.findAll();
	}

}
