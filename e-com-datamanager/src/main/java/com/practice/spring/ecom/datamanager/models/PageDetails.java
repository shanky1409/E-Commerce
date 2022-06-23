package com.practice.spring.ecom.datamanager.models;

public class PageDetails {
	
	private int currentPage;
	private int totalPage;
	private int numberOfElements;
	private boolean hasNextPage;
	
	public PageDetails(int currentPage, int totalPage, int numberOfElements, boolean hasNextPage) {
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.numberOfElements = numberOfElements;
		this.hasNextPage = hasNextPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

}
