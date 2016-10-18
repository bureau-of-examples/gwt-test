package zhy2002.uinode;

/**
 * Created by ZHY on 18/10/2016.
 */
public class UiNodeRuleActivation {

    private final UiNodeEvent event;
    private final UiNodeRule<?, UiNodeEvent> rule;

    public UiNodeRuleActivation(UiNodeEvent event, UiNodeRule<?, ?> activeRule) {
        this.event = event;
        this.rule = (UiNodeRule<?, UiNodeEvent>) activeRule;
    }

    public void fire() {
        rule.fire(event);
    }
}
