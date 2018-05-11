package view;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstFrame extends JFrame {

    public FirstFrame() {
        prepareFirstFrame();
    }

    private JButton randomLevelButton;
    private JButton defensiveLevelButton;
    private JButton smartLevelButton;
    private JButton multiplayerLevelButton;

    public JButton getRandomLevelButton() {
        return randomLevelButton;
    }

    public void setRandomLevelButton(JButton randomLevelButton) {
        this.randomLevelButton = randomLevelButton;
    }

    public JButton getDefensiveLevelButton() {
        return defensiveLevelButton;
    }

    public void setDefensiveLevelButton(JButton defensiveLevelButton) {
        this.defensiveLevelButton = defensiveLevelButton;
    }

    public JButton getSmartLevelButton() {
        return smartLevelButton;
    }

    public void setSmartLevelButton(JButton smartLevelButton) {
        this.smartLevelButton = smartLevelButton;
    }

    public JButton getMultiplayerLevelButton() {
        return multiplayerLevelButton;
    }

    public void setMultiplayerLevelButton(JButton multiplayerLevelButton) {
        this.multiplayerLevelButton = multiplayerLevelButton;
    }

    

    private void prepareFirstFrame() {
        
        defensiveLevelButton = new javax.swing.JButton();
        multiplayerLevelButton = new javax.swing.JButton();
        randomLevelButton = new javax.swing.JButton();
        smartLevelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        defensiveLevelButton.setText("Defensive Level");

        multiplayerLevelButton.setText("MultiPlayer");

        randomLevelButton.setText("Random Level");

        smartLevelButton.setText("Smart Level");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(defensiveLevelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(smartLevelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(randomLevelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(multiplayerLevelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defensiveLevelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randomLevelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(multiplayerLevelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(smartLevelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();

    }

}
