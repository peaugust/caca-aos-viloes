package osvinga.gui;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.SwingWorker;
import javax.swing.event.ListDataListener;
import osvinga.Artefato;
import osvinga.AtorJogador;
import osvinga.Carta;
import osvinga.Jogador;
import osvinga.Mesa;
import osvinga.Monte;
import osvinga.Personagem;
import osvinga.TipoPersonagem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author joaov
 */
public class InterfaceMesa extends javax.swing.JFrame {

    //Atributos:
    public AtorJogador atorJogador;

    /**
     * Creates new form MeuSwingzao
     */
    public InterfaceMesa(AtorJogador atorJogador) {
        this.atorJogador = atorJogador;
        initComponents();
        this.setVisible(true);
    }

    private InterfaceMesa() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaJogadorOponente = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaViloesJogadorOponente = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        vilao1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        monteDescarte = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        vilao2 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        listaJogadorInstancia = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        listaViloesJogadorInstancia = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuConectar = new javax.swing.JMenu();
        menuDesconectar = new javax.swing.JMenu();
        menuIniciarPartida = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listaJogadorOponente.setModel(new DefaultListModel());
        listaJogadorOponente.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        listaJogadorOponente.setVisibleRowCount(1);
        jScrollPane1.setViewportView(listaJogadorOponente);

        listaViloesJogadorOponente.setModel(new DefaultListModel());
        jScrollPane2.setViewportView(listaViloesJogadorOponente);

        vilao1.setModel(new DefaultListModel());
        vilao1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vilao1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(vilao1);

        jButton1.setText("Monte de Compra");
        jButton1.setMaximumSize(new java.awt.Dimension(39, 90));
        jButton1.setMinimumSize(new java.awt.Dimension(39, 90));
        jButton1.setPreferredSize(new java.awt.Dimension(39, 90));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        monteDescarte.setModel(new DefaultListModel());
        jScrollPane6.setViewportView(monteDescarte);

        vilao2.setModel(new DefaultListModel());
        jScrollPane7.setViewportView(vilao2);

        jButton2.setText("Pular Vez");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listaJogadorInstancia.setModel(new DefaultListModel());
        listaJogadorInstancia.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        listaJogadorInstancia.setVisibleRowCount(1);
        listaJogadorInstancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJogadorInstanciaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(listaJogadorInstancia);

        listaViloesJogadorInstancia.setModel(new DefaultListModel());
        jScrollPane9.setViewportView(listaViloesJogadorInstancia);

