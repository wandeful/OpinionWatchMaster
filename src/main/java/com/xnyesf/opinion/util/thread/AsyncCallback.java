package com.xnyesf.opinion.util.thread;

/**
 * @author CaoLiangBin
 * @date 2024年12月10日 0:45
 * @description 异步回调
 */
public interface AsyncCallback<T> {
    void onSuccess(T result);
    void onFailure(Throwable throwable);
}
