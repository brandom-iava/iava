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

	// ѭ���������нڵ㣬��������ؼ��ֵ�ֵ�ڵ�
	public static void extractKeyWordText(String url, String keyword) {
		try {
			// ����һ����������������ҳ�� url ��Ϊ����
			Parser parser = new Parser(url);
			// ������ҳ�ı���,����ֻ��������һ�� gb2312 ������ҳ
			parser.setEncoding("gb2312");
			// �������нڵ�, null ��ʾ��ʹ�� NodeFilter
			NodeList list = parser.parse(null);
			// �ӳ�ʼ�Ľڵ��б�������еĽڵ�
			processNodeList(list, keyword);
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}
	
	// ѭ���������нڵ㣬��������ؼ��ֵ�ֵ�ڵ�
		public static void extractKeyWordText(String url, String keyword,NodeFilter filter) {
			try {
				// ����һ����������������ҳ�� url ��Ϊ����
				Parser parser = new Parser(url);
				// ������ҳ�ı���,����ֻ��������һ�� gb2312 ������ҳ
				parser.setEncoding("gb2312");
				// �������нڵ�, null ��ʾ��ʹ�� NodeFilter
				NodeList list = parser.parse(filter);
				// �ӳ�ʼ�Ľڵ��б�������еĽڵ�
				processNodeList(list, keyword);
			} catch (ParserException e) {
				e.printStackTrace();
			}
		}

	private static void processNodeList(NodeList list, String keyword) {
		// ������ʼ
		SimpleNodeIterator iterator = list.elements();
		while (iterator.hasMoreNodes()) {
			Node node = iterator.nextNode();
			// �õ��ýڵ���ӽڵ��б�
			NodeList childList = node.getChildren();
			// ���ӽڵ�Ϊ�գ�˵����ֵ�ڵ�
			if (null == childList) {
				// �õ�ֵ�ڵ��ֵ
				String result = node.toPlainTextString();
				// �������ؼ��֣���򵥴�ӡ�����ı�
				if (result.indexOf(keyword) != -1)
					System.out.println(result);
			} // end if
				// ���ӽڵ㲻Ϊ�գ����������ú��ӽڵ�
			else {
				processNodeList(childList, keyword);
			}// end else
		}// end wile
	}

	// ��ȡһ����վ�ϵ�����,filter ������������
	public static Set<String> extracLinks(String url, LinkFilter filter) {
		Set<String> links = new HashSet<String>();
		try {
			Parser parser = new Parser(url);
			parser.setEncoding("gb2312");
			// ���� <frame >��ǩ�� filter��������ȡ frame ��ǩ��� src ��������ʾ������
			NodeFilter frameFilter = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().startsWith("frame src=")) {
						return true;
					} else {
						return false;
					}
				}
			};
			// OrFilter �����ù��� <a> ��ǩ���� <frame> ��ǩ
			OrFilter linkFilter = new OrFilter(new NodeClassFilter(
					LinkTag.class), frameFilter);
			// �õ����о������˵ı�ǩ
			NodeList list = parser.extractAllNodesThatMatch(linkFilter);
			for (int i = 0; i < list.size(); i++) {
				Node tag = list.elementAt(i);
				if (tag instanceof LinkTag)// <a> ��ǩ
				{
					LinkTag link = (LinkTag) tag;
					String linkUrl = link.getLink();// url
					if (filter.accept(linkUrl))
						links.add(linkUrl);
				} else// <frame> ��ǩ
				{
					// ��ȡ frame �� src ���Ե������� <frame src="test.html"/>
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

	// ���Ե� main ����
	public static void main(String[] args) {
		Set<String> links = UrlParser.extracLinks("http://www.tydic.com/Default.aspx",
				new LinkFilter() {
					// ��ȡ�� http://www.twt.edu.cn ��ͷ������
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
