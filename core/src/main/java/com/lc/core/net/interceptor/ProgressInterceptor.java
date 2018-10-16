package com.lc.core.net.interceptor;


import com.lc.core.net.body.FileResponseBody;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Author:Edward
 * Date:2018/5/4
 * Description:
 */

public class ProgressInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .body(new FileResponseBody(originalResponse.body()))
                .build();
    }
}
