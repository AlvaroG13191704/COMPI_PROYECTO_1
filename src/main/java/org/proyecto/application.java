/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package org.proyecto;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.proyecto.Errors.LexicalError;
import org.proyecto.codeAFD.AFDCode;
import org.proyecto.codeAFD.objectJSON;
import org.proyecto.treeMethod.Tree;
import org.proyecto.treeMethod.followTable;
import org.proyecto.treeMethod.node;
import org.proyecto.treeMethod.transitionTable;

/**
 *
 * @author Beto
 */
public class application extends javax.swing.JFrame {

    /**
     * Creates new form application
     */
    public application() {
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

        nameFile = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        codeArea = new javax.swing.JTextArea();
        generateAnalyze = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consoleArea = new javax.swing.JTextArea();
        reportPanel = new javax.swing.JTabbedPane();
        TreesPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        listTree = new javax.swing.JList<>();
        showTreeImage = new java.awt.Button();
        jScrollPane3 = new javax.swing.JScrollPane();
        treeImage = new javax.swing.JLabel();
        FollowPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listFollow = new javax.swing.JList<>();
        showFollowImage = new java.awt.Button();
        treeImage1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        followImage = new javax.swing.JLabel();
        TransitionPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listTrans = new javax.swing.JList<>();
        showTransImage = new java.awt.Button();
        jScrollPane9 = new javax.swing.JScrollPane();
        TransImage = new javax.swing.JLabel();
        AutomatasPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listAutoma = new javax.swing.JList<>();
        showAutoImage = new java.awt.Button();
        jScrollPane10 = new javax.swing.JScrollPane();
        AutomaImage = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameFile.setText("Archivo: ");

        codeArea.setColumns(20);
        codeArea.setRows(5);
        jScrollPane1.setViewportView(codeArea);

        generateAnalyze.setLabel("Generar Autómata y Analizar Entrada");
        generateAnalyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateAnalyzeActionPerformed(evt);
            }
        });

        jLabel1.setText("Consola:");

        consoleArea.setColumns(20);
        consoleArea.disable();
        consoleArea.setRows(5);
        consoleArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(consoleArea);

        jScrollPane7.setViewportView(listTree);

        showTreeImage.setLabel("Mostrar Imagen");
        showTreeImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTreeImageActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(treeImage);

        javax.swing.GroupLayout TreesPanelLayout = new javax.swing.GroupLayout(TreesPanel);
        TreesPanel.setLayout(TreesPanelLayout);
        TreesPanelLayout.setHorizontalGroup(
            TreesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TreesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TreesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showTreeImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        TreesPanelLayout.setVerticalGroup(
            TreesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TreesPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(showTreeImage, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
            .addGroup(TreesPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        reportPanel.addTab("ÁRBOLES", TreesPanel);

        jScrollPane4.setViewportView(listFollow);

        showFollowImage.setLabel("Mostrar Imagen");
        showFollowImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showFollowImageActionPerformed(evt);
            }
        });

        jScrollPane8.setViewportView(followImage);

        javax.swing.GroupLayout FollowPanelLayout = new javax.swing.GroupLayout(FollowPanel);
        FollowPanel.setLayout(FollowPanelLayout);
        FollowPanelLayout.setHorizontalGroup(
            FollowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FollowPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FollowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showFollowImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(FollowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FollowPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(treeImage1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        FollowPanelLayout.setVerticalGroup(
            FollowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FollowPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(showFollowImage, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
            .addGroup(FollowPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane8)
                .addContainerGap())
            .addGroup(FollowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FollowPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(treeImage1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        reportPanel.addTab("SIGUIENTES", FollowPanel);

        jScrollPane5.setViewportView(listTrans);

        showTransImage.setLabel("Mostrar Imagen");
        showTransImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTransImageActionPerformed(evt);
            }
        });

        jScrollPane9.setViewportView(TransImage);

        javax.swing.GroupLayout TransitionPanelLayout = new javax.swing.GroupLayout(TransitionPanel);
        TransitionPanel.setLayout(TransitionPanelLayout);
        TransitionPanelLayout.setHorizontalGroup(
            TransitionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransitionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TransitionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showTransImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        TransitionPanelLayout.setVerticalGroup(
            TransitionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransitionPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(showTransImage, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
            .addGroup(TransitionPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane9)
                .addContainerGap())
        );

        reportPanel.addTab("TRANSICIONES", TransitionPanel);

        jScrollPane6.setViewportView(listAutoma);

        showAutoImage.setLabel("Mostrar Imagen");
        showAutoImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAutoImageActionPerformed(evt);
            }
        });

        jScrollPane10.setViewportView(AutomaImage);

        javax.swing.GroupLayout AutomatasPanelLayout = new javax.swing.GroupLayout(AutomatasPanel);
        AutomatasPanel.setLayout(AutomatasPanelLayout);
        AutomatasPanelLayout.setHorizontalGroup(
            AutomatasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AutomatasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AutomatasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showAutoImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        AutomatasPanelLayout.setVerticalGroup(
            AutomatasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AutomatasPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(showAutoImage, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
            .addGroup(AutomatasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );

        reportPanel.addTab("AUTÓMATAS", AutomatasPanel);

        fileMenu.setMnemonic('f');
        fileMenu.setText("ARCHIVO");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Abrir");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Guardar");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Guardar Como...");
        fileMenu.add(saveAsMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(generateAnalyze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                                    .addComponent(nameFile, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nameFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generateAnalyze, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(reportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
        // Open file
        String projectPath = System.getProperty("user.dir");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(projectPath + "/src/main/files"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File fileName = fileChooser.getSelectedFile();
        if (fileName == null || fileName.getName().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
        }
        try {
            assert fileName != null;
            FileReader in = new FileReader(fileName);
            BufferedReader br = new BufferedReader(in);
            String line = br.readLine();
            StringBuilder text = new StringBuilder();
            while (line != null) {
                text.append(line).append("\n");
                line = br.readLine();
            }
            br.close();
            in.close();
            codeArea.setText(text.toString());
            nameFile.setText("Archivo: " + fileName.getName());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Save
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw = new FileWriter(fileName);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(codeArea.getText());
                    bw.close();
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Se ha guardado el archivo correctamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Save as
        saveAsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.CANCEL_OPTION) {
                    return;
                }
                File fileName = fileChooser.getSelectedFile();
                if (fileName == null || fileName.getName().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    FileWriter fw = new FileWriter(fileName);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(codeArea.getText());
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void generateAnalyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateAnalyzeActionPerformed
        // TODO add your handling code here:
        // Import from parser and lexer
        Lexer lexer = new Lexer(new StringReader(codeArea.getText()));
        Parser parser = new Parser(lexer);
  
        try {
            parser.parse();
        } catch (Exception ex) {
            Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
        }

        // errors
        ArrayList<LexicalError> errors = new ArrayList<>();
        ArrayList<LexicalError> errorsLexer = lexer.errors;
        errors.addAll(errorsLexer);
        errors.addAll(parser.getErrors());
        try {
            generateHTMLErros(errors);
        } catch (IOException ex) {
            Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
        }

        // GENERATE THE GLOBAL ALPHABET
        Map<String, List<String>> globalAlphabet = new HashMap<>();
        for(String alphabet : parser.alphabet_1){ // First alphabet with the format a ~ z
            List<String> rangeList = new ArrayList<String>(); // create a list
            String[] range = alphabet.split("~"); // split the string by ~
            // iterate over the range
            for (int i = (int) range[1].charAt(0); i <= (int) range[2].charAt(0); i++) {
                char c = (char) i;
                rangeList.add(Character.toString(c));
            }
            globalAlphabet.put(range[0],  rangeList);
        }
        for(String alphabet : parser.alphabet_2){ // Second alphabet with the format a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
            List<String> rangeList = new ArrayList<String>(); // create a list
            String[] range = alphabet.split("~"); // split the string by ~
            // iterate over the range
            for (int i = 0; i < range[1].length(); i++) {
                rangeList.add(Character.toString(range[1].charAt(i)));
            }
            globalAlphabet.put(range[0],  rangeList);
        }
        // reverse the arraylist
        Collections.reverse(parser.identifiersName);
      
        String regularExpression = parser.results.get(0);
        // split the regular expression by NEXT
        String[] regularExpressionArray = regularExpression.split("NEXT");
        // remove the first element
        String[] regularExpressionArrayNew = Arrays.copyOfRange(regularExpressionArray, 1, regularExpressionArray.length);
        // iterate over the array
        StringBuilder printConsole = new StringBuilder();
        for (int i = 0; i < regularExpressionArrayNew.length; i++) {
            // Array of results
            ArrayList<objectJSON> resultsJSON = new ArrayList<>();
            
            // get the name of the regular expresion
            String regularExpresionName = parser.identifiersName.get(i);
            // remove the first and last character
            regularExpressionArrayNew[i] = regularExpressionArrayNew[i].substring(1, regularExpressionArrayNew[i].length() - 1);
            System.out.println(regularExpressionArrayNew[i]);
            // evaluate the index is the last of the array
            String expresionString;
            String replace = regularExpressionArrayNew[i].replace("[", "").replace("]", "");
            if(i == regularExpressionArrayNew.length - 1){
                // add to the arraylist # and the beginning and . and the end
                expresionString = "#," + replace.replace(" ","") + ",.";
            }else {
                // add to the arraylist # and the beginning and . and the end
                expresionString = "#," + replace.replace(" ","") + ".";
            }
            // GENERATE EACH TREE, TABLES AND AFD
            // create arraylist
            ArrayList<node> leaves = new ArrayList<>();
            ArrayList<ArrayList> table = new ArrayList<>();
            // Create the tree
            Tree tree = new Tree(expresionString,leaves, table );
            node raiz = tree.getRoot();
            raiz.getNode(); // DETERMINA SI LOS NODOS SON ANULABLES, SUS PRIMEROS Y ULTIMOS
            raiz.follow();
            System.out.println("==============================VALORES NODO ULTIMO . Y TABLA HOJAS ==============================");
            // Create a function to generate the graphviz code of the tree
            raiz.generateGraphviz(regularExpresionName);
            System.out.println("==============================TABLA SIGUIENTES==============================");
            followTable ft = new followTable();
            ft.printTable(table,regularExpresionName);
            System.out.println("=============================TABLA TRANSICIONES=============================");
            // create a new alphabet with words that are inside of leaves
            Map<String, List<String>> alphabet = new HashMap<>();
            for (node alp : leaves) {
                // elimante the elements inside of globalAlphabet
                if( globalAlphabet.containsKey(alp.lexeme)){
                    List<String> list = globalAlphabet.get(alp.lexeme);
                    alphabet.put(alp.lexeme, list);
                }
            }
            transitionTable tran = new transitionTable(raiz, table, leaves);
            tran.impTable(regularExpresionName);
            System.out.println("States -> " + tran.statesAFD);
            System.out.println("Alphabet -> " + alphabet );
            System.out.println("Transitions -> " + tran.transitionsAFD);
            System.out.println("Initial State -> " + tran.initialStateAFD);
            System.out.println("Accept States ->"+ tran.finalStatesAFD);
            System.out.println("============================= GRAPHVIZ AFD===============================================");
            tran.impGraph(regularExpresionName);
            System.out.println("============================= EVALUATE AFD ===============================================");
            // CREATE THE AFD
            // Variables declaration - do not modify                     
            AFDCode afd = new AFDCode(tran.statesAFD, alphabet, tran.transitionsAFD, tran.initialStateAFD, tran.finalStatesAFD);
            // EVALUATE THE SENTENCE inside the map with values in an array
            for (String sentence : parser.StringsToEvaluate.keySet()) {
                // get the value inside the map
                if(sentence.equals(regularExpresionName)){
                    String[] values = parser.StringsToEvaluate.get(sentence).toArray(new String[0]);
                    // iterate over the array
                    for(String val: values) {
                        // evaluate the sentence
                        String newVal = val.replace("\\", "");
                        System.out.println("Value: " + newVal);
                        boolean result = afd.accept(newVal);
                        System.out.println("Result: " + newVal);
                        // create a json object
                        if( result ) {
                            objectJSON obj = new objectJSON(newVal,regularExpresionName, "Cadena Válida");
                            
                            printConsole.append("La expresión: ").append(newVal).append(" Es válida con la expresión Regular -> ").append(regularExpresionName).append("\n");
                            resultsJSON.add(obj);
                        }else {
                            objectJSON obj = new objectJSON(val,regularExpresionName, "Cadena No Válida");
                            printConsole.append("La expresión: ").append(newVal).append(" No es válida con la expresión Regular -> ").append(regularExpresionName).append("\n");
                            resultsJSON.add(obj);
                        }
                    }
                    // GENERATE THE JSON FILE
                    generateJSON(resultsJSON, regularExpresionName);
                }
            }
        }
        // SHOW MESSAGE OF GOD
        JOptionPane.showMessageDialog(null, "Proceso Terminado");
        // SHOW IN THE TEXTAREA (CONSOLE)
        consoleArea.setText(printConsole.toString());
        // ADD TO THE LIST SWIG THE NAME OF THE regular expresions
        DefaultListModel<String> model = new DefaultListModel<>();
        for(String str: parser.identifiersName){
            model.addElement(str);
        }
        listTree.setModel(model);
        listFollow.setModel(model);
        listTrans.setModel(model);
        listAutoma.setModel(model);
    }//GEN-LAST:event_generateAnalyzeActionPerformed

    private void showFollowImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showFollowImageActionPerformed
        // TODO add your handling code here:
        // get the name from the list
         String name = listFollow.getSelectedValue();
        // show the image in the label
        ImageIcon image = new ImageIcon("E:\\2023\\QUINTO-SEMESTRE\\COMPILADORES-1\\LABORATORIO\\PROYECTO_1\\PROYECTO_1\\src\\main\\reports\\SIGUIENTES_202109567\\" + name + ".png");
        Image img = image.getImage();
        Image newimg =img.getScaledInstance(600, 595,  java.awt.Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(newimg);
        followImage.setIcon(newIcon);
        
    }//GEN-LAST:event_showFollowImageActionPerformed

    private void showTransImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTransImageActionPerformed
        // TODO add your handling code here:
        // get the name from the list
         String name = listTrans.getSelectedValue();
        // show the image in the label
        ImageIcon image = new ImageIcon("E:\\2023\\QUINTO-SEMESTRE\\COMPILADORES-1\\LABORATORIO\\PROYECTO_1\\PROYECTO_1\\src\\main\\reports\\TRANSICIONES_202109567\\" + name + ".png");
        Image img = image.getImage();
        Image newimg =img.getScaledInstance(600, 595,  java.awt.Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(newimg);
        TransImage.setIcon(newIcon);
    }//GEN-LAST:event_showTransImageActionPerformed

    private void showAutoImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAutoImageActionPerformed
        // TODO add your handling code here:
         // get the name from the list
         String name = listAutoma.getSelectedValue();
        // show the image in the label
        ImageIcon image = new ImageIcon("E:\\2023\\QUINTO-SEMESTRE\\COMPILADORES-1\\LABORATORIO\\PROYECTO_1\\PROYECTO_1\\src\\main\\reports\\AFD_202109567\\" + name + ".png");
        Image img = image.getImage();
        Image newimg =img.getScaledInstance(600, 595,  java.awt.Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(newimg);
        AutomaImage.setIcon(newIcon);
        
    }//GEN-LAST:event_showAutoImageActionPerformed

    private void showTreeImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTreeImageActionPerformed
        // TODO add your handling code here:
                 // get the name from the list
         String name = listTree.getSelectedValue();
        // show the image in the label
        ImageIcon image = new ImageIcon("E:\\2023\\QUINTO-SEMESTRE\\COMPILADORES-1\\LABORATORIO\\PROYECTO_1\\PROYECTO_1\\src\\main\\reports\\ARBOLES_202109567\\" + name + ".png");
        Image img = image.getImage();
        Image newimg =img.getScaledInstance(600, 595,  java.awt.Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(newimg);
        treeImage.setIcon(newIcon);
    }//GEN-LAST:event_showTreeImageActionPerformed

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
            java.util.logging.Logger.getLogger(application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new application().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AutomaImage;
    private javax.swing.JPanel AutomatasPanel;
    private javax.swing.JPanel FollowPanel;
    private javax.swing.JLabel TransImage;
    private javax.swing.JPanel TransitionPanel;
    private javax.swing.JPanel TreesPanel;
    private javax.swing.JTextArea codeArea;
    private javax.swing.JTextArea consoleArea;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel followImage;
    private java.awt.Button generateAnalyze;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList<String> listAutoma;
    private javax.swing.JList<String> listFollow;
    private javax.swing.JList<String> listTrans;
    private javax.swing.JList<String> listTree;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel nameFile;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JTabbedPane reportPanel;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private java.awt.Button showAutoImage;
    private java.awt.Button showFollowImage;
    private java.awt.Button showTransImage;
    private java.awt.Button showTreeImage;
    private javax.swing.JLabel treeImage;
    private javax.swing.JLabel treeImage1;
    // End of variables declaration//GEN-END:variables
    
    public static void generateJSON(ArrayList<objectJSON> results, String name) {
        String json = "[ \n";
        for (objectJSON obj : results) {
            json += "{ \n";
            json += "\"Valor\": \"" + obj.getValue() + "\", \n";
            json += "\"Expresion Regular\": \"" + obj.getNameRE() + "\",\n";
            json += "\"Resultado\": \"" + obj.getResult() + "\"\n";
            json += "},\n";
        }
        // remove the last character
        json = json.substring(0, json.length() - 1);
        json += "]\n";
        json = json.replace(",]", "\n]");
        // write the json file
        try (FileWriter file = new FileWriter("src/main/reports/SALIDAS_202109567/" + name + ".json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void generateHTMLErros(ArrayList<LexicalError> errors) throws IOException {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("src/main/reports/ERRORES_202109567/error.html");
            pw = new PrintWriter(fichero);
            pw.println("<!DOCTYPE html>");
            pw.println("<html lang=\"en\">");
            pw.println("<head>");
            pw.println("<meta charset=\"UTF-8\">");
            pw.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            //style
            pw.println("<style>");
            pw.println("table, th, td {");
            pw.println("border: 1px solid black;");
            pw.println("border-collapse: collapse;");
            pw.println("}");
            pw.println("th, td {");
            pw.println("padding: 15px;");
            pw.println("}");
            pw.println("th {");
            pw.println("text-align: left;");
            pw.println("}");
            pw.println("</style>");
            pw.println("<title>ERRORES</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h1>Errores</h1>");
            pw.println("<table>");
            pw.println("<tr>");
            pw.println("<th>Tipo</th>");
            pw.println("<th>Valor</th>");
            pw.println("<th>Descripcion</th>");
            pw.println("<th>Linea</th>");
            pw.println("<th>Columna</th>");
            pw.println("</tr>");
            for (LexicalError error : errors) {
                pw.println("<tr>");
                pw.println("<td>" + error.getType() + "</td>");
                pw.println("<td>" + error.getLexema() + "</td>");
                pw.println("<td>" + error.getMessage() + "</td>");
                pw.println("<td>" + error.getLine() + "</td>");
                pw.println("<td>" + error.getColumn() + "</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</body>");
            pw.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
