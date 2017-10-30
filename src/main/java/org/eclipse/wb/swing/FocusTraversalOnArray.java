/*******************************************************************************
 * Copyright (c) 2011 Google, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Google, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.wb.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

/**
 * Cyclic focus traversal policy based on array of components.
 * <p>
 * This class may be freely distributed as part of any application or plugin.
 * 
 * @author scheglov_ke
 */
public class FocusTraversalOnArray extends FocusTraversalPolicy {
    private final Component[] mComponents;

    ////////////////////////////////////////////////////////////////////////////
    //
    // Constructor
    //
    /**
     * Instantiates a new focus traversal on array.
     *
     * @param components
     *            the components
     */
    ////////////////////////////////////////////////////////////////////////////
    public FocusTraversalOnArray(final Component[] components) {
        mComponents = components;
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // Utilities
    //
    /**
     * Index cycle.
     *
     * @param index
     *            the index
     * @param delta
     *            the delta
     * @return the int
     */
    ////////////////////////////////////////////////////////////////////////////
    private int indexCycle(final int index, final int delta) {
        int size = mComponents.length;
        int next = (index + delta + size) % size;
        return next;
    }

    /**
     * Cycle.
     *
     * @param currentComponent
     *            the current component
     * @param delta
     *            the delta
     * @return the component
     */
    private Component cycle(final Component currentComponent, final int delta) {
        int index = -1;
        loop: for (int i = 0; i < mComponents.length; i++) {
            Component component = mComponents[i];
            for (Component c = currentComponent; c != null; c = c.getParent()) {
                if (component == c) {
                    index = i;
                    break loop;
                }
            }
        }
        // try to find enabled component in "delta" direction
        int initialIndex = index;
        while (true) {
            int newIndex = indexCycle(index, delta);
            if (newIndex == initialIndex) {
                break;
            }
            index = newIndex;
            //
            Component component = mComponents[newIndex];
            if (component.isEnabled() && component.isVisible() && component.isFocusable()) {
                return component;
            }
        }
        // not found
        return currentComponent;
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // FocusTraversalPolicy
    //
    ////////////////////////////////////////////////////////////////////////////
    @Override
    public Component getComponentAfter(final Container container, final Component component) {
        return cycle(component, 1);
    }

    @Override
    public Component getComponentBefore(final Container container, final Component component) {
        return cycle(component, -1);
    }

    @Override
    public Component getFirstComponent(final Container container) {
        return mComponents[0];
    }

    @Override
    public Component getLastComponent(final Container container) {
        return mComponents[mComponents.length - 1];
    }

    @Override
    public Component getDefaultComponent(final Container container) {
        return getFirstComponent(container);
    }
}
