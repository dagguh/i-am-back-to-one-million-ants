package com.atlassian.million.ants;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Colony {

    private final Collection<Ant> ants = new ConcurrentLinkedQueue<>();

    public void spawnAnts() {
        IntStream.range(0, 1_000_000).forEach(
                a -> ants.add(spawnAnt())
        );
    }

    private Ant spawnAnt() {
        Ant ant = new Ant();
        Thread.startVirtualThread(ant::live);
        return ant;
    }

    public Stream<Ant> listAnts() {
        return ants.stream();
    }
}
