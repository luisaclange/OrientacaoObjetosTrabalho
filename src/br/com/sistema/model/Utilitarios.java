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
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tampelini
 */
public class Utilitarios {

    //metodo limparCampos
    
    public void LimpaTela(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
                
            }
        }
    }
    
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
    
}
