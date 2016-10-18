package zhy2002.uinode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ZHY on 18/10/2016.
 */
public class UiNodeRuleAgenda {

    private final Deque<UiNodeRuleActivation> activationQueue = new ArrayDeque<>();

    public void addActivations(UiNodeEvent event) {

        for (UiNodeRule<?, ?> activeRule : event.getActiveRules()) {
            activationQueue.add(new UiNodeRuleActivation(event, activeRule));
        }
    }

    public boolean isEmpty() {
        return activationQueue.isEmpty();
    }

    public UiNodeRuleActivation pollActivation() {
        return activationQueue.poll();
    }
}
