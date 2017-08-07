package com.huajin.monitor;

/**
 * MBean proxy 使用的接口。
 * 
 * @author bo.yang
 * @date 2017年7月18日 下午3:48:10
 */
public interface TomcatThreadPool {

	public int getmaxThreads();
	
	public int getcurrentThreadCount();
	
	public int getcurrentThreadsBusy();
	
	public int getminSpareThreads();
	
	public int getmaxConnections();
	
	public int getacceptorThreadCount();
	
	public int getbacklog();
	
	public long getconnectionCount();
	
	public int getkeepAliveCount();
	
	public boolean isrunning();
	
	public int getsoTimeout();
	
}
