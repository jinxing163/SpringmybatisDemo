package com.ssm.util;

import java.io.Serializable;

//分页对象	
public class PageUtil implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer currentPage;//当前页  	  	（默认第一页）
	private Integer pageSize;	//每页显示的条数  （默认10条）
	private Integer totalNums;	//总条数
	private Integer totalPage;	//总页数
	public Integer getCurrentPage() {
		if(currentPage ==null){
			return 1;
		}
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		if(pageSize ==null){
			return 10;
		}
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalNums() {
		return totalNums;
	}
	public void setTotalNums(Integer totalNums) {
		this.totalNums = totalNums;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
