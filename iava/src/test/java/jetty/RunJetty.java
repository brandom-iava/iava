package jetty;

import java.io.File;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class RunJetty {

	private static Integer port = 8003;

	private static String contextPath = "/iava";

	public static void main(String[] args) throws Exception {
		File rootDir = new File(RunJetty.class.getResource("/").getPath())
				.getParentFile().getParentFile();

		// jetty server start
		long begin = System.currentTimeMillis();
		Server server = new Server(port);
		String webAppPath = new File(rootDir, "webapp").getPath();
		webAppPath = java.net.URLDecoder.decode(webAppPath, "utf-8");
		new WebAppContext(server, webAppPath, contextPath);
		server.start();
		System.out.println("Jetty Server started, use "
				+ (System.currentTimeMillis() - begin) + " ms");
	}
}