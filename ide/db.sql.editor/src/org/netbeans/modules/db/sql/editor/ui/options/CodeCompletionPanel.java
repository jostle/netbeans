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

package org.netbeans.modules.db.sql.editor.ui.options;

import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;
import javax.swing.JComponent;
import org.netbeans.modules.options.editor.spi.PreferencesCustomizer;
import org.openide.util.HelpCtx;

import static org.netbeans.modules.db.sql.editor.OptionsUtils.SQL_AUTO_COMPLETION_SUBWORDS;
import static org.netbeans.modules.db.sql.editor.OptionsUtils.SQL_AUTO_COMPLETION_SUBWORDS_DEFAULT;

public class CodeCompletionPanel extends javax.swing.JPanel {
    private final Preferences preferences;

    private final Map<String, Object> id2Saved = new HashMap<>();

    /** Creates new form FmtTabsIndents */
    @SuppressWarnings("this-escape")
    public CodeCompletionPanel(Preferences p) {
        initComponents();
        preferences = p;
        sqlAutoCompletionSubwords.setSelected(preferences.getBoolean(SQL_AUTO_COMPLETION_SUBWORDS, SQL_AUTO_COMPLETION_SUBWORDS_DEFAULT));

        id2Saved.put(SQL_AUTO_COMPLETION_SUBWORDS, sqlAutoCompletionSubwords.isSelected());
    }
    
    public static PreferencesCustomizer.Factory getCustomizerFactory() {
        return CodeCompletionPreferencesCustomizer::new;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        sqlAutoCompletionSubwords = new javax.swing.JCheckBox();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(sqlAutoCompletionSubwords, org.openide.util.NbBundle.getMessage(CodeCompletionPanel.class, "CodeCompletionPanel.sqlAutoCompletionSubwords.text")); // NOI18N
        sqlAutoCompletionSubwords.setToolTipText(org.openide.util.NbBundle.getMessage(CodeCompletionPanel.class, "CodeCompletionPanel.sqlAutoCompletionSubwords.toolTipText")); // NOI18N
        sqlAutoCompletionSubwords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqlAutoCompletionSubwordsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        add(sqlAutoCompletionSubwords, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(filler1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void sqlAutoCompletionSubwordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqlAutoCompletionSubwordsActionPerformed
        preferences.putBoolean(SQL_AUTO_COMPLETION_SUBWORDS, sqlAutoCompletionSubwords.isSelected());
    }//GEN-LAST:event_sqlAutoCompletionSubwordsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JCheckBox sqlAutoCompletionSubwords;
    // End of variables declaration//GEN-END:variables
    
    private static class CodeCompletionPreferencesCustomizer implements PreferencesCustomizer {

        private final Preferences preferences;
        private CodeCompletionPanel component;

        private CodeCompletionPreferencesCustomizer(Preferences p) {
            preferences = p;
        }

        @Override
        public String getId() {
            throw new UnsupportedOperationException("Not supported yet."); //NOI18N
        }

        @Override
        public String getDisplayName() {
            throw new UnsupportedOperationException("Not supported yet."); //NOI18N
        }

        @Override
        public HelpCtx getHelpCtx() {
            return new HelpCtx("netbeans.optionsDialog.editor.codeCompletion.sql"); //NOI18N
        }

        @Override
        public JComponent getComponent() {
            if (component == null) {
                component = new CodeCompletionPanel(preferences);
            }
            return component;
        }
    }

    String getSavedValue(String key) {
        return id2Saved.get(key).toString();
    }

    public static final class CustomCustomizerImpl extends PreferencesCustomizer.CustomCustomizer {

        @Override
        public String getSavedValue(PreferencesCustomizer customCustomizer, String key) {
            if (customCustomizer instanceof CodeCompletionPreferencesCustomizer) {
                return ((CodeCompletionPanel) customCustomizer.getComponent()).getSavedValue(key);
            }
            return null;
        }
    }
}
