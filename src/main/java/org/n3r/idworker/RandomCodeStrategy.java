package org.n3r.idworker;

/**
 * @author johnconstantine
 */
public interface RandomCodeStrategy {
    void init();

    int prefix();

    int next();

    void release();
}
