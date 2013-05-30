package cn.richinfo.crawler;

import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;

public class UrlParser {

	// 循环访问所有节点，输出包含关键字的值节点
	public static void extractKeyWordText(String url, String keyword) {
		try {
			// 生成一个解析器对象，用网页的 url 作为参数
			Parser parser = new Parser(url);
			// 设置网页的编码,这里只是请求了一个 gb2312 编码网页
			parser.setEncoding("gb2312");
			// 迭代所有节点, null 表示不使用 NodeFilter
			NodeList list = parser.parse(null);
			// 从初始的节点列表跌倒所有的节点
			processNodeList(list, keyword);
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}
	
	// 循环访问所有节点，输出包含关键字的值节点
		public static void extractKeyWordText(String url, String keyword,NodeFilter filter) {
			try {
				// 生成一个解析器对象，用网页的 url 作为参数
				Parser parser = new Parser(url);
				// 设置网页的编码,这里只是请求了一个 gb2312 编码网页
				parser.setEncoding("gb2312");
				// 迭代所有节点, null 表示不使用 NodeFilter
				NodeList list = parser.parse(filter);
				// 从初始的节点列表跌倒所有的节点
				processNodeList(list, keyword);
			} catch (ParserException e) {
				e.printStackTrace();
			}
		}

	private static void processNodeList(NodeList list, String keyword) {
		// 迭代开始
		SimpleNodeIterator iterator = list.elements();
		while (iterator.hasMoreNodes()) {
			Node node = iterator.nextNode();
			// 得到该节点的子节点列表
			NodeList childList = node.getChildren();
			// 孩子节点为空，说明是值节点
			if (null == childList) {
				// 得到值节点的值
				String result = node.toPlainTextString();
				// 若包含关键字，则简单打印出来文本
				if (result.indexOf(keyword) != -1)
					System.out.println(result);
			} // end if
				// 孩子节点不为空，继续迭代该孩子节点
			else {
				processNodeList(childList, keyword);
			}// end else
		}// end wile
	}

	// 获取一个网站上的链接,filter 用来过滤链接
	public static Set<String> extracLinks(String url, LinkFilter filter) {
		Set<String> links = new HashSet<String>();
		try {
			Parser parser = new Parser(url);
			parser.setEncoding("gb2312");
			// 过滤 <frame >标签的 filter，用来提取 frame 标签里的 src 属性所表示的链接
			NodeFilter frameFilter = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().startsWith("frame src=")) {
						return true;
					} else {
						return false;
					}
				}
			};
			// OrFilter 来设置过滤 <a> 标签，和 <frame> 标签
			OrFilter linkFilter = new OrFilter(new NodeClassFilter(
					LinkTag.class), frameFilter);
			// 得到所有经过过滤的标签
			NodeList list = parser.extractAllNodesThatMatch(linkFilter);
			for (int i = 0; i < list.size(); i++) {
				Node tag = list.elementAt(i);
				if (tag instanceof LinkTag)// <a> 标签
				{
					LinkTag link = (LinkTag) tag;
					String linkUrl = link.getLink();// url
					if (filter.accept(linkUrl))
						links.add(linkUrl);
				} else// <frame> 标签
				{
					// 提取 frame 里 src 属性的链接如 <frame src="test.html"/>
					String frame = tag.getText();
					int start = frame.indexOf("src=");
					frame = frame.substring(start);
					int end = frame.indexOf(" ");
					if (end == -1)
						end = frame.indexOf(">");
					String frameUrl = frame.substring(5, end - 1);
					if (filter.accept(frameUrl))
						links.add(frameUrl);
				}
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return links;
	}

	// 测试的 main 方法
	public static void main(String[] args) {
		Set<String> links = UrlParser.extracLinks("http://www.tydic.com/Default.aspx",
				new LinkFilter() {
					// 提取以 http://www.twt.edu.cn 开头的链接
					public boolean accept(String url) {
						if (url.startsWith("http://www.tydic.com"))
							return true;
						else
							return false;
			}
		});
		for (String link : links)
			System.out.println(link);
	}
}
