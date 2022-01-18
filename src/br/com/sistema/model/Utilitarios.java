/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.model;

import br.com.sistema.view.FrmTema;
import br.com.sistema.view.Frmmenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Tampelini
 */
public class Utilitarios {

    // Método para limpar campos das telas
    
    public void LimpaTela(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
                
            }
        }
    }
    
    // Método e atributos para escolher imagem para o sistema
    
    public void escolheImagem(FrmTema tema, JTextField txtFile){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Procurar imagem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem","jpg","png");

        fileChooser.setFileFilter(filter);

        int retorno = fileChooser.showOpenDialog(tema);

        if(retorno == JFileChooser.APPROVE_OPTION){

            File file = fileChooser.getSelectedFile();
            txtFile.setText(file.getPath());
        }
    }
    
    private static Color corPrimaria;
    private static Color corSecundaria;
    
    public String getCorPrimaria(){
        return corPrimaria.toString();
    }
    
    // Método para alterar cor primária
    
    public void setCorPrimaria(){
        JColorChooser escolheCor = new JColorChooser();
        
        this.corPrimaria = JColorChooser.showDialog(null, "Escolha a cor principal do sistema", Color.blue);
    }
    
    public String getCorSecundaria(){
        return corSecundaria.toString();
    }
    
    public void setCorSecundaria(){
        JColorChooser escolheCor = new JColorChooser();
        
        this.corSecundaria = JColorChooser.showDialog(null, "Escolha a cor secundária do sistema", Color.black);
    }
    
    public static void setAllCorPrimaria(Color color){
        corPrimaria = color;
    }
    
    public static void setAllCorSecundaria(Color color){
        corSecundaria = color;
    }
    
    // Gerenciamento de tema do sistema
    
    public static String[] getConfigJson() {
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        
        String arquivo = ".\\src\\config\\config.json";
        String[] tema = new String[4];
        try {
            try (FileReader f = new FileReader(arquivo)) {
                jsonObject = (JSONObject) parser.parse(f);
            }
            tema[0] = (String) jsonObject.get("Fundo");
            tema[1] = (String) jsonObject.get("Logo");
            tema[2] = (String) jsonObject.get("CorPrimaria");
            tema[3] = (String) jsonObject.get("CorSecundaria");

            return tema;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void setConfigJson(String fundo, String logo, String corPrimaria, String corSecundaria){
        FileWriter writeJson = null;
        String arquivo = ".\\src\\config\\config.json";
        JSONObject jsonObject = new JSONObject();
        
        try {
            //preenche o objeto com os campos do tema
            jsonObject.put("Fundo", fundo);
            jsonObject.put("Logo", logo);
            jsonObject.put("CorPrincipal", corPrimaria);
            jsonObject.put("CorSecundaria", corSecundaria);
            writeJson = new FileWriter(arquivo);
            writeJson.write(jsonObject.toString());
        } catch (IOException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writeJson.close();
            } catch (IOException ex) {
                Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
