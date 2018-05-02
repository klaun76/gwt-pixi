package sk.mrtn.pixi.client.spine.events.impl;

import com.google.gwt.event.shared.HandlerRegistration;
import sk.mrtn.pixi.client.spine.Spine;
import sk.mrtn.pixi.client.spine.events.Event;
import sk.mrtn.pixi.client.spine.events.ISpineEventListener;
import sk.mrtn.pixi.client.spine.events.SpineEvents;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpineEventHandling implements ISpineEventListener {

    private static Logger LOG;

    static {
        LOG = Logger.getLogger(SpineEventHandling.class.getSimpleName());
        LOG.setLevel(Level.ALL);
    }

    private Spine spine;
    private static List<SpineEventHandling> eventHandlingList = new ArrayList<>();
    /**
     * List of start event handlers
     */
    private List<IStartEventListener> startEventListeners;

    /**
     * List of user event handlers
     */
    private List<IUserEventListener> userEventListeners;

    /**
     * List of complete event handlers
     */
    private List<ICompleteEventListener> completeEventListeners;

    /**
     * List of end event handler
     */
    private List<IEndEventListener> endEventListeners;

    /**
     * List of dispose event handler
     */
    private List<IDisposeEventListener> disposeEventListeners;

    /**
     * List of interrupt event handler
     */
    private List<IInterruptedEventListener> interruptedEventListeners;

    public SpineEventHandling(final Spine spine) {
        if (eventHandlingList.contains(spine)) {
            return;
        }

        this.spine = spine;
        this.startEventListeners = new ArrayList<>();
        this.userEventListeners = new ArrayList<>();
        this.endEventListeners = new ArrayList<>();
        this.interruptedEventListeners = new ArrayList<>();
        this.completeEventListeners = new ArrayList<>();
        this.disposeEventListeners = new ArrayList<>();

        SpineEvents listener = new SpineEvents();

        listener.event = (trackEntry, event, count) -> onSpineEvent(SpineEventListenerType.EVENT, trackEntry.getTrackIndex(), event, count);
        listener.start = (trackEntry, event, count) -> onSpineEvent(SpineEventListenerType.START, trackEntry.getTrackIndex(), event, count);
        listener.complete = (trackEntry, event, count) -> onSpineEvent(SpineEventListenerType.COMPLETE, trackEntry.getTrackIndex(), event, count);
        listener.end = (trackEntry, event, count) -> onSpineEvent(SpineEventListenerType.END, trackEntry.getTrackIndex(), event, count);
        listener.dispose = (trackEntry, event, count) -> onSpineEvent(SpineEventListenerType.DISPOSE, trackEntry.getTrackIndex(), event, count);
        listener.dispose = (trackEntry, event, count) -> onSpineEvent(SpineEventListenerType.INTERUPTED, trackEntry.getTrackIndex(), event, count);

        this.spine.state.addListener(listener);

        eventHandlingList.add(this);
    }

    public static native void log(Object object) /*-{
        $wnd.console.log(object);
    }-*/;

    public static SpineEventHandling get(final Spine spine) {
        for (SpineEventHandling eventHandling : eventHandlingList) {
            if (eventHandling.getSpine() == spine) {
                return eventHandling;
            }
        }
        return new SpineEventHandling(spine);
    }

    public Spine getSpine() {
        return this.spine;
    }

    private void onSpineEvent(SpineEventListenerType spineEventType, int trackIndex, Event event, int count) {
        switch (spineEventType) {
            case START:
                LOG.fine("#onStartEvent()");
                this.startEventListeners.forEach(listener -> listener.onStartEvent(getSpine(), trackIndex));
                break;
            case EVENT:
                LOG.fine("#onUserEvent()");
                this.userEventListeners.forEach(listener -> listener.onUserEvent(getSpine(), trackIndex, event));
                break;
            case END:
                LOG.fine("#onEndEvent()");
                this.endEventListeners.forEach(listener -> listener.onEndEvent(getSpine(), trackIndex));
                break;
            case COMPLETE:
                LOG.fine("#onCompleteEvent()");
                this.completeEventListeners.forEach(listener -> listener.onCompleteEvent(getSpine(), trackIndex, count));
                break;
            case DISPOSE:
                LOG.fine("#onDisposeEvent()");
                this.disposeEventListeners.forEach(listener -> listener.onDisposeEvent(getSpine(), trackIndex));
                break;
            case INTERUPTED:
                LOG.fine("#onInterruptedEvent()");
                this.interruptedEventListeners.forEach(listener -> listener.onInterruptedEvent(getSpine(), trackIndex));
                break;
        }
    }

    @Override
    public HandlerRegistration addStartEventListener(IStartEventListener startEventListener) {
        this.startEventListeners.add(startEventListener);
        return () -> startEventListeners.remove(startEventListener);
    }

    @Override
    public HandlerRegistration addUserEventListener(IUserEventListener userEventListener) {
        this.userEventListeners.add(userEventListener);
        return () -> userEventListeners.remove(userEventListener);
    }

    @Override
    public HandlerRegistration addCompleteEventListener(ICompleteEventListener completeEventListener) {
        this.completeEventListeners.add(completeEventListener);
        return () -> completeEventListeners.remove(completeEventListener);
    }

    @Override
    public HandlerRegistration addEndEventListener(IEndEventListener endEventListener) {
        this.endEventListeners.add(endEventListener);
        return () -> endEventListeners.remove(endEventListener);
    }

    @Override
    public HandlerRegistration addDisposeEventListener(IDisposeEventListener disposeEventListener) {
        this.disposeEventListeners.add(disposeEventListener);
        return () -> disposeEventListeners.remove(disposeEventListener);
    }

    @Override
    public HandlerRegistration addInterruptedEventListener(IInterruptedEventListener interruptedEventListener) {
        this.interruptedEventListeners.add(interruptedEventListener);
        return () -> interruptedEventListeners.remove(interruptedEventListener);
    }
}
