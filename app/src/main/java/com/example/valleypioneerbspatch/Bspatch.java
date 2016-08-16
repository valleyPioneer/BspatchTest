package com.example.valleypioneerbspatch;

/**
 * Created by 半米阳光 on 2016/8/15.
 */
public class Bspatch {

    static {
        System.loadLibrary("ValleyPioneerBspatch");
    }

    public native int applyPatch(String oldApk,String newApk ,String patch);
}
