package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class SoundListeners extends Thread implements  ActionListener{
	
	private Synthesizer synth;
	private MidiChannel[] channels;
	
	public SoundListeners(){
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
			channels = synth.getChannels();
			
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {						
			channels[12].noteOn( 60, 100 ); // C note
			TimeUnit.SECONDS.sleep(1);
			channels[12].noteOff(60);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public Synthesizer getSynth() {
		// TODO Auto-generated method stub
		return synth;
	}

}
