package kiti.buy.pmk.service;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;


public class IPCacheService {
	
	private final ConcurrentLinkedDeque<String> memoryCache = new ConcurrentLinkedDeque<String>();
	private Timer timer;
	
	@PostConstruct
	public void init() {
		timer = new Timer();
		memoryCache.push("127.0.0.1");
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				System.out.println(memoryCache);
				memoryCache.clear();
				
			}
		}, 1000 * 60, 10000);
	}
	
	@PreDestroy
	public void destroy() {
		this.timer.purge();
	}
	
	public boolean isCacheing(String ip) {
		return memoryCache.contains(ip);
	}
	
	public void putIp(String ip) {
		memoryCache.push(ip);
	}
	
	
	
}
