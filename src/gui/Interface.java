package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Notes;
import main.SoundListeners;
import main.Standard;

public class Interface extends JFrame{
	private JPanel p;
	private Standard s;
	private Synthesizer synth;
	private SoundListeners sound;

	
	public Interface(){
		s = new Standard();
		sound = new SoundListeners();
		synth = sound.getSynth();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setName("Guitar thing");
		setBounds(20,20,800,500);
		drawPane();
		setVisible(true);
		addWindowStateListener(new WindowStateListener(){

			@Override
			public void windowStateChanged(WindowEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getOldState() == Frame.ICONIFIED){
					try {
						System.out.println("Opening synth.");
						synth.open();
					} catch (MidiUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("Failed.");
					}
				}else if(arg0.getNewState() == Frame.ICONIFIED){
					System.out.println("Closing synth.");
					synth.close();
				}
				
			}		
		});
		
	}
	
	private void drawPane(){
		BorderLayout b = new BorderLayout();
		JPanel pan = new JPanel();
		GridLayout frets = new GridLayout(6,12);
		pan.setLayout(frets);
		Notes[] tuning = s.getGuitarTuning();
		for(int i=0; i<6;i++){
			for(int j =0; j<12;j++){
				JButton but = new JButton();
				but.setText(tuning[i].increment(tuning[i],j).toString());
				but.setName(tuning[i].increment(tuning[i],j).toString()+","+i+","+j);
				but.addActionListener(sound);
				pan.add(but, -1);	
			}
			
		}
		
		getContentPane().setLayout(b);
		getContentPane().add(pan,BorderLayout.CENTER);
		
	}

}
