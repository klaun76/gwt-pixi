package sk.mrtn.pixi.client.spine.events;

public interface ISpineEventHandler {

    /**
     * It's called when animation started
     *
     * @param trackIndex - track index or spacetime of animation run
     */
    void onStartEvent(int trackIndex);

    /**
     * It's user defined event fired at any time during spine animation playback
     *
     * @param trackIndex - track index or spacetime of animation run
     * @param event      - user defined event. Check {@link Event} for more information
     */
    void onUserEvent(int trackIndex, Event event);

    /**
     * It's called on animation end right after {@link #onCompleteEvent(int, int)}
     *
     * @param trackIndex - track index or spacetime of animation run
     */
    void onEndEvent(int trackIndex);

    /**
     * It's called on animation complete but on repetition too.
     *
     * @param trackIndex - track index or spacetime of animation run
     * @param count      - number of spine animation repetitions.
     */
    void onCompleteEvent(int trackIndex, int count);

    /**
     * It's called when animation was disposed
     *
     * @param trackIndex - track index or spacetime of animation run
     */
    void onDisposeEvent(int trackIndex);

    /**
     * It's called when animation was interrupted
     *
     * @param trackIndex - track index or spacetime of animation run
     */
    void onInterruptedEvent(int trackIndex);
}
