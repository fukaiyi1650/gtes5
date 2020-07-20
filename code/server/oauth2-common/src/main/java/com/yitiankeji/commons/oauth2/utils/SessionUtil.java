package com.yitiankeji.commons.oauth2.utils;

import com.yitiankeji.commons.oauth2.session.Session;

import static com.yitiankeji.commons.oauth2.constants.ThreadLocalConstants.SESSION_THREAD_LOCAL;

public class SessionUtil {

    public static Session getSession() {
        return SESSION_THREAD_LOCAL.get();
    }
}
