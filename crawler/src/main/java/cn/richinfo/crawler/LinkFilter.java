package cn.richinfo.crawler;

public interface LinkFilter {
	public boolean accept(String url);
}