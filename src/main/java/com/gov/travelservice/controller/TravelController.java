package com.gov.travelservice.controller;

import java.lang.reflect.InvocationTargetException;

import java.util.Map;


import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gov.travelservice.entity.TravelRecord;
import com.gov.travelservice.pojo.TravelRecordBO;
import com.gov.travelservice.service.TravelService;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;


@RestController
@RequestMapping(value =  "travelservice/v1/", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class TravelController {
	
	@Autowired
	TravelService travelService;
	
	@RequestMapping(value = "travel/{userid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Map<String, Object>> getTravelRecords(@PathVariable("userid") long userid)  {
		Map<String, Map<String, Object>> response =  travelService.getTravelServiceList(userid,0,10);
//		System.out.println("Total Records :"+travelServiceList.size());
		return response;
	}

	@RequestMapping(value = "travel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TravelRecordBO createTravelRecord(@RequestBody(required = true) TravelRecordBO travelRecord)  {
		System.out.println("Saving record"+travelRecord.getId());
		return null;
		//return travelService.create(travelRecord);
	}

	
	
/*
	@RequestMapping(value = "travel/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TravelRecordBO> searchTravelRecords(@RequestBody(required = false) TravelRecordSearchCriteria filterObj) {
		ResponseEntity<Object> response = null;
		Map<String, Object> searchResults = travelService.searchTravelRecords(filterObj);
		response = ResponseBuilder.build(HttpStatus.OK, searchResults);
		return response;
	}
*/

	private static TravelRecordBO getBOFromTravelRecord(TravelRecord entity) throws IllegalArgumentException {
		BeanMappingBuilder builder = new BeanMappingBuilder() {
		      protected void configure() {
		    	  mapping(TravelRecord.class, TravelRecordBO.class,
		    			  TypeMappingOptions.mapNull(false),
		    			  TypeMappingOptions.mapEmptyString(false));
		      }
		};
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.addMapping(builder);
		TravelRecordBO destObject =  
		    mapper.map(entity, TravelRecordBO.class);
		return destObject;
	}
	
	private static TravelRecord getTravelRecordFromBO(TravelRecordBO bo) throws IllegalArgumentException {
		TravelRecord entity = new TravelRecord();
		try {
			copyProperties(entity, bo);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IllegalArgumentException("TravelRecordBO cannot be copied to entity due to " + e.getMessage());
		}
		return entity;
	}


}
