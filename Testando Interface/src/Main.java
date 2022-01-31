import java.awt.Graphics;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {    
        JFrame tela = new JFrame("Snake");
        tela.setSize(500, 500);
        tela.setVisible(true); 

        JPanel painelComQuadrado = new JPanel(){
            // Sobrescrevendo o m�todo 'paintComponent' do 'JPanel'.
            @Override public void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                int positionQ = 0;
                
                int distancia = 50;
                
                for(int i = 1; i <= 100; i++) {
                	
                	g.drawRect(positionQ, 50, 50, 50);
                    g.drawString("ola", positionQ + 20,70);
                    positionQ += 50;
                    
                }
                
            }
        };
        
        tela.add(painelComQuadrado);

        // Chamando 'revalidate' e 'repaint' porque o painel com o
        // quadrado foi inserido no JFrame ap�s o 'setVisible'.
        tela.revalidate();
        tela.repaint();
    }
}