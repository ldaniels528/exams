package com.github.ldaniels528.exams.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Exam-Taker Panel
 *
 * @author lawrence.daniels@gmail.com
 */
@SuppressWarnings("serial")
class ExamPanel extends JPanel {
    // internal fields
    GridBagConstraints gbc;
    private GridBagLayout gbl;

    /**
     * Default constructor
     */
    ExamPanel() {
        super(true);

        // setup the appropriate font
        ExamFontManager.setDefaultFont(this);

        // setup the layout manager
        this.gbl = new GridBagLayout();
        this.gbc = getDefaultConstraints();
        super.setLayout(gbl);
    }

    /**
     * Returns the default constraints
     *
     * @return the default constraints
     */
    private GridBagConstraints getDefaultConstraints() {
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(1, 1, 1, 1);
        return gbc;
    }

    /**
     * Attaches the given component to the panel at the
     * given grid coordinates
     *
     * @param gridx the given x-coordinate within the grid
     * @param gridy the given y-coordinate within the grid
     * @param comp  the given {@link Component component}
     */
    void attach(final int gridx,
                final int gridy,
                final Component comp) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbl.setConstraints(comp, gbc);
        super.add(comp);
    }

    /**
     * Attaches the given component to the panel at the
     * given grid coordinates
     *
     * @param gridx  the given x-coordinate within the grid
     * @param gridy  the given y-coordinate within the grid
     * @param comp   the given {@link Component component}
     * @param anchor the given anchor value
     */
    void attach(final int gridx,
                final int gridy,
                final Component comp,
                final int anchor) {
        // save the current weights
        final double weightx = gbc.weightx;
        final double weighty = gbc.weighty;

        // attach the component
        gbc.anchor = anchor;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = 2;
        gbc.weighty = 2;
        gbl.setConstraints(comp, gbc);
        super.add(comp);

        // restore the previous weights
        gbc.weightx = weightx;
        gbc.weighty = weighty;
    }

}
