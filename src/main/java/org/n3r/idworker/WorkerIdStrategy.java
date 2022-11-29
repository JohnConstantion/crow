package org.n3r.idworker;

/**
 * @author johnconstantine
 */
public interface WorkerIdStrategy {
    void initialize();

    long availableWorkerId();

    void release();
}
