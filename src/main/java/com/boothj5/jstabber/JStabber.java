package com.boothj5.jstabber;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class JStabber {
    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary(("stabber"), CLibrary.class);

        int stbbr_start(int loglevel, int port, int httpport);
        void stbbr_stop();
        void stbbr_set_timeout(int seconds);
        int stbbr_auth_password(String password);
        int stbbr_for_id(String id, String stanza);
        int stbbr_for_query(String query, String stanza);
        void stbbr_wait_for(String id);
        int stbbr_received(String stanza);
        int stbbr_last_received(String stanza);
        void stbbr_send(String stanza);
    }

    private JStabber() {}

    public static boolean stbbrStart(int logLevel, int port, int httpPort) {
        return (CLibrary.INSTANCE.stbbr_start(logLevel, port, httpPort) == 1);
    }

    public static void stbbrStop() {
        CLibrary.INSTANCE.stbbr_stop();
    }

    public static void stbbrSetTimeout(int seconds) {
        CLibrary.INSTANCE.stbbr_set_timeout(seconds);
    }

    public static boolean stbbrAuthPassword(String password) {
        return (CLibrary.INSTANCE.stbbr_auth_password(password) == 1);
    }

    public static boolean stbbrForId(String id, String stanza) {
        return (CLibrary.INSTANCE.stbbr_for_id(id, stanza) == 1);
    }

    public static boolean stbbrForQuery(String query, String stanza) {
        return (CLibrary.INSTANCE.stbbr_for_query(query, stanza) == 1);
    }

    public static void stbbrWaitFor(String id) {
        CLibrary.INSTANCE.stbbr_wait_for(id);
    }

    public static boolean stbbrReceived(String stanza) {
        return (CLibrary.INSTANCE.stbbr_received(stanza) == 1);
    }

    public static boolean stbbrLastReceived(String stanza) {
        return (CLibrary.INSTANCE.stbbr_last_received(stanza) == 0);
    }

    public static void stbbrSend(String stanza) {
        CLibrary.INSTANCE.stbbr_send(stanza);
    }
}
