package com.sync.threadsync;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sync.threadsync.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadsyncApplicationTests {
	private final Logger logger = Logger.getLogger("ThreadsyncApplicationTests"); 
	
	@Autowired
	private AsyncHandler asyncHandler;
	@Autowired
	private completableFutureHandler completableFutureHandler;
	
	@Test
	public void asyncTest() throws Exception {
		asyncHandler.method1();
		asyncHandler.method2();
		asyncHandler.method3();
		logger.info("start");
	}
	
	@Test
	public void completableFutureTest() throws Exception{
		CompletableFuture<String> method1 = completableFutureHandler.findMethod("method1");
		CompletableFuture<String> method2 = completableFutureHandler.findMethod("method2");
		CompletableFuture<String> method3 = completableFutureHandler.findMethod("method3");
		CompletableFuture<String> error = completableFutureHandler.findMethod("method4");
		
		// 모든 Thread가 종료되면 끝난다. (allOf)
//		CompletableFuture.allOf(method1, method2, method3, error).join();
		// Thread중 하나라도 Task가 완료되면 해당 Task를 리턴하고 끝낸다. (anyOf)
		CompletableFuture first_task = (CompletableFuture) CompletableFuture.anyOf(method1, method2, method3, error);
		
		logger.info("first Task: " + first_task.get());
	}

}