        jButton3.setText("Monte de Vilões");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        menuConectar.setText("Conectar");
        menuConectar.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuConectarMenuSelected(evt);
            }
        });
        menuConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuConectarMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuConectar);

        menuDesconectar.setText("Desconectar");
        menuDesconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDesconectarMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuDesconectar);

        menuIniciarPartida.setText("Iniciar Partida");
        menuIniciarPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIniciarPartidaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuIniciarPartida);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane8)
                        .addGap(122, 122, 122))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                        .addGap(57, 57, 57)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                        .addGap(38, 38, 38))))
                            .addComponent(jScrollPane1)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane7)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(56, 56, 56)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void listaJogadorInstanciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJogadorInstanciaMouseClicked
        if (evt.getClickCount() == 2) {
            DefaultListModel modelo = (DefaultListModel) this.listaJogadorInstancia.getModel();
            int indexSelecionado = listaJogadorInstancia.getSelectedIndex();
            if (indexSelecionado >= 0) {
                Carta carta = (Carta) modelo.getElementAt(indexSelecionado);
                if (carta instanceof Artefato) {
                    this.usarJoia((Artefato) carta);
                }
            }
        }
    }//GEN-LAST:event_listaJogadorInstanciaMouseClicked

    private void vilao1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vilao1MouseClicked
        DefaultListModel modeloHerois = (DefaultListModel) this.listaJogadorInstancia.getModel();
        int[] indiceHeroi = listaJogadorInstancia.getSelectedIndices();
        
        DefaultListModel modeloViloes = (DefaultListModel) this.vilao1.getModel();
        int indexVilao = this.vilao1.getSelectedIndex();
        
        Monte monte = new Monte();
        
        if (indexVilao >= 0) { //Recuperar o vilao
            Personagem vilao = (Personagem) modeloViloes.getElementAt(indexVilao);
            
            if (indiceHeroi.length >= 0) {//Pegar os herois selecionados:
                for (int i = 0; i < indiceHeroi.length; i++ ) {
                    monte.adicionarCarta((Personagem) modeloHerois.getElementAt(indiceHeroi[i]));
                }
                
                this.capturarVilao(vilao,monte);
                
            }
            
        }
    }//GEN-LAST:event_vilao1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (evt.getSource() == jButton2) {
            this.passarTurno();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void menuConectarMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuConectarMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_menuConectarMenuSelected

    private void menuConectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuConectarMouseClicked
        this.conectar();
    }//GEN-LAST:event_menuConectarMouseClicked

    private void menuDesconectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDesconectarMouseClicked
        this.desconectar();
    }//GEN-LAST:event_menuDesconectarMouseClicked

    private void menuIniciarPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIniciarPartidaMouseClicked
        this.iniciarPartida();
    }//GEN-LAST:event_menuIniciarPartidaMouseClicked

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
            java.util.logging.Logger.getLogger(InterfaceMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceMesa inter = new InterfaceMesa();
                inter.setVisible(true);

                DefaultListModel modelo = (DefaultListModel) inter.listaJogadorInstancia.getModel();
                modelo.add(0, new Personagem ("Thanos",100,TipoPersonagem.HEROI));
                modelo.add(0, new Personagem ("Thanos",100,TipoPersonagem.HEROI));
                modelo.add(0, new Personagem ("Thanos",100,TipoPersonagem.HEROI));
                DefaultListModel vilao1 = (DefaultListModel) inter.vilao1.getModel();
                vilao1.add(0, new Personagem ("Thanos",100,TipoPersonagem.VILAO));
                //DefaultListModel modelo = (DefaultListModel) jList7.getModel();
                //modelo.add(0, new Carta ("Thanos",100));
                System.out.println(inter.solictarEnderecoServidor());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList<String> listaJogadorInstancia;
    private javax.swing.JList<String> listaJogadorOponente;
    private javax.swing.JList<String> listaViloesJogadorInstancia;
    private javax.swing.JList<String> listaViloesJogadorOponente;
    private javax.swing.JMenu menuConectar;
    private javax.swing.JMenu menuDesconectar;
    private javax.swing.JMenu menuIniciarPartida;
    private javax.swing.JList<String> monteDescarte;
    private javax.swing.JList<String> vilao1;
    private javax.swing.JList<String> vilao2;
    // End of variables declaration//GEN-END:variables

    //Metodos:
    public void conectar() {
        this.atorJogador.conectar();
    }

    public String solictarEnderecoServidor() {
        return JOptionPane.showInputDialog(this, "Digite o Endereço do servidor:", "localhost");
    }

    public String solicitarNomeJogador() {
        return JOptionPane.showInputDialog(this, "Digite o Nome do Jogador:");
    }

    public void mostrarResultadoConectar(int resultado) {
        switch (resultado) {
            case 0:
                JOptionPane.showConfirmDialog(null, "Falha na Conexão.", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                break;
            case 1:
                JOptionPane.showConfirmDialog(null, "Sucesso em Conectar.", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                break;
            case 2:
                JOptionPane.showConfirmDialog(null, "Já Conectado.", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                break;
            case 3:
                JOptionPane.showConfirmDialog(null, "Arquivo Multiplayer Ausente.", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }

    public void iniciarPartida() {
        this.atorJogador.iniciarPartida();
    }

    public void notificarPartidaEmAndamento() {
        JOptionPane.showConfirmDialog(null, "Partida em Andamento.", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    public void notificarSucessoIniciarPartida() {
      //  JOptionPane.showConfirmDialog(null, "Sucesso em Iniciar a Partida.", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    public void notificarNaoConectado() {
        JOptionPane.showConfirmDialog(null, "Jogador não está conecatdo no servidor.", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    public void desconectar() {
        this.atorJogador.desconectar();
    }

    public void notificarDesconexao(boolean desconectou) {
        if (desconectou) {
            JOptionPane.showConfirmDialog(null, "Houve uma desconexão", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void passarTurno() {
        this.atorJogador.passarTurno();
    }

    public boolean solicitarConfirmacaoPassarTurno() {
        int escolha = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja passar o seu turno?", "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (escolha == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    public void notificarPassarTurno(boolean resultado) {
        if (resultado) {
            JOptionPane.showConfirmDialog(null, "Você passou seu turno.", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showConfirmDialog(null, "Não é o seu turno.", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void capturarVilao(Carta vilao, Monte monte) {
        this.atorJogador.capturarVilao(vilao, monte);
    }

    public boolean solicitarConfirmacaoCapturarVilao() {
        int reply = JOptionPane.showConfirmDialog(null, "Deseja capturar esse vilão??", "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (reply == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    public void informarCaputrarVilao(boolean mensagem) {
        if (mensagem) {
            JOptionPane.showConfirmDialog(null, "Você capturou o vilão com sucesso!", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showConfirmDialog(null, "Não foi possível capturar o vilão :(.", "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void atualizarInterface(Mesa mesa, int indexJogador) {
        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                //Atulizar vilao1:
        DefaultListModel modeloVilao1 = new DefaultListModel();
        modeloVilao1.add(0, mesa.getMonteVilaosAtivos().getCartas().get(0));
        InterfaceMesa.this.vilao1.setModel(modeloVilao1);
        //Atulziar vilao 2:
        DefaultListModel modeloVilao2 = new DefaultListModel();
        modeloVilao2.add(0, mesa.getMonteVilaosAtivos().getCartas().get(1));
        InterfaceMesa.this.vilao2.setModel(modeloVilao2);
        //Monte de descarte:
        DefaultListModel modeloMonteDescarte = new DefaultListModel();
        int iterador = 0;
        for (Carta carta : mesa.getMonteDescarte().getCartas()) {
            modeloMonteDescarte.add(iterador, carta);
            iterador++;
        }
        InterfaceMesa.this.monteDescarte.setModel(modeloMonteDescarte);
        //Atulizar a mostragem de cartas para o jogador dessa instancia do jogo:
        if (indexJogador == 0) {
            //Atulizar a lista de cartas do jogador:
            DefaultListModel modeloListaJogadorInstancia = new DefaultListModel();
            iterador = 0;
            for (Carta carta : mesa.getJogadores().get(0).getMao().getCartas()) {
                modeloListaJogadorInstancia.add(iterador, carta);
                iterador++;
            }
            InterfaceMesa.this.listaJogadorInstancia.setModel(modeloListaJogadorInstancia);

            //Atulizar a lista de viloes do jogador:
            DefaultListModel modeloListaViloesJogadorInstancia = new DefaultListModel();
            iterador = 0;
            for (Carta carta : mesa.getJogadores().get(0).getViloesCapturados().getCartas()) {
                modeloListaViloesJogadorInstancia.add(iterador, carta);
                iterador++;
            }
            InterfaceMesa.this.listaViloesJogadorInstancia.setModel(modeloListaViloesJogadorInstancia);

            //Atulizar a lista de cartas do jogador oponente:
            DefaultListModel modeloListaJogadorOponente = new DefaultListModel();
            iterador = 0;
            for (Carta carta : mesa.getJogadores().get(1).getMao().getCartas()) {
                modeloListaJogadorOponente.add(iterador, "Carta do Oponente");
                iterador++;
            }
            InterfaceMesa.this.listaJogadorOponente.setModel(modeloListaJogadorOponente);

            //Atulizar a lista de viloes do jogador oponente:
            DefaultListModel modeloListaViloesJogadorOponente = new DefaultListModel();
            iterador = 0;
            for (Carta carta : mesa.getJogadores().get(1).getViloesCapturados().getCartas()) {
                modeloListaViloesJogadorOponente.add(iterador, carta);
                iterador++;
            }
            InterfaceMesa.this.listaViloesJogadorOponente.setModel(modeloListaViloesJogadorOponente);

        } else {
            //Atulizar a lista de cartas do jogador:
            DefaultListModel modeloListaJogadorInstancia = new DefaultListModel();
            iterador = 0;
            for (Carta carta : mesa.getJogadores().get(1).getMao().getCartas()) {
                modeloListaJogadorInstancia.add(iterador, carta);
                iterador++;
            }
            InterfaceMesa.this.listaJogadorInstancia.setModel(modeloListaJogadorInstancia);

            //Atulizar a lista de viloes do jogador:
            DefaultListModel modeloListaViloesJogadorInstancia = new DefaultListModel();
            iterador = 0;
            for (Carta carta : mesa.getJogadores().get(1).getViloesCapturados().getCartas()) {
                modeloListaViloesJogadorInstancia.add(iterador, carta);
                iterador++;
            }
            InterfaceMesa.this.listaViloesJogadorInstancia.setModel(modeloListaViloesJogadorInstancia);

            //Atulizar a lista de cartas do jogador oponente:
            DefaultListModel modeloListaJogadorOponente = new DefaultListModel();
            iterador = 0;
            for (Carta carta : mesa.getJogadores().get(0).getMao().getCartas()) {
                modeloListaJogadorOponente.add(iterador, "Carta do Oponente");
                iterador++;
            }
            InterfaceMesa.this.listaJogadorOponente.setModel(modeloListaJogadorOponente);

            //Atulizar a lista de viloes do jogador oponente:
            DefaultListModel modeloListaViloesJogadorOponente = new DefaultListModel();
            iterador = 0;
            for (Carta carta : mesa.getJogadores().get(0).getViloesCapturados().getCartas()) {
                modeloListaViloesJogadorOponente.add(iterador, carta);
                iterador++;
            }
            InterfaceMesa.this.listaViloesJogadorOponente.setModel(modeloListaViloesJogadorOponente);
        }
        InterfaceMesa.this.repaint();
                return null;
            }
            
        }.execute();
        
    }

    public void notificarJogadorVencedor(Jogador aJogadorVencedor) {
        JOptionPane.showConfirmDialog(null, "O Jogador Vencedor é " + aJogadorVencedor.getNome() + ". Parabéns!!!", "Temos um vencedor" ,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    public void usarJoia(Artefato aCartaJoia) {
        boolean usarJoia = confirmarUtilizacaoJoia();
        if (usarJoia) {
            this.atorJogador.usarJoia(aCartaJoia);
        }
    }

    public boolean confirmarUtilizacaoJoia() {
        int reply = JOptionPane.showConfirmDialog(null, "Deseja utilizar o efeito da Joia??", "Confirmar a utilização", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (reply == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }
}
