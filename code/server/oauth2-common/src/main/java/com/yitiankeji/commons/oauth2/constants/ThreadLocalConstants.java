package com.yitiankeji.commons.oauth2.constants;

import com.yitiankeji.commons.oauth2.session.Session;

public class ThreadLocalConstants {

    public static final ThreadLocal<Session> SESSION_THREAD_LOCAL = new ThreadLocal<>();
}
