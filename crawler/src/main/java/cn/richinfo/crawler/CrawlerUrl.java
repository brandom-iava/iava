package cn.richinfo.crawler;

import java.util.Date;

public class CrawlerUrl {

	private Long id;
	private String name;
	private String url;
	private int priority;
	
	/**
	 * 抓取深度
	 */
	private int depth;
	
	/**
	 * 抓取状态
	 */
	private int state;
	
	private Date lastCrawlerDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getLastCrawlerDate() {
		return lastCrawlerDate;
	}

	public void setLastCrawlerDate(Date lastCrawlerDate) {
		this.lastCrawlerDate = lastCrawlerDate;
	}
	
	
}
