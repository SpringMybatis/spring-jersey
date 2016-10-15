package com.cetc32.spring.jersey.message;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MessagePool<M> {
	
	/**
	 * 用来存储消息列队操作
	 */
	private LinkedList<M> queue = new LinkedList<M>();
	
	/**
	 * 放入消息
	 * 
	 * @param message 对象信息
	 * @throws InterruptedException 异常对象
	 */
	public void put(M message) throws InterruptedException {
		try {
			queue.add(message);
		} finally {
			// do nothing
		}
	}

	/**
	 * 取得队列的末尾消息
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public M takeLast() throws InterruptedException {
		M result = null;
		try {
			result = queue.removeLast();
		} catch (NoSuchElementException e) {
			// do nothing
		}finally {
			// do nothing
		}
		return result;
	}
}
