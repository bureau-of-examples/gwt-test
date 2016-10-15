package zhy2002.uinode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZHY on 11/10/2016.
 */
public abstract class UiNodeContext {

    private enum ChangeState {
        Idle
    }

    private static class Options {
    }

    private final Map<Pair<UiNode, String>, ValueQueueNode> storage = new HashMap<>();
    private final Deque<UiNodeEvent> pendingEvents = new ArrayDeque<>();
    private final Options options = new Options();
    private ChangeState changeState = ChangeState.Idle;


    public String getLatestValue(UiNode uiNode, String property) {

        Pair<UiNode, String> key = new Pair<>(uiNode, property);
        ValueQueueNode head = storage.get(key);
        return head == null ? null : head.getValue();
    }

    public void processChangeEvent(UiNode uiNode, String property, String value) {
        ChangeUiNodeEvent changeEvent = new ChangeUiNodeEvent(uiNode, property, value);
        pendingEvents.add(changeEvent);
        ValueQueueNode oldHead = storage.get(changeEvent.getKey());
        ValueQueueNode newHead = new ValueQueueNode(changeEvent);
        if (oldHead != null) {
            oldHead.setPrevious(newHead);
            newHead.setNext(oldHead);
        }
        storage.put(newHead.getKey(), newHead);

        runChangeCycle();
    }

    private void runChangeCycle() {

    }
}
