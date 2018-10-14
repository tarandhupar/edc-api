package com.gov.travelservice.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gov.travelservice.entity.TravelRecord;
import com.gov.travelservice.entity.User;
import com.gov.travelservice.pojo.TravelRecordBO;
import com.gov.travelservice.repository.TravelRecordRepository;
import com.gov.travelservice.repository.UserRepository;

@Service
@Transactional(readOnly=true)
public class TravelService {

	@Autowired
	TravelRecordRepository travelRecordRepository;

	@Autowired
	UserService userService;
	
	public Map<String,Map<String, Object>> getTravelServiceList(long userId,int page,int limit) {
		User userreq = new User();
		userreq.setId(userId);
		Map<String,Map<String, Object>> resMap = new HashMap<>();
		Page<TravelRecord> allUserTravelRequests = travelRecordRepository.findByRequester(userreq, PageRequest.of(page, limit));
		addToMap(allUserTravelRequests,resMap,"userAllTravelRequests");
		
		Page<TravelRecord> userPendingTravelRequests = travelRecordRepository.findByRequesterAndStatus(userreq, "Pending", PageRequest.of(page, limit));
		addToMap(userPendingTravelRequests,resMap,"userPendingTravelRequests");
		
		Page<TravelRecord> userUpcomingTravelRequests = travelRecordRepository.findByRequesterAndStatus(userreq, "Approved", PageRequest.of(page, limit));
		addToMap(userUpcomingTravelRequests,resMap,"userUpcomingTravelRequests");
		
		Page<TravelRecord> approverPendingTravelRequests = travelRecordRepository.findByApproverAndStatus(userreq, "Pending", PageRequest.of(page, limit));
		addToMap(approverPendingTravelRequests,resMap,"approverPendingTravelRequests");
		
		Page<TravelRecord> approverApprovedTravelRequests = travelRecordRepository.findByApproverAndStatus(userreq, "Pending", PageRequest.of(page, limit));
		addToMap(approverApprovedTravelRequests,resMap,"approverApprovedTravelRequests");
		
		return resMap;
	}

	private Map<String, Map<String, Object>> addToMap(Page<TravelRecord> travelServicePage,Map<String,Map<String, Object>> resMap,String responseKey) {
		List<TravelRecordBO> results = new ArrayList<>();
		travelServicePage.forEach(tr -> {results.add(getBOFromTravelRecord(tr));});
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("totalPages", travelServicePage.getTotalPages());
		m.put("totalElements", travelServicePage.getTotalElements());
		m.put("size", travelServicePage.getSize());
		m.put("results", results);
		resMap.put(responseKey,m);
		return resMap;
	}
	
	public Optional<TravelRecord> getTravelServiceById(long travelRecordId) {
		return travelRecordRepository.findById(travelRecordId);
	}

	
	public TravelRecordBO create(TravelRecordBO travelRecordBO) {
		TravelRecord tr = getEntityFromTravelRecordBO(travelRecordBO);
		tr.setId(0);
		tr.setRequester(userService.findByUserId(travelRecordBO.getRequester().getId()));
		tr.setApprover(userService.findByUserId(travelRecordBO.getApprover().getId()));
		return getBOFromTravelRecord(travelRecordRepository.saveAndFlush(tr));
	}
	
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


	
	private static TravelRecord getEntityFromTravelRecordBO(TravelRecordBO bo) throws IllegalArgumentException {
		BeanMappingBuilder builder = new BeanMappingBuilder() {
		      protected void configure() {
		    	  mapping(TravelRecordBO.class, TravelRecord.class,
		    			  TypeMappingOptions.mapNull(false),
		    			  TypeMappingOptions.mapEmptyString(false));
		      }
		};
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.addMapping(builder);
		TravelRecord destObject =  
		    mapper.map(bo, TravelRecord.class);
		return destObject;
	}



}
