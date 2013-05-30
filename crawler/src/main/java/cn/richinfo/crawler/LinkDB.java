package cn.richinfo.crawler;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LinkDB {

	// �ѷ��ʵ� url ����
	private static Set<String> visitedUrl = new HashSet<String>();
	// �����ʵ� url ����
	private static URLQueue<String> unVisitedUrl = new URLQueue<String>();

	public static URLQueue<String> getUnVisitedUrl() {
		return unVisitedUrl;
	}

	public static void addVisitedUrl(String url) {
		visitedUrl.add(url);
	}

	public static void removeVisitedUrl(String url) {
		visitedUrl.remove(url);
	}

	public static String unVisitedUrlDeQueue() {
		return unVisitedUrl.deQueue();
	}

	// ��֤ÿ�� url ֻ������һ��
	public static void addUnvisitedUrl(String url) {
		if (url != null && !url.trim().equals("") && !visitedUrl.contains(url)
				&& !unVisitedUrl.contians(url))
			unVisitedUrl.enQueue(url);
	}

	public static int getVisitedUrlNum() {
		return visitedUrl.size();
	}

	public static boolean unVisitedUrlsEmpty() {
		return unVisitedUrl.empty();
	}
}
