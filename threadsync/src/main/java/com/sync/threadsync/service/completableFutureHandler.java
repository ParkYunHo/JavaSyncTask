package com.sync.threadsync.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class completableFutureHandler {
	private final Logger logger = Logger.getLogger("completableFutureHandler");
	
	@Async
	public CompletableFuture<String> findMethod(String method) throws Exception{
		List<String> method_list = setMethodList();

		String result = "";
		if(method_list.indexOf(method) > -1) {
			result = method;
		}else {
			result = "error";
		}
		
		logger.info(method);
		return CompletableFuture.completedFuture(result);
	}
	
	public List<String> setMethodList() throws Exception{
		List<String> method_list = new ArrayList<String>();
		method_list.add("method1");
		method_list.add("method2");
		method_list.add("method3");
		
		return method_list;
	}
}
