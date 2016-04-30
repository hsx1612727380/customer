package com.hsx.domain;

import java.util.List;

/**
 * 分页
 * 
 * @author hsx
 * 
 */
public class Page {

	private List list; // 存放分页的数据
	private int totalPage; // 总页数，自己需要计算
	private int pageSize = 1; // 每页的记录数
	private int totalRecord; // 总记录数，数据库可以查询出来 *
	private int startIndex; // 每页第一条记录的索引号，自己需要计算
	private int pageNum; // 用户要看的页码，用户从页面上传回来 *
	
	private int startPage; // 开始页数
	private int endPage; // 结束页数
	
	private String servletName;

	public Page(int totalRecord, int pageNum) {
		this.totalRecord = totalRecord;
		this.pageNum = pageNum;
		// 计算总页数
		if (this.totalRecord % pageSize == 0) {
			totalPage = this.totalRecord / pageSize;
		} else {
			totalPage = this.totalRecord / pageSize + 1;
		}
		startIndex = (this.pageNum - 1) * pageSize;
		
		//根据当前用户要看的页数来计算开始页数和结束页面
		if (totalPage <= 10) {
			startPage = 1;
			endPage = totalPage;
		}
		else {
			startPage = this.pageNum  - 5;
			endPage = this.pageNum + 4;
			if (startPage < 1) {
				startPage = 1;
				endPage = 10;
			}
			if (endPage > totalPage) {
				startPage = totalPage - 9;
				endPage = totalPage;
			}
		}
		
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getServletName() {
		return servletName;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}
	
}
