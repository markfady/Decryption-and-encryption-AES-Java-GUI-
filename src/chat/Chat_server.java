////////////////////////This Chat_Server Can Decrypt and encrypt
package chat;
import static chat.Chat_client.dout;
import java.io.DataInputStream;     //Reading data from input
import java.io.DataOutputStream;   //Java application generally uses the dataoutputstream to write data that can later be read by a data input stream.
import java.net.ServerSocket;      //Using serverSocket library to connect with another user
import java.net.Socket;
public class Chat_server extends javax.swing.JFrame {
AESAlgorithm aesAlgo;
static  ServerSocket ss;
static Socket s;                      //Using Socket Method to connect Server With user
static DataInputStream din;
static DataOutputStream dout;
private static byte[] keyValue= new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'e', 'S', 'c', 'r', 'e', 't', 'K', 'e', 'y' };  //The Key for Encryption
    public Chat_server() {
        initComponents();
        aesAlgo =new AESAlgorithm(keyValue);        //Passing the key to constractor
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        msg_text = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_area.setColumns(20);
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        msg_text.setText("Type Message , Then Click on Encrypt Message button after that Send!");
        msg_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_textActionPerformed(evt);
            }
        });

        jButton1.setText("Click To Encrypt The message!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Send Message");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Candara", 3, 18)); // NOI18N
        jLabel1.setText("Hello Server ! You can Send Normal Message To user , if you want to encrypt it.Click on The Button Then Send it ! ");

        jButton2.setText("Click To Decrypt The message !");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(msg_text, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_text))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_textActionPerformed

    }//GEN-LAST:event_msg_textActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
              //Encryption Button Settings
   String plaintext=msg_text.getText();          //We Should Start From Plain Text Then Pass it to AES Algorithm  taking text from Message_text(bottom left)
   String encryptedText=aesAlgo.encrypt(plaintext); //After That Every Single Character Should be Encrypted
   msg_text.setText(encryptedText);                //Encrypted Message will go to message_text .. then  Server choose to send it by clicking the button 
                                                   //Encrypted Message appears in message_Text (bottom Left)
                                                  //Or Delete it and type normal message and send it using (Send Message)Button
   
    } catch(Exception e) {
    e.printStackTrace();
    }
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  //Send Message Button Settings 
        try{
      String msgout="";
      msgout=msg_text.getText().trim();
      dout.writeUTF(msgout); }      //sending server message to the client 
      catch (Exception e){          //Handle the Exception here
      }
          }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       //Decryption Button Settings (Top Right)
        try {                                           
    String encryptedText=msg_area.getText();            //We Should Start Reverse the last step of Encryption
    String plainText=aesAlgo.decrypt(encryptedText);   //Taking The Encrypted Message from the message area (Top Left)
                                                      //after that action of decryption will process on every single Character in this field
    msg_text.setText(plainText);                //The Action Will return the value in Message Text Field (bottom left)           
    
    
}
catch(Exception e){
}
    }//GEN-LAST:event_jButton2ActionPerformed

 
     public  static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat_server().setVisible(true);
            }
        });
        /// Here we connect the User with the Server to start sending and receiving  Messages
      //Using Socket method 
    String msgin = "";
        try{
   
            ss=new ServerSocket(1201); //Server Start at port number 1201
            s= ss.accept();           //The Server now accept the port connection
            din=new DataInputStream(s.getInputStream());
            dout= new DataOutputStream(s.getOutputStream());
                
            while(!msgin.equals("exit")){
             msgin=din.readUTF();
             msg_area.setText(msg_area.getText().trim()+msgin);     //displaying  the message to msq_area(the place which text appears in GUI) From client
                
                
            }
            
        } catch(Exception e ){
        }
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JTextField msg_text;
    // End of variables declaration//GEN-END:variables

   
        }
    

