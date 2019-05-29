
package view;

import control.DBAccess;
import java.util.ArrayList;
import model.Doctor;
import model.Patient;


public class Link extends javax.swing.JFrame {

    /**
     * Creates new form EditProfessor
     */
    public Link() {
        initComponents();
        fillCombo();
        ArrayList<Patient> patients;
        patients = this.getPatients();
        fillPatientCombo(patients);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboSSN = new javax.swing.JComboBox();
        butInfo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        butAssign = new javax.swing.JButton();
        comboDoctors = new javax.swing.JComboBox();
        comboPatients = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Assign Doctor to Patient");

        jLabel2.setText("branch");

        comboSSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSSNActionPerformed(evt);
            }
        });

        butInfo.setText("Get Doctors");
        butInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butInfoActionPerformed(evt);
            }
        });

        jLabel3.setText("Doctors");

        label.setText("Patient");

        butAssign.setText("Assign");
        butAssign.setEnabled(false);
        butAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAssignActionPerformed(evt);
            }
        });

        comboDoctors.setEnabled(false);
        comboDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDoctorsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(label)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(butAssign)
                                .addGap(0, 156, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboPatients, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboSSN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(butInfo))
                                    .addComponent(comboDoctors, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboSSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butInfo))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(comboPatients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(butAssign)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboSSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSSNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSSNActionPerformed

    private void butInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butInfoActionPerformed
        DBAccess dbAccess = new DBAccess();
        int branch_id = dbAccess.getBranchIdByName(comboSSN.getSelectedItem().toString());
        ArrayList<Doctor> doctors = dbAccess.getDoctorByBranch(branch_id);
        this.fillDoctorCombo(doctors);
        comboDoctors.setEnabled(true);
        butAssign.setEnabled(true);
    }//GEN-LAST:event_butInfoActionPerformed

    private void butAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAssignActionPerformed
        // TODO add your handling code here:
        DBAccess db = new DBAccess();
        Doctor doctor = db.getDoctorByName(comboDoctors.getSelectedItem().toString());
        Patient patient = db.getPatientByName(comboPatients.getSelectedItem().toString());
        if (db.assignDoctorToPatient(doctor, patient) == true) {
            System.out.println("Patient Assigned to Doctor!");
        }        
    }//GEN-LAST:event_butAssignActionPerformed

    private void comboDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDoctorsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDoctorsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Link.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Link.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Link.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Link.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Link().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAssign;
    private javax.swing.JButton butInfo;
    private javax.swing.JComboBox comboDoctors;
    private javax.swing.JComboBox comboPatients;
    private javax.swing.JComboBox comboSSN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables

    private void fillCombo() {

        comboSSN.removeAllItems();

        ArrayList<String> ssnList = new DBAccess().getAllBranches();

        for (int i = 0; i < ssnList.size(); i++) {
            comboSSN.addItem(ssnList.get(i));
        }
    }
    
    private void fillDoctorCombo(ArrayList<Doctor> doctors) {

        comboDoctors.removeAllItems();

        for (int i = 0; i < doctors.size(); i++) {
            comboDoctors.addItem(doctors.get(i).getName());
        }
    }
    
    private void fillPatientCombo(ArrayList<Patient> patients) {

        comboPatients.removeAllItems();

        for (int i = 0; i < patients.size(); i++) {
            comboPatients.addItem(patients.get(i).getName());
        }
    }

    private ArrayList<Patient> getPatients() {
        ArrayList<Patient> patients = new DBAccess().getAllPatients();
        
        return patients;
    }

}
