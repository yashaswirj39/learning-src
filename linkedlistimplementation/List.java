package linkedlistimplementation;

import node.Listnode;

public interface List {
    public void add(int data);

    public Listnode listIntersection(Listnode l1, Listnode l2);

    public void show(Listnode node);

    public boolean isPallindrome(Listnode l1);

    public Listnode reverse(Listnode l1);

    public Listnode sort(Listnode l1);

    public Listnode middle(Listnode l1);
}
