import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pad extends JFrame{
    

    private boolean isDrawing = false;
    private int drawRadius = 3;

    private enum tool {
        pencil, eraser, fill
    }

    private tool activeTool = tool.pencil;

    public Pad() {
        
        // Window Settings
        setTitle("My Swing Window");
        setSize(600, 800); // Set size to width: 400px, height: 300px
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
        getContentPane().setBackground(Color.WHITE);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Image Icons
        ImageIcon pencil = new ImageIcon("Icons/pencil.png");
        ImageIcon eraser = new ImageIcon("Icons/eraser.png");
        ImageIcon fill = new ImageIcon("Icons/paint-bucket.png");

        // Create buttons
        JButton pencilButton = new JButton(pencil);
        JButton eraserButton = new JButton(eraser);
        JButton fillButton = new JButton(fill);
                       
        pencilButton.setContentAreaFilled(false);
        eraserButton.setContentAreaFilled(false);
        fillButton.setContentAreaFilled(false);

        // Creating Button Border
        pencilButton.setBorder(BorderFactory.createEmptyBorder());
        eraserButton.setBorder(BorderFactory.createEmptyBorder());
        fillButton.setBorder(BorderFactory.createEmptyBorder());


        // Creating Button Actions
        pencilButton.addActionListener( e -> {
            activeTool = tool.pencil;
        });
    
        eraserButton.addActionListener( e -> {
            activeTool = tool.eraser;
        });

        pencilButton.addActionListener( e -> {
            activeTool = tool.fill;
        });
        // Add buttons to the panel
        buttonPanel.add(pencilButton);
        buttonPanel.add(eraserButton);
        buttonPanel.add(fillButton);

        // Add the button panel to the top of the frame
        add(buttonPanel, BorderLayout.NORTH);


        // Add mouse listener to the frame
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isDrawing = true; // Set drawing flag to true when mouse button is pressed
                drawPixel(e.getX(), e.getY()); // Draw pixel at the initial mouse click position
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDrawing = false; // Set drawing flag to false when mouse button is released
            }
        });

        // Add mouse motion listener to the frame
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDrawing) {
                    drawPixel(e.getX(), e.getY()); // Draw pixel at current mouse position while dragging
                }
            }
        });



    }


    // Method to draw a black pixel at the specified position
    private void drawPixel(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);

        switch(activeTool){
            case pencil:
                for (int i = -drawRadius; i <= drawRadius; i++) {
                    for (int j = -drawRadius; j <= drawRadius; j++) {
                        if (i * i + j * j <= drawRadius * drawRadius) {
                            g.fillRect(x + i, y + j, 1, 1);
                        }
                    }
                }
                break;
            case eraser:
                g.setColor(Color.WHITE);
                for (int i = -drawRadius; i <= drawRadius; i++) {
                    for (int j = -drawRadius; j <= drawRadius; j++) {
                        if (i * i + j * j <= drawRadius * drawRadius) {
                            g.fillRect(x + i, y + j, 1, 1);
                        }
                    }
                }
            case fill:
                break;
            default:
                break;
        }

        
    }


    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Pad window = new Pad();
            window.setVisible(true); // Set window to be visible


        });
    }




}
