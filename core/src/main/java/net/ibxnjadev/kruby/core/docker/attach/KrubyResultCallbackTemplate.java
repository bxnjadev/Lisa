package net.ibxnjadev.kruby.core.docker.attach;

import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.async.ResultCallbackTemplate;

public abstract class KrubyResultCallbackTemplate<RC_T extends ResultCallback<A_RES_T>, A_RES_T> extends ResultCallbackTemplate<RC_T, A_RES_T> {

    public KrubyResultCallbackTemplate() {

    }
}
