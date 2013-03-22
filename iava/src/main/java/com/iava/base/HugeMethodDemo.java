package com.iava.base;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class HugeMethodDemo {
	 
	 public static void main(String[] args) throws Exception {
	   HugeMethodDemo demo = new HugeMethodDemo();
	 
	   int warmup = 2000;
	   demo.run(warmup);
	 
	   int loop = 200000;
	   double total = demo.run(loop);
	   double avg = total / loop / 1e6 * 1e4;
	 
	   System.out.println(String.format(
	     "Loop=%d次, " + "avg=%.2f毫秒/万次", loop, avg));
	 }
	 
	 private long run(int loop) throws Exception {
	   long total = 0L;
	 
	   for (int i = 0; i < loop; i++) {
	     Map theWorld = buildTheWorld();
	     StringWriter console = new StringWriter();
	 
	     long start = System.nanoTime();
	     play(theWorld, console);
	     long end = System.nanoTime();
	     total += (end - start);
	   }
	 
	   return total;
	 }
	 
	 private Map buildTheWorld() {
	   Map context = new HashMap();
	   context.put("name", "D&D");
	   context.put("version", "1.0");
	 
	   Map game = new HashMap();
	   context.put("game", game);
	 
	   Map player = new HashMap();
	   game.put("player", player);
	   player.put("level", "26");
	   player.put("name", "jifeng");
	   player.put("job", "paladin");
	   player.put("address", "heaven");
	   player.put("weapon", "sword");
	   player.put("hp", 150);
	 
	   String[] bag = new String[] { "world_map", "dagger",
	     "magic_1", "potion_1", "postion_2", "key" };
	   player.put("bag", bag);
	   return context;
	 }
	 
	 private void play(Map theWorld, Writer console) throws Exception {
	   // 重复拷贝的开始位置
	   if (true) {
	     String name = String.valueOf(theWorld.get("name"));
	     String version = String.valueOf(theWorld.get("version"));
	     console.append("Game ").append(name).append(" (v").append(version).append(")\n");
	     Map game = (Map) theWorld.get("game");
	     if (game != null) {
	       Map player = (Map) game.get("player");
	       if (player != null) {
	         String level = String.valueOf(player.get("level"));
	         String job = String.valueOf(player.get("job"));
	         String address = String.valueOf(player.get("address"));
	         String weapon = String.valueOf(player.get("weapon"));
	         String hp = String.valueOf(player.get("hp"));
	         console.append("  You are a ").append(level).append(" level ").append(job)
	                .append(" from ").append(address).append(". \n");
	         console.append("  Currently you have a ").append(weapon).append(" in hand, ")
	                .append("your hp: ").append(hp).append(". \n");
	         console.append("  Here are items in your bag: \n");
	         for (String item : (String[]) player.get("bag")) {
	           console.append("     * ").append(item).append("\n");
	         }
	       } else {
	         console.append("\tPlayer not login.\n");
	       }
	     } else {
	       console.append("\tGame not start yet.\n");
	     }
	   }
	   // 重复拷贝的结束位置
	 }
	}
