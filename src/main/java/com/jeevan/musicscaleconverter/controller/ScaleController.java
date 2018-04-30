package com.jeevan.musicscaleconverter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jeevan.musicscaleconverter.api.SongTransposeRequest;
import com.jeevan.musicscaleconverter.service.ScaleService;

@RestController
@RequestMapping("api/v1/")
public class ScaleController {

	@Autowired
	private ScaleService scaleService;
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}

	@RequestMapping(value = "scalechange", method = RequestMethod.POST)
	public String transposeSong(@RequestBody SongTransposeRequest songTransposeRequest) {
		return scaleService.transposeScale(songTransposeRequest.getFromScale(),
				songTransposeRequest.getToScale(), songTransposeRequest.getSong());
	}

}
