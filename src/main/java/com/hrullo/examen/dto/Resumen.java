package com.hrullo.examen.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Resumen {

	@JsonProperty("REGIONES")
	private List<RegionDto> regiones;
	@JsonProperty("ITEMS TYPES")
	private List<ItemTypeDto> itemsTyle;
	@JsonProperty("ORDERS PRIORITY")
	private List<OrderPriorityDto> orders;
	@JsonProperty("SALES CHANNELS")
	private List<SalesChannelsDto> salesChannels;
	@JsonProperty("COUNTRY")
	private List<CountryDto> country;
}
