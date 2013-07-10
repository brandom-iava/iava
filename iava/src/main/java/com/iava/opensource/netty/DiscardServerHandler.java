package com.iava.opensource.netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class DiscardServerHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
    	Channel ch = e.getChannel();
    	ChannelBuffer message = (ChannelBuffer)e.getMessage();
    	/*while(message.readable()) {
            System.out.println((char) message.readByte());
            System.out.flush();
        }*/
    	ChannelBuffer b = ChannelBuffers.dynamicBuffer(6);
    	b.writeByte('1');
    	b.writeByte('2');
    	b.writeByte('3');
    	b.writeByte('4');
    	b.resetReaderIndex();
    	/*System.out.println((char)b.readByte());
    	System.out.println((char)b.readByte());
    	System.out.println((char)b.readByte());*/
    	ch.write(b);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
        e.getCause().printStackTrace();
        
        Channel ch = e.getChannel();
        ch.close();
    }
}