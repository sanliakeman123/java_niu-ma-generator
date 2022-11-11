package com.common;

import java.util.List;

public class ParentListSon<P,S> {
    private P parent;
    private List<S> sons;

    public P getParent() {
        return parent;
    }

    public ParentListSon<P,S> setParent(P parent) {
        this.parent = parent;
        return this;
    }

    public List<S> getSons() {
        return sons;
    }

    public ParentListSon<P,S> setSons(List<S> sons) {
        this.sons = sons;
        return this;
    }
}
