package com.CourseManagement.Config;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingConfig {

	private final ModelMapper modelMapper;

	@Autowired
	public MappingConfig(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public <S, D> List<D> mapList(List<S> sourceList, Class<D> destinationClass) {
		return sourceList.stream().map(source -> modelMapper.map(source, destinationClass))
				.collect(Collectors.toList());
	}
	
	 public <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass) {
	        return StreamSupport.stream(sourceList.spliterator(), false)
	                .map(source -> modelMapper.map(source, destinationClass))
	                .collect(Collectors.toList());
	 }
}