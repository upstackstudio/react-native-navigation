package com.reactnativenavigation.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.events.EventDispatcher;

import javax.annotation.concurrent.ThreadSafe;
import java.util.List;

/**
 * Provides UIImplementation to use in {@link UIManagerModule}.
 */
public class ThreadSafeUIImplementationProvider extends UIImplementationProvider {
    @Override
    public UIImplementation createUIImplementation(
        ReactApplicationContext reactContext,
        UIManagerModule.ViewManagerResolver viewManagerResolver,
        EventDispatcher eventDispatcher,
        int minTimeLeftInFrameForNonBatchedOperationMs) {
        return new ThreadSafeUIImplementation(
            reactContext,
            viewManagerResolver,
            eventDispatcher,
            minTimeLeftInFrameForNonBatchedOperationMs);
    }

    @Override
    public UIImplementation createUIImplementation(
        ReactApplicationContext reactContext,
        List<ViewManager> viewManagerList,
        EventDispatcher eventDispatcher,
        int minTimeLeftInFrameForNonBatchedOperationMs) {
        return new ThreadSafeUIImplementation(
            reactContext,
            viewManagerList,
            eventDispatcher,
            minTimeLeftInFrameForNonBatchedOperationMs);
    }
}