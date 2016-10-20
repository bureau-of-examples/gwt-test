package zhy2002.uinode;

import java.util.*;

/**
 * Created by ZHY on 11/10/2016.
 */
public abstract class UiNodeContext {


    private enum ChangeState {
        Idle,
        RunningCycle
    }

    private static class Options {
    }

    private final Map<Pair<UiNode, String>, ValueQueueNode> pendingValues = new HashMap<>();
    private final Map<Pair<UiNode, String>, ValueQueueNode> committedValues = new HashMap<>();
    private final Map<UiNode, List<UiNodeError>> nodeErrors = new HashMap<>();
    private final Deque<UiNodeEvent> pendingEvents = new ArrayDeque<>();
    private final UiNodeRuleAgenda agenda = new UiNodeRuleAgenda();
    private final Set<UiNode> changedNodes = new HashSet<>();
    //    private final Options options = new Options();
    private ChangeState changeState = ChangeState.Idle;


    public Object getLatestValue(UiNode uiNode, String property) {

        ValueQueueNode head = getLatestValueQueueNode(uiNode, property);
        return head == null ? null : head.getValue();
    }

    private ValueQueueNode getLatestValueQueueNode(UiNode uiNode, String property) {
        Pair<UiNode, String> key = new Pair<>(uiNode, property);
        ValueQueueNode head = pendingValues.get(key);
        if (head == null) {
            head = committedValues.get(key);
        }
        return head;
    }

    public void processChangeEvent(UiNode uiNode, String property, Object value) {
        ChangeUiNodeEvent changeEvent = new ChangeUiNodeEvent(uiNode, property, value);
        pendingEvents.add(changeEvent);
        setLatestValue(changeEvent);

        if (changeState == ChangeState.Idle) {
            runChangeCycle();
            validate();
        }
    }

    private void validate() {
        for (UiNode node : changedNodes) {
            node.validate();
        }
        changedNodes.clear();
    }

    private void setLatestValue(ChangeUiNodeEvent changeEvent) {
        ValueQueueNode oldHead = pendingValues.get(changeEvent.getKey());
        ValueQueueNode newHead = new ValueQueueNode(changeEvent);
        if (oldHead != null) {
            oldHead.setPrevious(newHead);
            newHead.setNext(oldHead);
        }
        pendingValues.put(newHead.getKey(), newHead);
    }

    private void runChangeCycle() {
        changeState = ChangeState.RunningCycle;
        while (!pendingEvents.isEmpty()) {
            UiNodeEvent event = pendingEvents.poll();
            agenda.addActivations(event);
            while (!agenda.isEmpty()) {
                UiNodeRuleActivation activation = agenda.pollActivation();
                try {
                    activation.fire();
                } catch (InvalidUiNodeChangeException ex) {
                    pendingValues.clear();
                    return;
                }
            }
        }
        changeState = ChangeState.Idle;
        flushPendingChanges();
    }

    private void flushPendingChanges() {
        for (Map.Entry<Pair<UiNode, String>, ValueQueueNode> entry : pendingValues.entrySet()) {
            ValueQueueNode value = null;
            if (entry.getValue() != null) {
                value = entry.getValue();
                if (value.getNext() != null) {
                    value.getNext().setPrevious(null);
                    value.setNext(null);
                }
            }
            committedValues.put(entry.getKey(), value);
            changedNodes.add(entry.getKey().getLeft());
        }
        pendingValues.clear();
    }

    public List<UiNodeError> getErrors(UiNode uiNode) {
        if (!nodeErrors.containsKey(uiNode)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(nodeErrors.get(uiNode));
    }

    public void addErrors(UiNode uiNode, UiNodeError error) {
        if (!nodeErrors.containsKey(uiNode)) {
            nodeErrors.put(uiNode, new ArrayList<UiNodeError>());
        }
        nodeErrors.get(uiNode).add(error);
    }

}
