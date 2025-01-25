/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.jshell.editor;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

/**
 * Flying panel with progress indicator and the stop button
 * @author sdedic
 */
final class ExecutingGlassPanel extends javax.swing.JPanel {

    /**
     * Creates new form ExecutingGlassPanel
     */
    public ExecutingGlassPanel() {
        initComponents();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        stopButton.setEnabled(true);
    }
    
    @NbBundle.Messages({
        "MSG_ExecutingGeneric=Executing, please wait",
        "# {0} - label/name for the executed task",
        "MSG_ExecutingWithLabel=Executing {0}, please wait"
    })
    public void setMessage(String label) {
        msgLabel.setText(label == null ? Bundle.MSG_ExecutingGeneric() : Bundle.MSG_ExecutingWithLabel(label));
    }

    public void addStopListener(ActionListener al) {
        this.stopButton.addActionListener(al);
        // prevent duplicate trigger
        this.stopButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msgLabel = new javax.swing.JLabel();
        stopButton = new javax.swing.JButton();

        setOpaque(false);

        msgLabel.setIcon(new ImageIcon(
            getClass().getClassLoader().getResource(
                "org/netbeans/modules/jshell/resources/wait16.gif"
            )
        ));
        org.openide.awt.Mnemonics.setLocalizedText(msgLabel, org.openide.util.NbBundle.getMessage(ExecutingGlassPanel.class, "ExecutingGlassPanel.msgLabel.text")); // NOI18N

        stopButton.setIcon(ImageUtilities.loadIcon("org/netbeans/modules/jshell/resources/stop.png"));
        org.openide.awt.Mnemonics.setLocalizedText(stopButton, org.openide.util.NbBundle.getMessage(ExecutingGlassPanel.class, "ExecutingGlassPanel.stopButton.text")); // NOI18N
        stopButton.setBorder(null);
        stopButton.setBorderPainted(false);
        stopButton.setContentAreaFilled(false);
        stopButton.setHideActionText(true);
        stopButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        stopButton.setIconTextGap(0);
        stopButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(msgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel msgLabel;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
