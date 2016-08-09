package com.xindawn.jni;

import java.io.UnsupportedEncodingException;
import com.xindawn.RenderApplication;
import android.content.Context;


public class PlatinumJniProxy {

    static {
			System.loadLibrary("jniinterface");
        	System.loadLibrary("mediaserver");
    }   
 
    public static native int startMediaRender(String friendname,int width,int height ,int airtunes_port,int airplay_port,int rcv_size,Context obj );
    public static native int stopMediaRender();  
    public static native boolean responseGenaEvent(int cmd, byte[] value ,byte[] data);  
    public static native boolean enableLogPrint(boolean flag);
 
    
    public static  int startMediaRender_Java(String friendname){
    	if (friendname == null)friendname = "";
    
    	int ret = -1;
    
    	ret = startMediaRender(friendname,1280,720,47000,7000,128*1024,RenderApplication.getInstance());
	
    	return ret;
    }
    
    public static  boolean responseGenaEvent(int cmd, String value, String data){
    	if (value == null)value = "";
    	if (data == null)data = "";
    	boolean ret = false;
    	try {
			ret = responseGenaEvent(cmd, value.getBytes("utf-8"), data.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return ret;
    }
    
    
}
