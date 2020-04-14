//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.express.common.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

public class IPUtil {
    private static String cacheLocalIP = null;

    private IPUtil() {
    }

    public static String getServerIp() {
        if (cacheLocalIP != null) {
            return cacheLocalIP;
        } else {
            try {
                String localIp = null;
                String osName = System.getProperty("os.name");
                if (osName.toLowerCase().contains("windows")) {
                    localIp = InetAddress.getLocalHost().getHostAddress().trim();
                } else {
                    Enumeration en = NetworkInterface.getNetworkInterfaces();

                    label51:
                    while(true) {
                        NetworkInterface intf;
                        String name;
                        do {
                            do {
                                if (!en.hasMoreElements()) {
                                    if (localIp == null) {
                                        throw new RuntimeException("无法获取本地IP地址");
                                    }
                                    break label51;
                                }

                                intf = (NetworkInterface)en.nextElement();
                                name = intf.getName();
                            } while(name.contains("docker"));
                        } while(name.contains("lo"));

                        Enumeration enumIpAddr = intf.getInetAddresses();

                        while(enumIpAddr.hasMoreElements()) {
                            InetAddress inetAddress = (InetAddress)enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress()) {
                                String ipaddress = inetAddress.getHostAddress();
                                if (ipaddress.matches("(\\d{1,3}\\.){3}\\d{1,3}") && ipaddress.indexOf(":") == -1) {
                                    localIp = ipaddress.trim();
                                }
                            }
                        }
                    }
                }

                cacheLocalIP = localIp;
            } catch (Exception var8) {
                throw new RuntimeException("无法获取本地IP地址.", var8);
            }

            return cacheLocalIP;
        }
    }

    public static String getClientIp(HttpServletRequest request) {
        String ip = "";

        try {
            ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
                ip = request.getHeader("Proxy-Client-IP");
            }

            if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }

            if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
                ip = request.getRemoteAddr();
            }

            if ("0:0:0:0:0:0:0:1".equals(ip)) {
                return "127.0.0.1";
            } else {
                return ip != null && ip.contains(",") ? ip.substring(0, ip.indexOf(",")) : ip;
            }
        } catch (Exception var3) {
            throw new RuntimeException("无法获取客户端IP地址", var3);
        }
    }
}
