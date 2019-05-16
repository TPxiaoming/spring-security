package com.xiaoming.web.async;
/**
 * 模拟消息队列
 * @author 江小明
 *
 */
public class MockQueue {

	private String placeOrder;//下单消息
	
	private String completeOrder;//完成订单消息

	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) throws InterruptedException {
		System.out.println("接到下单请求,"+placeOrder);
		Thread.sleep(1000);
		this.placeOrder = placeOrder;
		System.out.println("下单请求处理完毕,"+placeOrder);
		
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder;
	}
	
	
}
