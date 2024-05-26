package com.app.utils;

public class AnimationHandler {
    public static void waitForAnimationToComplete() {
        try {
            // Ideally should be dynamically adjusted based on actual UI behavior
            // Quick solution, animations are fixed-time, so no big deal
            Thread.sleep(200); // Waits for 200 milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
