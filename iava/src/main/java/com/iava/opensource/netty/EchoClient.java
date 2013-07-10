/*
 * Copyright 2009 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.iava.opensource.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

/**
 * Sends one message when a connection is open and echoes back any received
 * data to the server.  Simply put, the echo client initiates the ping-pong
 * traffic between the echo client and server by sending the first message to
 * the server.
 *
 * @author <a href="http://www.jboss.org/netty/">The Netty Project</a>
 * @author <a href="http://gleamynode.net/">Trustin Lee</a>
 *
 * @version $Rev: 2080 $, $Date: 2010-01-26 18:04:19 +0900 (Tue, 26 Jan 2010) $
 *
 */
public class EchoClient {

    public static void main(String[] args) throws Exception {
        // Print usage if no argument is specified.
       /* if (args.length < 2 || args.length > 3) {
            System.err.println(
                    "Usage: " + EchoClient.class.getSimpleName() +
                    " <host> <port> [<first message size>]");
            return;
        }*/

        // Parse options.
        final String host = "localhost";
        final int port = Integer.parseInt("8080");
        final int firstMessageSize = 256 ;
       /* if (args.length == 0) {
            firstMessageSize = Integer.parseInt(args[2]);
        } */

        // Configure the client.
        ClientBootstrap bootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));

        // Set up the pipeline factory.
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(
                        new EchoClientHandler(firstMessageSize));
            }
        });

        // Start the connection attempt.
        ChannelFuture future = bootstrap.connect(new InetSocketAddress(host, port));
        ChannelBuffer bu =  ChannelBuffers.buffer(64);
        for (int i = 0; i < bu.capacity(); i ++) {
        	bu.writeByte((byte) i);
        }
       
        future.getChannel().getCloseFuture().awaitUninterruptibly();
        // Wait until the connection is closed or the connection attempt fails.
        future.getChannel().write("hello echo!");

        // Shut down thread pools to exit.
        bootstrap.releaseExternalResources();
    }
}
