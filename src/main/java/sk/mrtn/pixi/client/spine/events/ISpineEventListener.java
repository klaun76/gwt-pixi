package sk.mrtn.pixi.client.spine.events;

import com.google.gwt.event.shared.HandlerRegistration;
import sk.mrtn.pixi.client.spine.Spine;

public interface ISpineEventListener {

    enum SpineEventListenerType {
        START,
        EVENT,
        END,
        COMPLETE,
        DISPOSE,
        INTERUPTED
    }

    interface IStartEventListener {
        void onStartEvent(final Spine spine, final int trackIndex);
    }

    /**
     * Add a start event listener
     *
     * @param startEventListener
     * @return HandlerRegistration
     */
    HandlerRegistration addStartEventListener(final IStartEventListener startEventListener);

    interface IUserEventListener {
        void onUserEvent(final Spine spine, final int trackIndex, final Event event);
    }

    /**
     * Add user event listener
     *
     * @param userEventListener
     * @return HandlerRegistration
     */
    HandlerRegistration addUserEventListener(final IUserEventListener userEventListener);

    interface ICompleteEventListener {
        void onCompleteEvent(final Spine spine, final int trackIndex, final int count);
    }

    /**
     * Add complete event listener
     *
     * @param completeEventListener
     * @return HandlerRegistration
     */
    HandlerRegistration addCompleteEventListener(final ICompleteEventListener completeEventListener);

    interface IEndEventListener {
        void onEndEvent(final Spine spine, final int trackIndex);
    }

    /**
     * Add end event listener
     *
     * @param endEventListener
     * @return HandlerRegistration
     */
    HandlerRegistration addEndEventListener(final IEndEventListener endEventListener);

    interface IDisposeEventListener {
        void onDisposeEvent(final Spine spine, final int trackIndex);
    }

    /**
     * Add a dispose event listener
     *
     * @param disposeEventListener
     * @return HandlerRegistration
     */
    HandlerRegistration addDisposeEventListener(final IDisposeEventListener disposeEventListener);

    interface IInterruptedEventListener {
        void onInterruptedEvent(final Spine spine, final int trackIndex);
    }

    /**
     * Add a interrupted event listener
     *
     * @param interruptedEventListener
     * @return HandlerRegistration
     */
    HandlerRegistration addInterruptedEventListener(final IInterruptedEventListener interruptedEventListener);
}