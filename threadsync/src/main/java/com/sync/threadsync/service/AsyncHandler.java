package com.sync.threadsync.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class AsyncHandler {
	private final Logger logger = Logger.getLogger("SyncHandler");
	
	@Async("threadPoolTaskExecutor")
	public void method1() throws Exception{
		try {
			logger.info("method1");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Async("threadPoolTaskExecutor")
	public void method2() throws Exception{
		try {
			logger.info("method2");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Async("threadPoolTaskExecutor")
	public void method3() throws Exception{
		try {
			logger.info("method3");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
