package sk.mrtn.pixi.client.spine.events.impl;

import com.google.gwt.event.shared.HandlerRegistration;
import sk.mrtn.pixi.client.spine.Spine;
import sk.mrtn.pixi.client.spine.events.Event;
import sk.mrtn.pixi.client.spine.events.ISpineEventHandler;
import sk.mrtn.pixi.client.spine.events.ISpineEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpineEventHandling implements ISpineEventListener, ISpineEventHandler {

    private static Logger LOG;

    static {
        LOG = Logger.getLogger(SpineEventHandling.class.getSimpleName());
        LOG.setLevel(Level.OFF);
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
        this.spine.state.addEvents(this.spine, this);

        eventHandlingList.add(this);
    }

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

    @Override
    public void onStartEvent(int trackIndex) {
        LOG.fine("#onStartEvent()");

        if (this.startEventListeners == null) {
            return;
        }

        this.startEventListeners.forEach(listener -> listener.onStartEvent(getSpine(), trackIndex));
    }

    @Override
    public void onUserEvent(int trackIndex, Event event) {
        LOG.fine("#onUserEvent()");

        if (this.userEventListeners == null) {
            return;
        }

        this.userEventListeners.forEach(listener -> listener.onUserEvent(getSpine(), trackIndex, event));
    }

    @Override
    public void onEndEvent(int trackIndex) {
        LOG.fine("#onEndEvent()");

        if (this.endEventListeners == null) {
            return;
        }

        this.endEventListeners.forEach(listener -> listener.onEndEvent(getSpine(), trackIndex));
    }

    @Override
    public void onCompleteEvent(int trackIndex, int count) {
        LOG.fine("#onCompleteEvent()");

        if (this.completeEventListeners == null) {
            return;
        }

        this.completeEventListeners.forEach(listener -> listener.onCompleteEvent(getSpine(), trackIndex, count));
    }

    @Override
    public void onDisposeEvent(int trackIndex) {
        LOG.fine("#onDisposeEvent()");

        if (this.disposeEventListeners == null) {
            return;
        }

        this.disposeEventListeners.forEach(listener -> listener.onDisposeEvent(getSpine(), trackIndex));
    }

    @Override
    public void onInterruptedEvent(int trackIndex) {
        LOG.fine("#onInterruptedEvent()");

        if (this.interruptedEventListeners == null) {
            return;
        }

        this.interruptedEventListeners.forEach(listener -> listener.onInterruptedEvent(getSpine(), trackIndex));
    }

    @Override
    public HandlerRegistration addStartEventListener(IStartEventListener startEventListener) {
        if (this.startEventListeners == null) {
            this.startEventListeners = new ArrayList<>();
        }
        this.startEventListeners.add(startEventListener);
        return () -> startEventListeners.remove(startEventListener);
    }

    @Override
    public HandlerRegistration addUserEventListener(IUserEventListener userEventListener) {
        if (this.userEventListeners == null) {
            this.userEventListeners = new ArrayList<>();
        }
        this.userEventListeners.add(userEventListener);
        return () -> userEventListeners.remove(userEventListener);
    }

    @Override
    public HandlerRegistration addCompleteEventListener(ICompleteEventListener completeEventListener) {
        if (this.completeEventListeners == null) {
            this.completeEventListeners = new ArrayList<>();
        }
        this.completeEventListeners.add(completeEventListener);
        return () -> completeEventListeners.remove(completeEventListener);
    }

    @Override
    public HandlerRegistration addEndEventListener(IEndEventListener endEventListener) {
        if (this.endEventListeners == null) {
            this.endEventListeners = new ArrayList<>();
        }
        this.endEventListeners.add(endEventListener);
        return () -> endEventListeners.remove(endEventListener);
    }

    @Override
    public HandlerRegistration addDisposeEventListener(IDisposeEventListener disposeEventListener) {
        if (this.disposeEventListeners == null) {
            this.disposeEventListeners = new ArrayList<>();
        }
        this.disposeEventListeners.add(disposeEventListener);
        return () -> disposeEventListeners.remove(disposeEventListener);
    }

    @Override
    public HandlerRegistration addInterruptedEventListener(IInterruptedEventListener interruptedEventListener) {
        if (this.interruptedEventListeners == null) {
            this.interruptedEventListeners = new ArrayList<>();
        }
        this.interruptedEventListeners.add(interruptedEventListener);
        return () -> interruptedEventListeners.remove(interruptedEventListener);
    }
}
