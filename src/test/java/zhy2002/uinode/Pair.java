package zhy2002.uinode;

import java.util.Objects;

/**
 * Created by ZHY on 15/10/2016.
 */
public class Pair<U, V> {

    private final U left;
    private final V right;

    public Pair(U left, V right) {
        this.left = left;
        this.right = right;
    }

    public U getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(left, pair.left) &&
                Objects.equals(right, pair.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
